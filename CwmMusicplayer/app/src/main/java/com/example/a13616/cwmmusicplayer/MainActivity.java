package com.example.a13616.cwmmusicplayer;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    //显示组件
    private ImageButton imageButton_backward;
    private ImageButton imageButton_play;
    private ImageButton imageButton_pause;
    private ImageButton imageButton_next;
    private ListView musicList;

    //歌曲列表对象
    private ArrayList<Music> musicArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("xuelang musicplayer");
        findViews();
        registerListeners();
        initMusicList();
        initListView();
        checkMusicFile();
    }

    //获取界面组件
    private void findViews(){
        imageButton_backward=(ImageButton) findViewById(R.id.imageButton1);
        imageButton_play=(ImageButton) findViewById(R.id.imageButton2);
        imageButton_pause=(ImageButton) findViewById(R.id.imageButton3);
        imageButton_next=(ImageButton) findViewById(R.id.imageButton4);
        musicList=(ListView) findViewById(R.id.listView);
    }

    //为界面组件注册监听器
    private void registerListeners(){
        imageButton_backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageButton_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageButton_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageButton_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //歌曲列表点击的是item
        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //position:适配器一个一个地item，并按照顺序放到listview中，该item是第position号做好的；
            //id：该item在listview的第几行的位置，当前item在listview中的相对位置。
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });
    }

    //初始化音乐列表对象
    private void initMusicList(){
        musicArrayList=MusicList.getMusicList();
        //isEmpty()用于判断容器是否有元素，有元素就返回false（1），否则返回ture（0）。
        //cursor:可随机访问的结果集，用于保存数据库的查询结果
        if(musicArrayList.isEmpty()){
            Cursor c=this.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Audio.Media.TITLE,
                                  MediaStore.Audio.Media.DURATION,
                                  MediaStore.Audio.Media.ALBUM,
                                  MediaStore.Audio.Media.ARTIST,
                                  MediaStore.Audio.Media._ID,
                                  MediaStore.Audio.Media.DATA,
                                  MediaStore.Audio.Media.DISPLAY_NAME},
                    null,null,MediaStore.Audio.AudioColumns.TITLE);

            if(c!=null) {
                //歌曲名
                int indexTitle = c.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
                //歌手名
                int indexArtist = c.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
                //路径
                int indexPath = c.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
                //总时长
                int indexTotalTime = c.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);

                //通过游标遍历数据库，并将Music类的对象加载到ArrayList中
                //moveToFirst():第一条不为空
                //!isAfterLast()：下一条不是最后一条
                //moveToNext()：下一条不为空
                for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                    String title = c.getString(indexTitle);
                    String artist = c.getString(indexArtist);
                    String path = c.getString(indexPath);
                    String totaltime = c.getString(indexTotalTime);

                    if(artist.equals("<unknown>")){
                        artist="无歌手名";
                    }
                    Music music=new Music(title,artist,path,totaltime);
                    musicArrayList.add(music);
                }
            }
        }
    }

    //设置适配器并初始化ListView
    private void initListView(){
        List<Map<String,String>> list_map=new ArrayList<Map<String,String>>();
        HashMap<String,String> hashMap;
        SimpleAdapter simpleAdapter;
        for(Music music:musicArrayList){
            hashMap=new HashMap<String,String>();
            hashMap.put("musicName",music.getMusicName());
            hashMap.put("musicArtist",music.getMusicArtist());
            list_map.add(hashMap);
        }
        String[] from=new String[]{"musicName","musicArtist"};
        int[] to=new int[]{R.id.music_name,R.id.music_artist};
        simpleAdapter=new SimpleAdapter(this,list_map,R.layout.listview,from,to);
        musicList.setAdapter(simpleAdapter);
    }


}




