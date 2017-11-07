package com.popfu.gfbashain.module.login;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.popfu.gfbashain.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 07/11/2017.
 */
@EActivity(R.layout.activity_dologin)
public class DologinActivity extends Activity {


    public static boolean loginTag = false ;
    public static String name ;
    public static String pass ;

    @ViewById(R.id.iv_title_close)
    ImageView mClosePage ;

    @ViewById(R.id.et_user_name)
    EditText mUserName ;

    @ViewById(R.id.et_pwd)
    EditText mPass ;

    @ViewById(R.id.tv_forgot)
    TextView mForgot ;

    @ViewById(R.id.tv_reg)
    TextView mReg ;

    @ViewById(R.id.tv_login)
    TextView mLogin ;


    @Click(R.id.tv_login)
    public void onClickLogin(){
        name = mUserName.getText().toString() ;
        pass = mPass.getText().toString() ;
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this ,"请输入名字" ,Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this ,"请输入密码" ,Toast.LENGTH_SHORT).show();
            return;
        }
        // do login
        loginTag = true ;
        setResult(RESULT_OK);
        finish();
    }

    @Click(R.id.tv_forgot)
    public void onClickForgot(){
        RegOrForgotActivity_.intent(this)
//                .extra(KEY_TIME_UNIT ,unit)
                .start() ;
    }

    @Click(R.id.tv_reg)
    public void onClickReg(){

    }

    @Click(R.id.iv_title_close)
    public void onClickClose(){
        finish();
    }


}
