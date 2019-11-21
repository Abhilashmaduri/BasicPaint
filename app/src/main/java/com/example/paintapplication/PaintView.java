package com.example.paintapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class PaintView extends View {
    Paint brush=new Paint();
    Path path=new Path();
    LayoutParams params;
    public PaintView(Context context) {
        super(context);
        params= new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        init();
    }
    private void init()
    {
        brush.setColor(Color.MAGENTA);
        brush.setAntiAlias(true);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8f);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointx=event.getX();
        float pointy=event.getY();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointx,pointy);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointx,pointy);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path,brush);
    }
}
