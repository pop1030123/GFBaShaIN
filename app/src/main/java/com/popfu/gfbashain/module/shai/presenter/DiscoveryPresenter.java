package com.popfu.gfbashain.module.shai.presenter;

import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.in.activity.ArticleItem;
import com.popfu.gfbashain.module.shai.DiscoveryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 04/11/2017.
 */

public class DiscoveryPresenter {




    public List<DiscoveryItem> getData(){

        List<DiscoveryItem> datas = new ArrayList<>() ;
        datas.add(new DiscoveryItem("潮流货，温度再低也不能放弃时尚，万圣节将至快收好这些吸睛潮品" , R.drawable.demo_2)) ;
        datas.add(new DiscoveryItem("不知道奶色没关系，有口红资深玩家杨幂带你挑，每天唇色不一样" , R.drawable.demo_1)) ;

        return datas ;
    }
}
