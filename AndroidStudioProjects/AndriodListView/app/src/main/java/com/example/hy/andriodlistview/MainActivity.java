package com.example.hy.andriodlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] drawableIds = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f5,
            R.drawable.f6};

    int[] msgIds = {
            R.string.andy,
            R.string.bill,
            R.string.edgar,
            R.string.torvalds,
            R.string.turing,
            R.string.andy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView)findViewById(R.id.listView01);

        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return drawableIds.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout ll = new LinearLayout(MainActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setPadding(5,5,5,5);

                ImageView ii = new ImageView(MainActivity.this);
                ii.setImageDrawable(getResources().getDrawable(drawableIds[position]));
                ii.setScaleType(ImageView.ScaleType.FIT_XY);
                ii.setLayoutParams(new LinearLayout.LayoutParams(100,98));
                ll.addView(ii);

                TextView tv = new TextView(MainActivity.this);
                tv.setText(getResources().getText(msgIds[position]));
                tv.setTextSize(24);
                ll.addView(tv);

                ImageView jj = new ImageView(MainActivity.this);
                jj.setImageDrawable(getResources().getDrawable(drawableIds[position]));
                jj.setScaleType(ImageView.ScaleType.FIT_XY);
                jj.setLayoutParams(new LinearLayout.LayoutParams(100,98));
                ll.addView(jj);

                return ll;
            }
        };
        lv.setAdapter(ba);

        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)findViewById(R.id.textView01);
                LinearLayout ll = (LinearLayout)view;
                TextView tvn = (TextView)ll.getChildAt(1);
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getText(R.string.ys));
                sb.append(":");
                sb.append(tvn.getText());
                String stemp = sb.toString();
                tv.setText(stemp.split("\\n")[0]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)findViewById(R.id.textView01);
                LinearLayout ll = (LinearLayout)view;
                TextView tvn = (TextView)ll.getChildAt(1);
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getText(R.string.ys));
                sb.append(":");
                sb.append(tvn.getText());
                String stemp = sb.toString();
                tv.setText(stemp.split("\\n")[0]);

            }
        });
    }
}
