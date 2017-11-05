package com.popfu.gfbashain.module.shai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popfu.gfbashain.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pengfu on 05/11/2017.
 */
@EFragment
public class ShaiGroupFragment extends Fragment {

    @ViewById(R.id.shai_group_recyclerView)
    RecyclerView mGroupRecyclerView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shai_group, container, false);
        return view;
    }

}
