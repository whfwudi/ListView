package com.example.hy.andriodphone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bCall = (Button)findViewById(R.id.button);
        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText telnum = (EditText)findViewById(R.id.editText);
                String telNum = telnum.getText().toString();
                if (PhoneNumberUtils.isGlobalPhoneNumber(telNum)) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tell://"+telNum));
                    MainActivity.this.startActivity(intent);
                } else
                {
                    Toast.makeText(MainActivity.this,"号码不正确",5000).show();
                }
            }
        });
    }
}
