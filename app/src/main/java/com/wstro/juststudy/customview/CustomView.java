package com.wstro.juststudy.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * ClassName: CustomView
 * Function:
 * Date:     2017/11/10 0010 11:04
 *
 * @author pengl
 * @see
 */
public class CustomView extends View {

    private Paint mPaint = new Paint();

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制颜色
        //canvas.drawColor(Color.BLUE);

        //绘制点
        /*canvas.drawPoint(100,100,mPaint);
        canvas.drawPoints(new float[]{
                200,200,
                200,400,
                200,600,
        },mPaint);*/

        //绘制直线
        /*canvas.drawLine(300,200,500,600,mPaint);
        canvas.drawLines(new float[]{
                100,200,200,200,
                200,300,400,300,
        },mPaint);*/

        //绘制矩形
        //第一种
        //mPaint.setStyle(Paint.Style.STROKE);
        //canvas.drawRect(100,100,400,400,mPaint);

        //第二种
        //Rect rect = new Rect(200,200,300,300);
        //canvas.drawRect(rect,mPaint);

        //第三种
        //RectF rectF = new RectF(150,150,350,350);
        //canvas.drawRect(rectF,mPaint);


        //绘制圆角矩形
        //RectF rectF = new RectF(150,150,350,350);
        //canvas.drawRoundRect(rectF,16,16,mPaint);
        //canvas.drawRoundRect(rectF,150,100,mPaint);

        //绘制椭圆
        //RectF rectF = new RectF(150,150,550,350);
        //canvas.drawOval(rectF,mPaint);


        //绘制圆形
        //canvas.drawCircle(120,120,200,mPaint);


        //绘制圆弧
        RectF rectF = new RectF(150,150,550,350);
        canvas.drawRect(rectF,mPaint);

        mPaint.setColor(Color.BLUE);
        //canvas.drawArc(rectF,0,120,false,mPaint);
        canvas.drawArc(rectF,0,120,true,mPaint);
    }
}
