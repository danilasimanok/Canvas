package com.example.falyanguzov.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by falyanguzov on 26.12.2016.
 */
public class Cannon extends View {
    private int alpha;
    private Paint paint = new Paint();
    private int d;
    private Bitmap yee,mama;
    private Rect src,mamaSrc;
    private float x;
    private float y;
    private int nmama=0;

    public Cannon(Context context) {
        super(context);
        paint.setColor(0x000000FF);
        alpha = 1;
        d = 1;
        yee= BitmapFactory.decodeResource(getResources(),R.drawable.yee);
        src=new Rect(0,0,yee.getWidth(),yee.getHeight());
        mama=BitmapFactory.decodeResource(getResources(),R.drawable.mama);
        mamaSrc=new Rect(0,0,mama.getWidth(),mama.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(alpha==0 || alpha==255)
            d *= -1;
        alpha += d;
        int w = getWidth();
        int h = getHeight();
        paint.setColor(0x1000000*alpha+0xff00);
        canvas.drawCircle(w/2.0f, h/2.0f, h/4.0f, paint);
        if(nmama>=3){
            Rect mdst=new Rect((int)x-mama.getWidth()/2,(int)y-mama.getHeight()/2,(int)x+mama.getWidth()/2,(int)y+mama.getHeight()/2);
            canvas.drawBitmap(mama,mamaSrc,mdst,paint);
        }
        else {
            Rect dst=new Rect((int)x-yee.getWidth()/2,(int)y-yee.getHeight()/2,(int)x+yee.getWidth()/2,(int)y+yee.getHeight()/2);
            canvas.drawBitmap(yee,src,dst,paint);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=event.getX();
        y=event.getY();
        if(nmama==6)nmama=0;
        else nmama++;
        return super.onTouchEvent(event);
    }
}
