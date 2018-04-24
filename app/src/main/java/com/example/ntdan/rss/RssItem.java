package com.example.ntdan.rss;

import android.graphics.Bitmap;

/**
 * Created by ntdan on 4/21/2018.
 */
public class RssItem {
    String url ="";
    String title = "";
    Bitmap image;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public RssItem() {
    }

    public RssItem(String url, String title, Bitmap image) {
        this.url = url;
        this.title = title;
        this.image = image;
    }

}
