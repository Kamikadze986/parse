package com.example.parse;

import android.widget.ImageView;

public class Channels {
    String name_ru;
    String urlImg;
    String title;

    public Channels(String name_ru, String image,String title) {
        this.name_ru=name_ru;
        this.urlImg=image;
        this.title=title;
    }

    public void setName_ru(String  name_ru){
        this.name_ru=name_ru;
    }

    public void setUrlImg(String  urlImg){
        this.urlImg=urlImg;
    }

    public String getName_ru(){
        return name_ru;
    }

    public String getUrlImg(){
        return urlImg;
    }
}
