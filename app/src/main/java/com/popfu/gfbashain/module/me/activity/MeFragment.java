package com.popfu.gfbashain.module.me.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.login.DologinActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 04/11/2017.
 */
@EFragment
public class MeFragment extends Fragment {



    @ViewById(R.id.tv_name)
    TextView mNameView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        return view;
    }


    @AfterViews
    public void afterViews(){

        mNameView.setText(DologinActivity_.name);
    }

}
