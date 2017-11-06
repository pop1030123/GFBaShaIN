package com.popfu.gfbashain.module.in.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.presenter.ArticlePresenter;
import com.popfu.superswiperefreshlayout.SuperSwipeRefreshLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by pengfu on 04/11/2017.
 */
@EFragment
public class ArticleFragment extends Fragment {


    @ViewById(R.id.article_recyclerView)
    RecyclerView mArticleRecyclerView;

    @ViewById(R.id.swipe_refresh)
    SuperSwipeRefreshLayout swipeRefreshLayout ;

    private ArticlePresenter presenter;
    private ArticleAdapter adapter;
    private Context mContext;

    private String pageTitle ;

    public static  ArticleFragment_ newInstance(String pageTitle){
        ArticleFragment_ instance = new ArticleFragment_();
        Bundle bundle = new Bundle();
        bundle.putString("title", pageTitle);
        //fragment保存参数，传入一个Bundle对象
        instance.setArguments(bundle);
        return instance;
    }

    public String getPageTitle(){
        return pageTitle ;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        L.d("onCreateView");
        presenter = new ArticlePresenter();
        if(getArguments()!=null){
            //取出保存的值
           pageTitle = getArguments().getString("title");
        }
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        L.d("onAttach");
    }

    @AfterViews
    public void afterViews() {
        adapter = new ArticleAdapter(R.layout.item_article_picgroup, presenter.getData());

        mArticleRecyclerView.setAdapter(adapter);
        mArticleRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        swipeRefreshLayout.setHeaderView(createHeaderView());
        swipeRefreshLayout.setFooterView(createFooterView());
        swipeRefreshLayout.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                textView.setText("正在刷新");
//                imageView.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {
                textView.setText(enable ? "松开刷新" : "下拉刷新");
                if(enable){
                    imageView.setFreezesAnimation(true);
                }
//                imageView.setVisibility(View.VISIBLE);
//                imageView.setRotation(enable ? 180 : 0);
            }
        });
        swipeRefreshLayout.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {

                footerTextView.setText("正在加载...");
//                footerImageView.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        footerImageView.setVisibility(View.VISIBLE);
                        swipeRefreshLayout.setLoadMore(false);
                    }
                }, 2000);
            }

            @Override
            public void onPushDistance(int distance) {

            }

            @Override
            public void onPushEnable(boolean enable) {
                footerTextView.setText(enable ? "松开加载" : "上拉加载");
                footerImageView.setVisibility(View.VISIBLE);
//                footerImageView.setRotation(enable ? 0 : 180);
            }
        });
    }


    // Header View
    private TextView textView;
    private GifImageView imageView;

    // Footer View
    private TextView footerTextView;
    private GifImageView footerImageView;
    private View createFooterView() {
        View footerView = LayoutInflater.from(swipeRefreshLayout.getContext())
                .inflate(R.layout.layout_footer, null);
        footerImageView = (GifImageView) footerView
                .findViewById(R.id.footer_image_view);
        footerTextView = (TextView) footerView
                .findViewById(R.id.footer_text_view);
        footerImageView.setVisibility(View.VISIBLE);
//        footerImageView.setImageResource(R.drawable.down_arrow);
        footerTextView.setText("上拉加载更多...");
        return footerView;
    }

    private View createHeaderView() {
        View headerView = LayoutInflater.from(swipeRefreshLayout.getContext())
                .inflate(R.layout.layout_head, null);
        textView = (TextView) headerView.findViewById(R.id.text_view);
        textView.setText("下拉刷新");
        imageView = (GifImageView) headerView.findViewById(R.id.image_view);
        imageView.setVisibility(View.VISIBLE);
//        imageView.setImageResource(R.drawable.down_arrow);
        return headerView;
    }
}
