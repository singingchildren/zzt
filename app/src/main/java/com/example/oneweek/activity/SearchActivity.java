package com.example.oneweek.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.oneweek.R;
import com.example.oneweek.weight.MyView;

public class SearchActivity extends AppCompatActivity {
    //初始化数据
    private String[] data = new String[]{"茶几","电动牙刷","尤妮亚","月永云力",
                                         "豆豆鞋","沐浴露","日东红茶","榴莲","阿比达斯",
                                         "虎马","粤利粤","雷碧","iApple","阿迪达布斯"};
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        myView = findViewById(R.id.myView);
        myView.setData(data);
    }
}
