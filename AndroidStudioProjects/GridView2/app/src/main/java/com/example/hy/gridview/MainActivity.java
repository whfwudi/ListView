package com.example.hy.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private GridView gview;
    private List<Map<String,Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[]icon = {R.drawable.pic,R.drawable.pic,
            R.drawable.pic,R.drawable.pic,
            R.drawable.pic,R.drawable.pic,
            R.drawable.pic,R.drawable.pic,
            R.drawable.pic,R.drawable.pic,
            R.drawable.pic,R.drawable.pic};
    private String[]iconName = {"通讯录","通讯录",
            "通讯录","通讯录",
            "通讯录","通讯录",
            "通讯录","通讯录",
            "通讯录","通讯录",
            "通讯录","通讯录"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        gview = (GridView)findViewById(R.id.gview);
        data_list = new ArrayList<Map<String,Object>>();
        getData();
        String[]from={"image","text"};
        int[]to={R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this,data_list,R.layout.item,from,to);
        gview.setAdapter(sim_adapter);
    }

    public List<Map<String,Object>> getData()
    {
        for (int i = 0;i < icon.length;i++)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

}
