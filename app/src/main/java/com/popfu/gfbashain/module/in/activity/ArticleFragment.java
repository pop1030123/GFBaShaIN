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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        presenter = new ArticlePresenter();
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

    }

    @AfterViews
    public void afterViews() {
        adapter = new ArticleAdapter(R.layout.item_article_picgroup, presenter.getData());

        mArticleRecyclerView.setAdapter(adapter);
        mArticleRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }
}
