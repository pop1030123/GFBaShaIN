package com.popfu.gfbashain.module.in.activity;

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
        helper.setText(R.id.tv_remark, item.getTitle());
        helper.setImageResource(R.id.iv_icon, R.drawable.image_placeholder);
        // 加载网络图片
//      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
}