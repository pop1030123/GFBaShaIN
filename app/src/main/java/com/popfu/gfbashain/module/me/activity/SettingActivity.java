package com.popfu.gfbashain.module.me.activity;

import android.app.Activity;

import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.login.DologinActivity;
import com.popfu.gfbashain.module.login.DologinActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by pengfu on 07/11/2017.
 */
@EActivity(R.layout.activity_setting)
public class SettingActivity extends Activity {


    @Click(R.id.tv_logout)
    public void onClickLogout(){
        DologinActivity_.loginTag = false ;
        DologinActivity_.name = null ;
        DologinActivity_.pass = null ;
        finish();
    }
}
