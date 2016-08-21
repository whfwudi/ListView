package com.example.hy.andriodlinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout ll = (LinearLayout)findViewById(R.id.lla);
                String msg = MainActivity.this.getResources().getString(R.string.button);
                Button tempbutton = new Button(MainActivity.this);
                tempbutton.setText(msg+(++count));
                tempbutton.setWidth(80);
                ll.addView(tempbutton);
            }
        });
    }
}
