package com.example.a13616.cwmmusicplayer;

import java.util.ArrayList;

/**
 * Created by 13616 on 2018/6/12.
 */

public class MusicList {
    private static ArrayList<Music> musicarray=new ArrayList<Music>();
    private MusicList(){}
    public static ArrayList<Music> getMusicList(){
        return musicarray;
    }
}
