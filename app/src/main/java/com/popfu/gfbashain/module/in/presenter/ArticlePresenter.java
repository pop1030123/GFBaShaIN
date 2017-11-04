package com.popfu.gfbashain.module.in.presenter;

import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.activity.ArticleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 04/11/2017.
 */

public class ArticlePresenter {




    public List<ArticleItem> getData(){

        List<ArticleItem> datas = new ArrayList<>() ;
        datas.add(new ArticleItem("不知道奶色没关系，有口红资深玩家杨幂带你挑，每天唇色不一样" , R.drawable.demo_1)) ;
        datas.add(new ArticleItem("潮流货，温度再低也不能放弃时尚，万圣节将至快收好这些吸睛潮品" , R.drawable.demo_2)) ;

        return datas ;
    }
}
