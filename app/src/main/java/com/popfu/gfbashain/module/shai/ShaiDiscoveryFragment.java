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

    @ViewById(R.id.convenientBanner)
    ConvenientBanner mConvenientBanner;

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

        mConvenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, banners)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.custom_tab_indicator_selected, R.drawable.custom_tab_indicator_selected_focused})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        mConvenientBanner.startTurning(2000);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响
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
        List<ArticleFragment_> fragmentList;

        public ShaiDiscoveryAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
            fragmentList = new ArrayList<ArticleFragment_>();
            for (String page : pages) {
                fragmentList.add(ArticleFragment.newInstance(page));
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

    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }

}
