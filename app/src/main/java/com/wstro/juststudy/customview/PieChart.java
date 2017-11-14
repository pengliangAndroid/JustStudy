package com.wstro.juststudy.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.wstro.juststudy.utils.LogUtils;

import java.util.List;

/**
 * ClassName: PieChart
 * Function:
 * Date:     2017/11/10 0010 11:50
 *
 * @author pengl
 * @see
 */
public class PieChart extends View {
    private static final String[] COLORS = new String[]{"#FFe51c23","#FFe91e63","#FF9c27b0","#FF673ab7","#FF5677fc"};

    private Paint mPaint;

    private List<PieData> mDataList;

    private int mWidth,mHeight;

    private float startAngel = 0;

    public PieChart(Context context) {
        this(context, null);
    }

    public PieChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setDataList(List<PieData> dataList) {
        this.mDataList = dataList;

        initData();
        invalidate();
    }

    public void setStartAngel(float startAngel) {
        this.startAngel = startAngel;
        invalidate();
    }

    private void initData() {
        float sum = 0;
        for (int i = 0; i < mDataList.size(); i++) {
            PieData data = mDataList.get(i);
            sum += data.getValue();
        }

        for (int i = 0; i < mDataList.size(); i++) {
            PieData data = mDataList.get(i);
            float percent = data.getValue() * 100f / sum;
            data.setPercent(percent);

            data.setAngel(percent * 360 / 100);
            int color = Color.parseColor(COLORS[i % COLORS.length]);
            data.setColor(color);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        LogUtils.d("width:"+w+"height:"+h);
        mWidth = w;
        mHeight = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mDataList == null)
            return;

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.GRAY);

        canvas.translate(mWidth/2,mHeight/2);

        int r = (int) (mWidth/2*0.8f);
        canvas.drawCircle(0,0,r+3,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        RectF rect = new RectF(-r,-r,r,r);

        for (int i = 0; i < mDataList.size(); i++) {
            mPaint.setColor(mDataList.get(i).getColor());
            canvas.drawArc(rect,startAngel,mDataList.get(i).getAngel(),true,mPaint);
            startAngel += mDataList.get(i).getAngel();
        }

        startAngel = 0;
    }
}
