package com.popfu.gfbashain.module.in.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.popfu.gfbashain.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 04/11/2017.
 */
@EFragment
public class ArticlePicGroupFragment extends Fragment {



    @ViewById(R.id.viewPager)
    ViewPager mViewPager ;

    @ViewById(R.id.tv_title)
    TextView mTitle ;

    private MyPagerAdapter myPagerAdapter ;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_pic_group, container, false);
        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager()) ;
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
    public void afterViews(){
        mViewPager.setAdapter(myPagerAdapter);

    }


    class MyPagerAdapter extends FragmentPagerAdapter {
        FragmentManager fm;

        List<ArticleFragment_> fragmentList ;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm ;
            fragmentList = new ArrayList<ArticleFragment_>() ;
            fragmentList.add(new ArticleFragment_()) ;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position) ;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
