package com.example.a13616.cwmmusicplayer;

/**
 * Created by 13616 on 2018/6/12.
 */

public class Music {
    private String musicName;
    private String artistName;
    private String musicPath;
    private String musicDuration;

    //构造方法，没有返回值
    public void Music(String musicName1,String artistName1,String musicPath1,String musicDuration1){
        //this指当前这个对象
        this.musicName=musicName1;
        this.artistName=artistName1;
        this.musicPath=musicPath1;
        this.musicDuration=musicDuration1;
    }

    //普通方法，必须有返回值
    public String getSongName(){
        return this.musicName;
    }

    public String getArtistName(){
        return this.artistName;
    }

    public String getSongPath(){
        return this.musicPath;
    }

    public String getSongDuration(){
        return this.musicDuration;
    }
}
