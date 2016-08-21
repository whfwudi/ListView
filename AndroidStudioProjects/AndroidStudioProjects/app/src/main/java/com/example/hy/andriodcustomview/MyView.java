package com.example.hy.andriodcustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by HY on 2016/8/20.
 */
public class MyView extends View {

    Paint paint = new Paint();

    public MyView(Context context) {
        super(context);
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
//        抗锯齿
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.drawRect(10,10,110,110,paint);
        canvas.drawText("此为自定义view所绘制",60,170,paint);
    }
}
