package com.wstro.juststudy.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.wstro.juststudy.utils.LogUtils;

/**
 * ClassName: RadarView
 * Function:
 * Date:     2017/11/30 0030 13:48
 *
 * @author pengl
 * @see
 */
public class RadarView extends View {

    private static final int DEFAULT_WIDTH = 400;

    private int width,height;

    private int edgeCount = 5;
    private int ploygonCount = 3;

    private float angel = (float) (Math.PI * 2 / edgeCount);
    private float[] data = new float[]{26.9f,48.7f,63,23.5f,23};

    private Paint mPaint;

    private int centerX,centerY;

    private float edgeRadius;

    private String[] titles = new String[]{"司机能力","跑图能力","生存能力","刚枪能力","阴人能力"};

    public RadarView(Context context) {
        this(context,null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#FFB1B1"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(28);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if(mode == MeasureSpec.AT_MOST){
            width = DEFAULT_WIDTH;
        }

        setMeasuredDimension(MeasureSpec.makeMeasureSpec(width,mode),heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;

        centerX = width/2;
        centerY = height/2;

        edgeRadius = Math.min(w,h)/2*0.5f;
        LogUtils.d("width:"+width+",height:"+h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawPolygon(canvas);
        drawLine(canvas);
        drawText(canvas);

        mPaint.setColor(Color.parseColor("#FFB1B1"));
        drawRegion(canvas);
    }

    private void drawPolygon(Canvas canvas){
        float r = edgeRadius/(ploygonCount -1);
        float curR;
        Path path = new Path();
        for (int j = 1; j < ploygonCount; j++) {
            curR = r * j;
            path.reset();

            for (int i = 0; i < edgeCount; i++) {
                if(i == 0){
                    path.moveTo(centerX,centerY+curR);
                }else{
                    float x = (float) (centerX - Math.cos((Math.PI/2 - angel*i)) * curR);
                    float y = (float) (centerY + Math.sin((Math.PI/2 - angel*i)) * curR);
                    path.lineTo(x,y);
                }

            }
            path.close();
            canvas.drawPath(path,mPaint);
        }
    }



    private void drawLine(Canvas canvas){
        Path path = new Path();

        for (int i = 0; i < edgeCount; i++) {
            path.moveTo(centerX,centerY);
            float x = (float) (centerX - Math.cos((Math.PI/2 - angel*i)) * edgeRadius);
            float y = (float) (centerY + Math.sin((Math.PI/2 - angel*i)) * edgeRadius);
            path.lineTo(x,y);
        }

        path.close();
        canvas.drawPath(path,mPaint);
    }

    private void drawText(Canvas canvas){
        Paint.FontMetrics metrics = mPaint.getFontMetrics();
        float fontHeight = metrics.descent - metrics.ascent;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#999999"));
        for (int i = 0; i < edgeCount; i++) {
            /*float x = (float) (centerX + Math.cos(angel*i) * (edgeRadius+fontHeight/2));
            float y = (float) (centerY + Math.sin(angel*i) * (edgeRadius+fontHeight));*/

            float x = (float) (centerX - Math.cos((Math.PI/2 - angel*i)) * (edgeRadius+fontHeight/2));
            float y = (float) (centerY + Math.sin((Math.PI/2 - angel*i)) * (edgeRadius+fontHeight/2));

            /*if(angel*i>0&&angel*i<=Math.PI/2){//第四象限
                canvas.drawText(titles[i],x,y,mPaint);
            }else if(angel*i>Math.PI/2&&angel*i<=Math.PI){//第三象限
                canvas.drawText(titles[i],x,y,mPaint);
            }else if(angel*i>Math.PI&&angel*i<=3*Math.PI/2){//第二象限
                float dis = mPaint.measureText(titles[i]);
                canvas.drawText(titles[i],x-dis,y,mPaint);
            }else if(angel*i>3*Math.PI/2&&angel*i<=Math.PI){//第一象限
                float dis = mPaint.measureText(titles[i]);
                canvas.drawText(titles[i],x-dis,y,mPaint);
            }*/
            /*if(angel*i>Math.PI/2&&angel*i<=Math.PI*3/2){//第一象限
                float dis = mPaint.measureText(titles[i]);
                canvas.drawText(titles[i],x-dis,y,mPaint);
            }else {
                canvas.drawText(titles[i], x, y, mPaint);
            }*/

            if(i == 0){
                float dis = mPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x - dis/2, y+fontHeight/2, mPaint);
            }else if(i == 1 || i == 2){
                float dis = mPaint.measureText(titles[i]);
                canvas.drawText(titles[i],x-dis,y,mPaint);
            }else{
                canvas.drawText(titles[i], x, y, mPaint);
            }

        }
    }

    private void drawRegion(Canvas canvas){
        Path path = new Path();
        mPaint.setAlpha(255);
        for(int i=0;i<edgeCount;i++){
            double percent = data[i]/100f;
            /*float x = (float) (centerX+edgeRadius*Math.cos(angel*i)*percent);
            float y = (float) (centerY+edgeRadius*Math.sin(angel*i)*percent);*/

            float x = (float) (centerX - Math.cos((Math.PI/2 - angel*i)) * edgeRadius*percent);
            float y = (float) (centerY + Math.sin((Math.PI/2 - angel*i)) * edgeRadius*percent);
            if(i==0){
                path.moveTo(centerX, y);
            }else{
                path.lineTo(x,y);
            }
            //绘制小圆点
            //canvas.drawCircle(x,y,10,mPaint);
        }
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, mPaint);
        mPaint.setAlpha(166);
        //绘制填充区域
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, mPaint);
    }
}
