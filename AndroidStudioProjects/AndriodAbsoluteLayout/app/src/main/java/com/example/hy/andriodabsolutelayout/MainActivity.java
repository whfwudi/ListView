package com.example.hy.andriodabsolutelayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button okButton = (Button) findViewById(R.id.btnok);
        final Button cancelButton = (Button) findViewById(R.id.btncancel);
        final EditText uid = (EditText) findViewById(R.id.etuid);
        final EditText pwd = (EditText) findViewById(R.id.etpwd);
        final EditText log = (EditText) findViewById(R.id.etures);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null)
                {
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
                String uidStr = uid.getText().toString();
                String pwdStr = pwd.getText().toString();
                log.append("用户名：" + uidStr + "密码：" + pwdStr + "\n");
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uid.setText("");
                pwd.setText("");
                log.setText("");
            }
        });
    }
}
