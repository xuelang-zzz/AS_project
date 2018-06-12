package com.example.a13616.cwmmusicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity {
    //显示组件
    private ImageButton imageButton_backward;
    private ImageButton imageButton_play;
    private ImageButton imageButton_pause;
    private ImageButton imageButton_next;
    private ListView musicList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("xuelang musicplayer");
        findViews();
        registerListeners();
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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}




