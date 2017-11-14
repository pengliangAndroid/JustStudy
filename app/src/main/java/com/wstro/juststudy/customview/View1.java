package com.wstro.juststudy.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.wstro.juststudy.R;
import com.wstro.juststudy.utils.LogUtils;

/**
 * ClassName: View1
 * Function:
 * Date:     2017/11/9 0009 16:35
 *
 * @author pengl
 * @see
 */
public class View1 extends View {

    private static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_WIDTH = 100;

    private int mColor;

    private int mWidth;

    private String mText;

    private int mViewBgResId;


    public View1(Context context) {
        this(context,null);
    }

    public View1(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.View1,defStyleAttr,0);
        mColor = array.getColor(R.styleable.View1_view_color,DEFAULT_COLOR);
        mWidth = array.getDimensionPixelSize(R.styleable.View1_view_width,DEFAULT_WIDTH);
        mText = array.getString(R.styleable.View1_view_text);
        //mViewBgResId = array.getResourceId(R.styleable.View1_view_bg,-1);

        LogUtils.d("mColor:"+mColor);
        LogUtils.d("mWidth:"+mWidth);
        LogUtils.d("mText:"+mText);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getSize(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        LogUtils.d("onMeasure()");
        LogUtils.d("widthMode:"+widthMode+",widthSize:"+widthSize);
        LogUtils.d("heightMode:"+heightMode+",heightSize:"+heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        LogUtils.d("onLayout()");
        LogUtils.d("left:"+left+",top:"+top);
        LogUtils.d("right:"+right+",bottom:"+bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("onDraw()");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LogUtils.d("onFinishInflate()");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.d("onAttachedToWindow()");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        LogUtils.d("onWindowFocusChanged()");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }
}
