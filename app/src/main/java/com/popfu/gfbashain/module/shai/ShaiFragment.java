package com.popfu.gfbashain.module.shai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kwan.base.widget.SlidingTabLayout;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.activity.ArticleFragment;
import com.popfu.gfbashain.module.in.activity.ArticleFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 05/11/2017.
 */
@EFragment
public class ShaiFragment extends Fragment {

    @ViewById(R.id.viewPager)
    ViewPager mViewPager ;

    @ViewById(R.id.stl_shai_tabs)
    SlidingTabLayout tabLayout ;

    private ShaiPagerAdapter mShaiPagerAdapter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shai, container, false);
        mShaiPagerAdapter = new ShaiPagerAdapter(getChildFragmentManager()) ;
        return view;
    }


    @AfterViews
    public void afterViews(){
        tabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return R.color.abc_primary_text_material_light;
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });


        mViewPager.setAdapter(mShaiPagerAdapter);
        tabLayout.setViewPager(mViewPager);
    }

    private static String[] pages = {"发现" ,"圈子" ,"活动"} ;
    class ShaiPagerAdapter extends FragmentPagerAdapter {
        FragmentManager fm;
        List<Fragment> fragmentList ;



        public ShaiPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm ;
            fragmentList = new ArrayList<Fragment>() ;
            fragmentList.add(new ShaiDiscoveryFragment_()) ;
            fragmentList.add(new ShaiGroupFragment_()) ;
            fragmentList.add(new ShaiDiscoveryFragment_()) ;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position) ;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pages[position];
        }
    }

}
