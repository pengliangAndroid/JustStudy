package com.wstro.juststudy.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.wstro.juststudy.utils.LogUtils;

/**
 * ClassName: BezierView
 * Function:
 * Date:     2017/11/30 0030 17:10
 *
 * @author pengl
 * @see
 */
public class BezierView extends View {
    private Paint paint;

    private int centerX,centerY;

    private Point start,end,control;

    public BezierView(Context context) {
        this(context,null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);

        start = new Point();
        end = new Point();
        control = new Point();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        centerX = w/2;
        centerY = h/2;
        LogUtils.d("width:"+w+",height:"+h);

        start.x = centerX - 200;
        start.y = centerY;

        end.x = centerX + 200;
        end.y = centerY;

        control.x = centerX;
        control.y = centerY - 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        control.x = (int) x;
        control.y = (int) y;
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画点
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(start.x,start.y,10,paint);
        canvas.drawCircle(end.x,end.y,10,paint);
        canvas.drawCircle(control.x,control.y,10,paint);

        //画辅助线
        canvas.drawLine(start.x,start.y,control.x,control.y,paint);
        canvas.drawLine(end.x,end.y,control.x,control.y,paint);

        Path path = new Path();
        path.moveTo(start.x,start.y);
        path.quadTo(control.x,control.y,end.x,end.y);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);
    }
}
