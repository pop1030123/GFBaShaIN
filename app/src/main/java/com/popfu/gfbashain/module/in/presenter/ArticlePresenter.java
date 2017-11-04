package com.popfu.gfbashain.module.in.presenter;

import com.popfu.gfbashain.module.in.activity.ArticleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 04/11/2017.
 */

public class ArticlePresenter {




    public List<ArticleItem> getData(){

        List<ArticleItem> datas = new ArrayList<>() ;
        for(int i=0 ;i<10 ;i++){
            datas.add(new ArticleItem("title "+i ,"pic"+i)) ;
        }

        return datas ;
    }
}
