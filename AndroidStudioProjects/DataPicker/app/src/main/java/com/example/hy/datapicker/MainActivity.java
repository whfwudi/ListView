package com.example.hy.datapicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TextView textView;
    Calendar calendar;
    int cur_year,cur_month,cur_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)this.findViewById(R.id.datePicker);
        textView = (TextView) this.findViewById(R.id.text);
        calendar = Calendar.getInstance();
        cur_year = calendar.get(Calendar.YEAR);
        cur_month = calendar.get(Calendar.MONTH);
        cur_day = calendar.get(Calendar.DAY_OF_MONTH);
        textView.setText("当前时间"+cur_year+"年"+cur_month+"月"+cur_day+"日");
        datePicker.init(cur_year,cur_month,cur_day,new MyDateChangedListener());

    }

    private class MyDateChangedListener implements DatePicker.OnDateChangedListener {
        @Override
        public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
            cur_year = i;
            cur_month = i1;
            cur_day = i2;
            textView.setText("当前时间"+cur_year+"年"+cur_month+"月"+cur_day+"日");
        }
    }
}
