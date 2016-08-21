package com.example.hy.andriodautocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] myStr = new String[]{
            "aaa","aab","aac","aad","aae","中国","中华","中华人民共和国"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                myStr
        );

        AutoCompleteTextView myct = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        myct.setAdapter(aa);
        myct.setThreshold(1);

    }
}
