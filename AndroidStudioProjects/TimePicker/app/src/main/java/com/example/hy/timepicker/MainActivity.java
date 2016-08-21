package com.example.hy.timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView textView;
    Calendar calendar;
    int cur_hour,cur_minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        textView = (TextView)findViewById(R.id.text);
        calendar = Calendar.getInstance();

        cur_hour = calendar.get(Calendar.HOUR);
        cur_minute = calendar.get(Calendar.MINUTE);

        textView.setText("当前时间"+cur_hour+"时"+cur_minute+"分");
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new MyTimeChanged());
    }

    private class MyTimeChanged implements TimePicker.OnTimeChangedListener {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            cur_hour = hourOfDay;
            cur_minute = minute;
            textView.setText("当前时间"+cur_hour+"时"+cur_minute+"分");
        }
    }
}
