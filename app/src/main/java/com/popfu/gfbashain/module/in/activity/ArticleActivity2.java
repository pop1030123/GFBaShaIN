package com.popfu.gfbashain.module.in.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.widget.PullZoomScrollView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 08/11/2017.
 */
@EActivity(R.layout.activity_article2)
public class ArticleActivity2 extends Activity {


    @ViewById(R.id.scrollview)
    PullZoomScrollView mScrollView;

    @ViewById(R.id.topimagecontainer)
    RelativeLayout mImageContainer;

    @ViewById(R.id.topimage)
    ImageView mImage ;
    @ViewById(R.id.tv_title)
    TextView mTitleView ;

    private int mContentTopOffsetNum;
    private int mContentBottomOffsetNum;

    private int statusBarHeight ;
    private boolean initData;

    //根布局的背景色
    private ColorDrawable mScrollDrawable;
    private int mColorInitAlpha = 0;
    @AfterViews
    public void afterViews(){
        Bundle bundle =  getIntent().getExtras() ;
        int top = bundle.getInt("top") ;
        statusBarHeight = bundle.getInt("statusBarHeight") ;
        ArticleItem data =(ArticleItem) getIntent().getExtras().getSerializable("data") ;
        mTitleView.setText(data.getTitle());
        mImage.setImageResource(data.getPicRes());
        mScrollView.mImageView = mImageContainer;
        mContentTopOffsetNum = top;

        Drawable contentDrawable = mScrollView.getBackground();
        mScrollDrawable = (ColorDrawable) contentDrawable;
        mScrollDrawable.setAlpha(mColorInitAlpha);

        mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(!initData) {
                    mContentBottomOffsetNum = mScrollView.getMeasuredHeight();
                    mScrollView.setAnimationStatus(true);
                    initData = true;
                    startAnimation();
                }
            }
        });

        /**
         *  activity 关闭回调
         */
        mScrollView.setOnCloseListener(new PullZoomScrollView.OnCloseListener() {
            @Override
            public void onClose() {
                finish();
                overridePendingTransition(0, 0);
            }
        });


        /**
         *  下拉拖动时候回调修改root背景色的透明度
         */
        mScrollView.setOnUpdateBgColorListener(new PullZoomScrollView.OnUpdateRatioListener() {
            @Override
            public void onUpdate(float ratio) {
                L.d("onUpdate:"+ratio);
                float alpha = (1-ratio)*155 ;
                mScrollDrawable.setAlpha((int)(alpha));
            }
        });
    }

    private void startAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1).setDuration(200);
        valueAnimator.setStartDelay(0);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float ratio = (float) animation.getAnimatedValue();
                //内容布局顶部偏移量
                int contentTopOffset = (int) (ratio * mContentTopOffsetNum);
                mScrollDrawable.setAlpha((int)(ratio*255));
                //内容布局底部偏移量
                mScrollView.setAllViewOffset(mContentTopOffsetNum - contentTopOffset, mContentBottomOffsetNum);
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mScrollView.setAnimationStatus(false);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { //按下的如果是BACK，同时没有重复
            if(mScrollView != null) mScrollView.finishAnimation(mContentTopOffsetNum - statusBarHeight, false, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
