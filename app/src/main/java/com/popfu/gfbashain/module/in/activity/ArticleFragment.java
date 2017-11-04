package com.popfu.gfbashain.module.in.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.presenter.ArticlePresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 04/11/2017.
 */
@EFragment
public class ArticleFragment extends Fragment {


    @ViewById(R.id.article_recyclerView)
    RecyclerView mArticleRecyclerView;

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

    }
}
