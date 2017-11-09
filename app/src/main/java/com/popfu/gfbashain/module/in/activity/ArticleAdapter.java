package com.popfu.gfbashain.module.in.activity;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.popfu.gfbashain.R;

import java.util.List;

public class ArticleAdapter extends BaseQuickAdapter<ArticleItem, BaseViewHolder> {
    public ArticleAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleItem item) {
        helper.setImageResource(R.id.iv_icon, item.getPicRes());
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_remark, item.getTitle());
        // 加载网络图片
//      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }

    @Nullable
    @Override
    public ArticleItem getItem(int position) {
        return super.getItem(position);
    }
}