package com.popfu.gfbashain.module.in.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.util.DisplayUtils;
import com.popfu.gfbashain.widget.DetailScrollView;
import com.popfu.gfbashain.widget.SVRootLinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 08/11/2017.
 */
@EActivity(R.layout.activity_article)
public class ArticleActivity extends Activity {


    @ViewById(R.id.ll_root)
    LinearLayout rootLl ;

    @ViewById(R.id.scrollView)
    DetailScrollView mScrollView;

    //ScrollView 底部的布局LinearLayout
    @ViewById(R.id.ll_sv_root)
    SVRootLinearLayout mSVRootLl;


    @ViewById(R.id.tv_title)
    TextView titleView ;
    @ViewById(R.id.iv_icon)
    ImageView imageView ;

    @ViewById(R.id.content)
    LinearLayout mContent ;

    private int mContentTopOffsetNum;

    private int mContentBottomOffsetNum;

    private int statusBarHeight ;
    private boolean initData;

    //根布局的背景色
    private ColorDrawable mRootCDrawable;
    private int mColorInitAlpha = 0;
    @AfterViews
    public void afterViews(){
        Bundle bundle =  getIntent().getExtras() ;
        int top = bundle.getInt("top") ;
        statusBarHeight = bundle.getInt("statusBarHeight") ;
        ArticleItem data =(ArticleItem) getIntent().getExtras().getSerializable("data") ;
        titleView.setText(data.getTitle());
        imageView.setImageResource(data.getPicRes());

        mContentTopOffsetNum = top;

        Drawable contentDrawable = mContent.getBackground();
        mRootCDrawable = (ColorDrawable) contentDrawable;
        mRootCDrawable.setAlpha(mColorInitAlpha);

        /**
         *  activity 关闭回调
         */
        mSVRootLl.setOnCloseListener(new SVRootLinearLayout.OnCloseListener() {
            @Override
            public void onClose() {
                finish();
                overridePendingTransition(0, 0);
            }
        });

        mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(!initData) {
                    mContentBottomOffsetNum = mScrollView.getMeasuredHeight();
                    mSVRootLl.setInitBottom(0);
                    mSVRootLl.setAnimationStatus(true);
                    mSVRootLl.setLayoutImageView(true);
                    initData = true;
                    startAnimation();
                }
            }
        });

    }

    private void startAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1).setDuration(300);
        valueAnimator.setStartDelay(0);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float ratio = (float) animation.getAnimatedValue();
                //内容布局顶部偏移量
                int contentTopOffset = (int) (ratio * mContentTopOffsetNum);
                mRootCDrawable.setAlpha((int)(ratio*255));
                //内容布局底部偏移量
                int contentBottomOffset = (int) (ratio * mContentBottomOffsetNum);
//                L.d("ratio:"+ratio+":contentTopOffset:"+contentTopOffset+":contentBottomOffset:"+contentBottomOffset+":mContentBottomOffsetNum:"+mContentBottomOffsetNum+":mContentTopOffsetNum:"+mContentTopOffsetNum);
                mSVRootLl.setAllViewOffset(mContentTopOffsetNum - contentTopOffset, mContentBottomOffsetNum, 0, 0);
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mSVRootLl.setAnimationStatus(false);
//                mBottomLl.setVisibility(View.VISIBLE);
//                mContent.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { //按下的如果是BACK，同时没有重复
            if(mSVRootLl != null) mSVRootLl.startAnimation(mContentTopOffsetNum - statusBarHeight, false, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
