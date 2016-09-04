package com.example.administrator.mylistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyListView lv;
    List<String> list;
    Myadapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (MyListView) findViewById(R.id.lv);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        ad = new Myadapter(list);
        lv.setAdapter(ad);
    }
}
