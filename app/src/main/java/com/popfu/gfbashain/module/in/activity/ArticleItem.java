package com.popfu.gfbashain.module.in.activity;

/**
 * Created by pengfu on 04/11/2017.
 */

public class ArticleItem {


    public ArticleItem(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    private String title ;
    private String pic ;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getImageResource(){
        return 0 ;
    }
}
