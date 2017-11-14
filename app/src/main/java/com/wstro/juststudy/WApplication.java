package com.wstro.juststudy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.wstro.juststudy.utils.LogUtils;

/**
 * ClassName: WApplication
 * Function:
 * Date:     2017/11/6 0006 10:57
 *
 * @author pengl
 * @see
 */
public class WApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtils.d(activity.getClass().getSimpleName() + " onActivityCreated ");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                LogUtils.d(activity.getClass().getSimpleName() +  " onActivityStarted ");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtils.d(activity.getClass().getSimpleName() + " onActivityResumed ");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtils.d(activity.getClass().getSimpleName() + " onActivityPaused ");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                LogUtils.d(activity.getClass().getSimpleName() + " onActivityStopped ");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtils.d(activity.getClass().getSimpleName() + " onActivitySaveInstanceState ");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtils.d(activity.getClass().getSimpleName() + "onActivityDestroyed ");
            }
        });
    }

}
