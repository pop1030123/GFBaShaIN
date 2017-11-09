package com.popfu.gfbashain.module.login;

import android.app.Activity;

import com.popfu.gfbashain.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by pengfu on 07/11/2017.
 */
@EActivity(R.layout.activity_reg_or_forgot)
public class RegOrForgotActivity extends Activity {


    @AfterViews
    public void afterViews(){

    }



    @Click(R.id.iv_title_back)
    public void onClickBack(){
        finish();
    }
}
