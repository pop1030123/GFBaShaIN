package com.popfu.gfbashain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.popfu.gfbashain.module.in.activity.ArticlePicGroupFragment;
import com.popfu.gfbashain.module.in.activity.ArticlePicGroupFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import java.util.List;


@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    @ViewById(R.id.vp_content)
    ViewPager mViewPager ;


    @ViewsById({R.id.iv_tab_in ,R.id.iv_tab_shai,R.id.iv_tab_buy ,R.id.iv_tab_me})
    List<ImageView> tabImages ;

    ArticlePicGroupFragment_ moduleInFragment;
    ArticlePicGroupFragment_ moduleShaiFragment;
    ArticlePicGroupFragment_ moduleBuyFragment;
    ArticlePicGroupFragment_ moduleMeFragment;

    Fragment[] modules ;

    private MainPagerAdapter mainPagerAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.d("onCreate");
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager()) ;

        moduleInFragment = new ArticlePicGroupFragment_() ;
        moduleShaiFragment = new ArticlePicGroupFragment_() ;
        moduleBuyFragment = new ArticlePicGroupFragment_() ;
        moduleMeFragment = new ArticlePicGroupFragment_() ;
        modules = new Fragment[]{moduleInFragment ,moduleShaiFragment ,moduleBuyFragment ,moduleMeFragment} ;

    }


    @AfterViews
    public void afterViews(){
        L.d("afterViews");
        mViewPager.setAdapter(mainPagerAdapter);
    }

    @Click(R.id.iv_tab_in)
    public void clickModuleIn(){
        mViewPager.setCurrentItem(0);
    }

    @Click(R.id.iv_tab_shai)
    public void clickModuleShai(){
        mViewPager.setCurrentItem(1);
    }

    @Click(R.id.iv_tab_buy)
    public void clickModuleBuy(){
        mViewPager.setCurrentItem(2);
    }

    @Click(R.id.iv_tab_me)
    public void clickModuleMe(){
        mViewPager.setCurrentItem(3);
    }

    class MainPagerAdapter extends FragmentPagerAdapter {
        FragmentManager fm;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm ;
        }

        @Override
        public Fragment getItem(int position) {
            L.d("getItem:"+position);
            return modules[position] ;
        }

        @Override
        public int getCount() {
            return modules.length;
        }
    }
}
