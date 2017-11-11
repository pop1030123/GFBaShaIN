package com.popfu.gfbashain.module.buy.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.buy.bean.ProductItem;

import java.util.List;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class ProductPageAdapter extends BaseQuickAdapter<ProductItem, BaseViewHolder> {
    public ProductPageAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductItem item) {
        Glide.with(mContext).load(item.getPicRes())
                .apply(bitmapTransform(new RoundedCorners(10)))
                .into((ImageView) helper.getView(R.id.iv_icon));
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tag_text, item.getTag());
        helper.setText(R.id.tv_subTitle, item.getCount()+"人观看");
    }

    @Nullable
    @Override
    public ProductItem getItem(int position) {
        return super.getItem(position);
    }
}