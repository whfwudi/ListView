package com.example.hy.androidtabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        tabHost = this.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_main,tabHost.getTabContentView(),true);
        tabHost.addTab(
                tabHost.newTabSpec("选项卡1")
                        .setIndicator("选项卡1",getResources().getDrawable(R.drawable.f1))
                        .setContent(R.id.linearLayout01)
        );
        tabHost.addTab(
                tabHost.newTabSpec("选项卡2")
                        .setIndicator("选项卡2",getResources().getDrawable(R.drawable.f2))
                        .setContent(R.id.linearLayout02)
        );
        tabHost.addTab(
                tabHost.newTabSpec("选项卡2")
                        .setIndicator("选项卡2",getResources().getDrawable(R.drawable.f3))
                        .setContent(R.id.linearLayout03)
        );

    }

}
