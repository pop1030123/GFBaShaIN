package com.popfu.gfbashain.module.shai;

/**
 * Created by pengfu on 04/11/2017.
 */

public class DiscoveryItem {


    public DiscoveryItem(String title, int picRes) {
        this.title = title;
        this.picRes = picRes;
    }

    private String title ;
    private int picRes ;


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
