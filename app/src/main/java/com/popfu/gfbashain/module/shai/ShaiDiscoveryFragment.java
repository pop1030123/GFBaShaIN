package com.popfu.gfbashain.module.shai;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.activity.ArticleFragment;
import com.popfu.gfbashain.module.in.activity.ArticleFragment_;
import com.viewpagerindicator.TabPageIndicator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pengfu on 05/11/2017.
 */
@EFragment
public class ShaiDiscoveryFragment extends Fragment {


    @ViewById(R.id.pageIndicator)
    TabPageIndicator mTabPageIndicator;


    @ViewById(R.id.viewPager)
    ViewPager mViewPager;

    private ShaiDiscoveryAdapter mShaiDiscoveryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shai_discovery, container, false);
        return view;
    }

    @AfterViews
    public void afterViews() {
        mShaiDiscoveryAdapter = new ShaiDiscoveryAdapter(getChildFragmentManager());

        mViewPager.setAdapter(mShaiDiscoveryAdapter);
        mTabPageIndicator.setViewPager(mViewPager);
    }

    private static List<Integer> banners = Arrays.asList(
            R.drawable.demo_banner_0,
            R.drawable.demo_banner_1,
            R.drawable.demo_banner_2,
            R.drawable.demo_banner_3,
            R.drawable.demo_banner_4,
            R.drawable.demo_banner_5);
    private static String[] pages = {"推荐", "美物", "美食", "时装", "美妆", "穿搭", "插画", "最新"};

    class ShaiDiscoveryAdapter extends FragmentPagerAdapter {
        FragmentManager fm;
        List<DiscoveryFragment_> fragmentList;

        public ShaiDiscoveryAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
            fragmentList = new ArrayList<DiscoveryFragment_>();
            for (int i =0 ;i<pages.length ;i++) {
                int bannerIndex = i%2 ; // 3个banner 一组
                List<Integer> pageBanner = banners.subList(bannerIndex*3 ,bannerIndex*3+3) ;
                fragmentList.add(DiscoveryFragment.newInstance(new ArrayList<Integer>(pageBanner)));
            }
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
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
