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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.widget.DetailScrollView;
import com.popfu.gfbashain.widget.PullZoomScrollView;
import com.popfu.gfbashain.widget.SVRootLinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 08/11/2017.
 */
@EActivity(R.layout.activity_article2)
public class ArticleActivity2 extends Activity {


    @ViewById(R.id.scrollview)
    PullZoomScrollView mView;

    @ViewById(R.id.topimagecontainer)
    RelativeLayout mImageContainer;

    @ViewById(R.id.topimage)
    ImageView mImage ;

    private int mContentTopOffsetNum;


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
//        titleView.setText(data.getTitle());
        mImage.setImageResource(data.getPicRes());
        mView.mImageView = mImageContainer;
        mContentTopOffsetNum = top;

//        Drawable contentDrawable = mContent.getBackground();
//        mRootCDrawable = (ColorDrawable) contentDrawable;
//        mRootCDrawable.setAlpha(mColorInitAlpha);


    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { //按下的如果是BACK，同时没有重复
//            if(mSVRootLl != null) mSVRootLl.finishAnimation(mContentTopOffsetNum - statusBarHeight, false, 0);
//            return true;
//        }
        return super.onKeyDown(keyCode, event);
    }
}
