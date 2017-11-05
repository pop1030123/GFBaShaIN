package com.popfu.gfbashain.module.shai;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.popfu.gfbashain.L;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.activity.ArticleAdapter;
import com.popfu.gfbashain.module.in.activity.ArticleFragment_;
import com.popfu.gfbashain.module.in.presenter.ArticlePresenter;
import com.popfu.gfbashain.module.shai.presenter.DiscoveryPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 04/11/2017.
 */
@EFragment
public class DiscoveryFragment extends Fragment {


    @ViewById(R.id.discovery_recyclerView)
    RecyclerView mDiscoveryRecyclerView;

    @ViewById(R.id.convenientBanner)
    ConvenientBanner mConvenientBanner;

    private DiscoveryPresenter presenter;
    private DiscoveryAdapter adapter;
    private Context mContext;

    private List<Integer> banners ;

    public static  DiscoveryFragment_ newInstance(ArrayList<Integer> banners){
        DiscoveryFragment_ instance = new DiscoveryFragment_();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("banner", banners);
        //fragment保存参数，传入一个Bundle对象
        instance.setArguments(bundle);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);
        L.d("onCreateView");
        presenter = new DiscoveryPresenter();
        if(getArguments()!=null){
            //取出保存的值
           banners = getArguments().getIntegerArrayList("banner");
        }
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        L.d("onAttach");
    }

    @AfterViews
    public void afterViews() {
        adapter = new DiscoveryAdapter(R.layout.item_article_picgroup, presenter.getData());

        mDiscoveryRecyclerView.setAdapter(adapter);
        mDiscoveryRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

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
