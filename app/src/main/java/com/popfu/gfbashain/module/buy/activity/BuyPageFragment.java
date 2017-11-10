package com.popfu.gfbashain.module.buy.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.buy.adapter.ProductPageAdapter;
import com.popfu.gfbashain.module.buy.bean.ProductItem;
import com.popfu.gfbashain.module.buy.presenter.ProductPresenter;
import com.popfu.gfbashain.module.in.activity.ArticleActivity_;
import com.popfu.gfbashain.module.in.activity.ArticleAdapter;
import com.popfu.gfbashain.module.in.activity.ArticleFragment_;
import com.popfu.gfbashain.module.in.presenter.ArticlePresenter;
import com.popfu.superswiperefreshlayout.SuperSwipeRefreshLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import pl.droidsonroids.gif.GifImageView;

import static android.view.View.GONE;

/**
 * Created by pengfu on 04/11/2017.
 */
@EFragment
public class BuyPageFragment extends Fragment {


    @ViewById(R.id.buy_page_recyclerView)
    RecyclerView mBuyPageRecyclerView;

    @ViewById(R.id.swipe_refresh)
    SuperSwipeRefreshLayout swipeRefreshLayout ;

    private ProductPresenter presenter;
    private ProductPageAdapter adapter;
    private Context mContext;

    private String pageTitle ;

    public static  BuyPageFragment_ newInstance(String pageTitle){
        BuyPageFragment_ instance = new BuyPageFragment_();
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
        View view = inflater.inflate(R.layout.fragment_buy_page, container, false);
        L.d("onCreateView");
        presenter = new ProductPresenter();
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
        adapter = new ProductPageAdapter(R.layout.list_item_product, presenter.getData());

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BuyDetailActivity_.intent(getContext())
                        .extra("data" ,((ProductItem)adapter.getItem(position)))
                        .start();
            }
        });
        mBuyPageRecyclerView.setAdapter(adapter);
        mBuyPageRecyclerView.setLayoutManager(new GridLayoutManager(getContext() ,2));

        swipeRefreshLayout.setHeaderView(createHeaderView());
        swipeRefreshLayout.setFooterView(createFooterView());
        swipeRefreshLayout.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                headGifView.setVisibility(View.VISIBLE);
                headLoadView.setVisibility(View.GONE);
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
                headGifView.setVisibility(GONE);
                headLoadView.setVisibility(View.VISIBLE);
                headLoadView.setImageResource(enable ? R.drawable.load_pull_1: R.drawable.load_pull_0);
            }
        });
        swipeRefreshLayout.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                footGifView.setVisibility(View.VISIBLE);
                footLoadView.setVisibility(GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setLoadMore(false);
                    }
                }, 2000);
            }

            @Override
            public void onPushDistance(int distance) {

            }

            @Override
            public void onPushEnable(boolean enable) {
                footGifView.setVisibility(GONE);
                footLoadView.setVisibility(View.VISIBLE);
                footLoadView.setImageResource(enable ? R.drawable.load_pull_1: R.drawable.load_pull_0);
            }
        });
    }


    // Header View
    private GifImageView headGifView;
    private ImageView headLoadView;

    // Footer View
    private GifImageView footGifView;
    private ImageView footLoadView;
    private View createFooterView() {
        View footerView = LayoutInflater.from(swipeRefreshLayout.getContext())
                .inflate(R.layout.layout_footer, null ,false);
        footGifView = (GifImageView) footerView
                .findViewById(R.id.gif_view);
        footLoadView = footerView.findViewById(R.id.load_view) ;
        return footerView;
    }

    private View createHeaderView() {
        View headerView = LayoutInflater.from(swipeRefreshLayout.getContext())
                .inflate(R.layout.layout_head, null ,false);
        headLoadView = headerView.findViewById(R.id.load_view) ;
        headGifView = (GifImageView) headerView.findViewById(R.id.gif_view);
        return headerView;
    }
}
