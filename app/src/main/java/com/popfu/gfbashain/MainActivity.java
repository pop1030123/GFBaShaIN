package com.popfu.gfbashain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.popfu.gfbashain.module.in.activity.ArticlePicGroupFragment;
import com.popfu.gfbashain.module.in.activity.ArticlePicGroupFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import java.lang.reflect.Field;
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
        // 因为默认显示是第一个页面，所以第一个按钮的状态变为选中状态
        updateTabState(tabImages.get(0)) ;
        mViewPager.setPageTransformer(false ,new SimplePageTransform());


        try {
            //设置滚动切换的动画时间
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(this,
                    new DecelerateInterpolator());
            field.set(mViewPager, scroller);
            scroller.setmDuration(350);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Click(R.id.iv_tab_in)
    public void clickModuleIn(ImageView imageView){
        L.d("click0:"+imageView);
        mViewPager.setCurrentItem(0 ,true);
        updateTabState(imageView) ;
    }

    @Click(R.id.iv_tab_shai)
    public void clickModuleShai(ImageView imageView){
        L.d("click1:"+imageView);
        mViewPager.setCurrentItem(1,true);
        updateTabState(imageView) ;
    }

    @Click(R.id.iv_tab_buy)
    public void clickModuleBuy(ImageView imageView){
        L.d("click2:"+imageView);
        mViewPager.setCurrentItem(2,true);
        updateTabState(imageView) ;
    }

    @Click(R.id.iv_tab_me)
    public void clickModuleMe(ImageView imageView){
        L.d("click3:"+imageView);
        mViewPager.setCurrentItem(3,true);
        updateTabState(imageView) ;
    }

    private void updateTabState(ImageView clickView){
        for(ImageView tabView : tabImages){
            if(clickView == tabView){
                tabView.setSelected(true);
            }else{
                tabView.setSelected(false);
            }
        }
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
