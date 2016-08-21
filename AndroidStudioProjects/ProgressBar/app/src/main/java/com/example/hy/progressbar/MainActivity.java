package com.example.hy.progressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int StopHandlerHorizontal = 1;
    public static final int StopHandlerLarge = 2;
    public static final int StopHandlerSmall = 3;
    public static final int StartHandlerHorizontal = 4;
    public static final int StartHandlerLarge = 5;
    public static final int StartHandlerSmall = 6;

    Button button;
    private TextView textViewHorizontal;
    private TextView textViewLarge;
    private TextView textViewSmall;
    private ProgressBar progressBarStyleHorizontal;
    private ProgressBar progressBarStyleLarge;
    private ProgressBar progressBarStyleSmall;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        textViewHorizontal = (TextView)findViewById(R.id.textViewHorizontal);
        textViewLarge = (TextView)findViewById(R.id.textViewLarge);
        textViewSmall = (TextView)findViewById(R.id.textViewSmall);

        progressBarStyleHorizontal = (ProgressBar)findViewById(R.id.progressBarStyleHorizontal);
        progressBarStyleLarge = (ProgressBar)findViewById(R.id.progressBarStyleLarge);
        progressBarStyleSmall = (ProgressBar)findViewById(R.id.progressBarStyleSmall);

        progressBarStyleHorizontal.setIndeterminate(false);
        progressBarStyleLarge.setIndeterminate(false);
        progressBarStyleSmall.setIndeterminate(false);

        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                textViewHorizontal.setText("水平进度条开始");
                textViewLarge.setText("大圆圈进度条开始");
                textViewSmall.setText("小圆圈进度条开始");

                progressBarStyleHorizontal.setVisibility(View.VISIBLE);
                progressBarStyleLarge.setVisibility(View.VISIBLE);
                progressBarStyleSmall.setVisibility(View.VISIBLE);

                progressBarStyleHorizontal.setMax(100);
                progressBarStyleLarge.setMax(100);
                progressBarStyleSmall.setMax(100);

                progressBarStyleHorizontal.setProgress(0);
                progressBarStyleLarge.setProgress(10);
                progressBarStyleSmall.setProgress(50);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0 ;i < 10;i ++)
                        {
                            try
                            {
                                counter = (i+1) * 20;
                                Thread.sleep(1000);
                                if (i == 3)
                                {
                                    Message messageHorizontal = new Message();
                                    Message messageLarge = new Message();
                                    Message messageSmall = new Message();

                                    messageHorizontal.what = MainActivity.StopHandlerHorizontal;
                                    messageLarge.what = MainActivity.StopHandlerLarge;
                                    messageSmall.what = MainActivity.StopHandlerSmall;

                                    MainActivity.this.myMessageHandler.sendMessage(messageHorizontal);
                                    MainActivity.this.myMessageHandler.sendMessage(messageLarge);
                                    MainActivity.this.myMessageHandler.sendMessage(messageSmall);

                                    break;
                                }
                                else
                                {
                                    Message messageHorizontal = new Message();
                                    Message messageLarge = new Message();
                                    Message messageSmall = new Message();

                                    messageHorizontal.what = MainActivity.StartHandlerHorizontal;
                                    messageLarge.what = MainActivity.StartHandlerLarge;
                                    messageSmall.what = MainActivity.StartHandlerSmall;

                                    MainActivity.this.myMessageHandler.sendMessage(messageHorizontal);
                                    MainActivity.this.myMessageHandler.sendMessage(messageLarge);
                                    MainActivity.this.myMessageHandler.sendMessage(messageSmall);
                                }
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }

    public Handler myMessageHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case MainActivity.StopHandlerHorizontal:
                    textViewHorizontal.setText("progressBarStyleHorizontal进度条结束");
                    textViewHorizontal.setVisibility(View.GONE);
                    Thread.currentThread().interrupt();
                    break;
                case MainActivity.StopHandlerLarge:
                    textViewHorizontal.setText("progressBarStyleLarge进度条结束");
                    textViewHorizontal.setVisibility(View.GONE);
                    Thread.currentThread().interrupt();
                    break;
                case MainActivity.StopHandlerSmall:
                    textViewHorizontal.setText("progressBarStyleSmall进度条结束");
                    textViewHorizontal.setVisibility(View.GONE);
                    Thread.currentThread().interrupt();
                    break;
                case MainActivity.StartHandlerHorizontal:
                    if (!Thread.currentThread().isInterrupted())
                    {
                        progressBarStyleHorizontal.setProgress(counter);
                        textViewHorizontal.setText(getResources().getText(counter,"进度条开始")+"("+Integer.toString(counter)+"%)\n"+"Progress:"+Integer.toString(progressBarStyleHorizontal.getProgress())+"\n"+"Indeterminate:"+Boolean.toString(progressBarStyleHorizontal.isIndeterminate()));
                    }
                    break;
                case MainActivity.StartHandlerLarge:
                    if (!Thread.currentThread().isInterrupted())
                    {
                        progressBarStyleLarge.setProgress(counter);
                        textViewLarge.setText(getResources().getText(counter,"进度条开始")+"("+Integer.toString(counter)+"%)\n"+"Progress:"+Integer.toString(progressBarStyleLarge.getProgress())+"\n"+"Indeterminate:"+Boolean.toString(progressBarStyleLarge.isIndeterminate()));
                    }
                    break;
                case MainActivity.StartHandlerSmall:
                    if (!Thread.currentThread().isInterrupted())
                    {
                        progressBarStyleSmall.setProgress(counter);
                        textViewSmall.setText(getResources().getText(counter,"进度条开始")+"("+Integer.toString(counter)+"%)\n"+"Progress:"+Integer.toString(progressBarStyleSmall.getProgress())+"\n"+"Indeterminate:"+Boolean.toString(progressBarStyleSmall.isIndeterminate()));
                    }
                    break;

            }
            super.handleMessage(msg);
        }
    };
}
