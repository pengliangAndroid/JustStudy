package com.wstro.juststudy.utils;

import android.content.Context;

/**
 * ClassName: DensityUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author pengl
 * @date 2017/9/29
 */
public class DensityUtils {

    private DensityUtils(){}


    public static int dp2px(Context context,float dp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5f);
    }

    public static int px2dp(Context context,float px){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (px / density  + 0.5f);
    }


    public static int deviceWidth(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int deviceHeight(Context context){
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}