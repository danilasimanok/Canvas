package com.example.falyanguzov.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by falyanguzov on 26.12.2016.
 */
public class Cannon extends View {
    private Paint paint = new Paint();

    public Cannon(Context context) {
        super(context);
        paint.setColor(0xFF0000FF);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth();
        int h = getHeight();
        canvas.drawCircle(w/2.0f, h/2.0f, h/4.0f, paint);
    }
}
