package com.example.hy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    Button submit;
    Toast toast;

    RadioGroup RG;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;
    RadioButton RB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText phone = (EditText)this.findViewById(R.id.phone);
        EditText password = (EditText)this.findViewById(R.id.password);
        final TextView text = (TextView)this.findViewById(R.id.myTextView);

        phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                text.setText("phone");

                return false;
            }
        });

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                text.setText("password");
                return false;
            }
        });

        checkBox1 = (CheckBox)this.findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox)this.findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox)this.findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox)this.findViewById(R.id.checkbox4);
        submit = (Button)this.findViewById(R.id.submit);

        checkBox1.setOnCheckedChangeListener(new CheckBoxListener());
        checkBox2.setOnCheckedChangeListener(new CheckBoxListener());
        checkBox3.setOnCheckedChangeListener(new CheckBoxListener());
        checkBox4.setOnCheckedChangeListener(new CheckBoxListener());

        submit.setOnClickListener(new ButtonClickedListener());

        RG = (RadioGroup)this.findViewById(R.id.RG);
        RB1 = (RadioButton)this.findViewById(R.id.RB1);
        RB2 = (RadioButton)this.findViewById(R.id.RB2);
        RB3 = (RadioButton)this.findViewById(R.id.RB3);
        RB4 = (RadioButton)this.findViewById(R.id.RB4);

        RG.setOnCheckedChangeListener(ChangeRadioGroup);
    }

    private RadioGroup.OnCheckedChangeListener ChangeRadioGroup = new RadioGroup.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId==RB1.getId() && RB1.isChecked())
                Toast.makeText(MainActivity.this,RB1.getText()+"被选择",Toast.LENGTH_LONG).show();
            else if(checkedId==RB2.getId() && RB2.isChecked())
                Toast.makeText(MainActivity.this,RB2.getText()+"被选择",Toast.LENGTH_LONG).show();
            else if(checkedId==RB3.getId() && RB3.isChecked())
                Toast.makeText(MainActivity.this,RB3.getText()+"被选择",Toast.LENGTH_LONG).show();
            else if(checkedId==RB4.getId() && RB4.isChecked())
                Toast.makeText(MainActivity.this,RB4.getText()+"被选择",Toast.LENGTH_LONG).show();
            else {
            }
        }
    };

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                toast = Toast.makeText(MainActivity.this, buttonView.getText() + "被选择", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 5, 5);
                toast.show();
            } else {
                toast = Toast.makeText(MainActivity.this, buttonView.getText() + "取消选择", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 5, 5);
                toast.show();
            }
        }
    }

    class ButtonClickedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String str = "";
            if (checkBox1.isChecked())
                str = str+checkBox1.getText();
            else if (checkBox2.isChecked())
                str = str+checkBox2.getText();
            else if (checkBox3.isChecked())
                str = str+checkBox3.getText();
            else if (checkBox4.isChecked())
                str = str+checkBox4.getText();
            else
                str = "未";
            Toast.makeText(MainActivity.this,str+"被选择",Toast.LENGTH_LONG).show();
        }
    }
}
