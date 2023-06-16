package com.example.rvwithrvdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //通过双
    private RecyclerView rcl_main;
    private mainAdapter adapter;
    private ArrayList<CListdemo> listdemos;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        rcl_main = findViewById(R.id.rcl_main);
        adapter = new mainAdapter(this, listdemos);


        //设置布局管理器 , 将布局设置成纵向
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rcl_main.setLayoutManager(layoutManager);
        //设置分隔线
        rcl_main.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL));
        //设置增加或删除条目动画
        rcl_main.setItemAnimator(new DefaultItemAnimator());
        //填充数据
        rcl_main.setAdapter(adapter);
        //取消局部更新时闪烁动画
        ((SimpleItemAnimator) rcl_main.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    private void initdata() {
        listdemos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CListdemo demo = new CListdemo();
            demo.OrderNo = "00000" + i;
            demo.items = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Citem childitem = new Citem("","");
                childitem.setCode( i + "00" + j);
                childitem.setName("测试商品" + i + j);
                demo.items.add(childitem);
            }
            listdemos.add(demo);
        }
    }
}