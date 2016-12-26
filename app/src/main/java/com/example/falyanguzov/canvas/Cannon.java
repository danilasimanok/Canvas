package com.example.falyanguzov.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by falyanguzov on 26.12.2016.
 */
public class Cannon extends View {
    private int alpha;
    private Paint paint = new Paint();
    private int d;

    public Cannon(Context context) {
        super(context);
        paint.setColor(0x000000FF);
        alpha = 1;
        d = 1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(alpha==0 || alpha==255)
            d *= -1;
        alpha += d;
        int w = getWidth();
        int h = getHeight();
        paint.setColor(0x1000000*alpha+0xff);
        canvas.drawCircle(w/2.0f, h/2.0f, h/4.0f, paint);
        invalidate();
    }
}
