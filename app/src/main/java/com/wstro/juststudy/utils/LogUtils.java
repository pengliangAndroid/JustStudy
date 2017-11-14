
package com.wstro.juststudy.utils;

import android.util.Log;

import com.wstro.juststudy.BuildConfig;

/**
 * ClassName: LogUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *
 * @author pengl
 * @date 2017/9/29
 */
public class LogUtils {

    private static final String TAG = "LogUtils";

    private static boolean isDebug = BuildConfig.DEBUG;

    private LogUtils(){
    }

    public static void i(String msg){
        d(msg);
    }

    public static void w(String msg){
        d(msg);
    }

    public static void v(String msg){
        d(msg);
    }

    public static void d(String msg){
        if(isDebug){
            Log.e(TAG,msg);
        }
    }

    public static void e(String msg){
        d(msg);
    }

}