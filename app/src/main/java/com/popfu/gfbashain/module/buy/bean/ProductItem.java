package com.popfu.gfbashain.module.buy.bean;

import java.io.Serializable;

/**
 * Created by pengfu on 04/11/2017.
 */

public class ProductItem implements Serializable {


    public ProductItem(String title, int picRes ,String tag ,String count) {
        this.title = title;
        this.picRes = picRes;
        this.count = count ;
        this.tag = tag ;
    }

    private String title ;
    private String tag ;
    private String count ;
    private int picRes ;


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getPicRes() {
        return picRes;
    }

    public void setPicRes(int picRes) {
        this.picRes = picRes;
    }
}
