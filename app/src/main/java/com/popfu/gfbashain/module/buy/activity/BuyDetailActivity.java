package com.popfu.gfbashain.module.buy.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.popfu.gfbashain.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 10/11/2017.
 */
@EActivity(R.layout.activity_buy_detail)
public class BuyDetailActivity extends Activity {


    @ViewById(R.id.video)
    VideoView videoView ;

    @AfterViews
    public void afterViews(){

        MediaController  mMediaController = new MediaController(this);
        videoView.setMediaController(mMediaController);
        loadView("blob:https://v.qq.com/0d6ce07b-85fb-48d7-b777-eff8e4ef283a");
    }


    public void loadView(String path) {
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();// 播放
                Toast.makeText(BuyDetailActivity.this, "开始播放！", Toast.LENGTH_LONG).show();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(BuyDetailActivity.this, "播放完毕", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
