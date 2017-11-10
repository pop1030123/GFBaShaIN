package com.popfu.gfbashain.module.buy.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.buy.bean.ProductItem;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class ProductPageAdapter extends BaseQuickAdapter<ProductItem, BaseViewHolder> {
    public ProductPageAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductItem item) {
//        helper.setImageResource(R.id.iv_icon, item.getPicRes());
        Glide.with(mContext).load(item.getPicRes())
                .apply(bitmapTransform(new RoundedCornersTransformation(5 ,0)))
                .into((ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tag_text, item.getTag());
        helper.setText(R.id.tv_subTitle, item.getCount()+"人观看");
        // 加载网络图片
//      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }

    @Nullable
    @Override
    public ProductItem getItem(int position) {
        return super.getItem(position);
    }
}