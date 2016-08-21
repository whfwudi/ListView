package com.example.hy.androidgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int[] darwableIds = {
            R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5
    };
    int[] nameIds = {
            R.string.andy,R.string.bill,R.string.edgar,R.string.torvalds,R.string.turing
    };

    int[] msgIds = {
            R.string.andy,R.string.bill,R.string.edgar,R.string.torvalds,R.string.turing
    };


    public List<? extends Map<String,?>> generateDataList(){
        ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        int rowCounter = darwableIds.length;
        for (int i = 0;i < darwableIds.length;i++)
        {
            HashMap<String,Object> hmap = new HashMap<String, Object>();
            hmap.put("col1",darwableIds[i]);
            hmap.put("col2",this.getResources().getString(nameIds[i]));
            hmap.put("col3",this.getResources().getString(msgIds[i]));

            list.add(hmap);
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv = (GridView)findViewById(R.id.gridView01);
        SimpleAdapter sca = new SimpleAdapter(
                this,
                generateDataList(),
                R.layout.grid_row,
                new  String[]{"col1","col2","col3"},
                new int[]{R.id.imageView01,R.id.textView02,R.id.textView03}
        );
        gv.setAdapter(sca);

        gv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)findViewById(R.id.textView01);
                LinearLayout ll = (LinearLayout)view;
                TextView tvn = (TextView)ll.getChildAt(1);
                TextView tvnl = (TextView)ll.getChildAt(2);
                StringBuilder sb = new StringBuilder();
                sb.append(tvn.getText());
                sb.append(" ");
                sb.append(tvnl.getText());
                tv.setText(sb.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)findViewById(R.id.textView01);
                LinearLayout ll = (LinearLayout)view;
                TextView tvn = (TextView)ll.getChildAt(1);
                TextView tvnl = (TextView)ll.getChildAt(2);
                StringBuilder sb = new StringBuilder();
                sb.append(tvn.getText());
                sb.append(" ");
                sb.append(tvnl.getText());
                tv.setText(sb.toString());
            }
        });
    }
}
