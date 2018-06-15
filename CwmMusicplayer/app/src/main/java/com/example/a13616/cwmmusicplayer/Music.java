package com.example.a13616.cwmmusicplayer;

/**
 * Created by 13616 on 2018/6/12.
 */

public class Music {
    private String musicName;
    private String musicArtist;
    private String musicPath;
    private String musicDuration;

    //构造方法，没有返回值,不能加void,否则报错
    public Music(String musicName1,String musicArtist1,String musicPath1,String musicDuration1){
        //this指当前这个对象
        this.musicName=musicName1;
        this.musicArtist=musicArtist1;
        this.musicPath=musicPath1;
        this.musicDuration=musicDuration1;
    }

    //普通方法，必须有返回值
    public String getMusicName(){
        return this.musicName;
    }

    public String getMusicArtist(){
        return this.musicArtist;
    }

    public String getMusicPath(){
        return this.musicPath;
    }

    public String getMusicDuration(){
        return this.musicDuration;
    }
}
