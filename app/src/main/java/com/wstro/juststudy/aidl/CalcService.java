package com.wstro.juststudy.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.wstro.juststudy.utils.LogUtils;

/**
 * ClassName: CalcService
 * Function:
 * Date:     2017/11/8 0008 17:15
 *
 * @author pengl
 * @see
 */
public class CalcService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d("IBinder");
        return calcBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d("onCreate");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.d("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        LogUtils.d("onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        LogUtils.d("onDestroy");
        super.onDestroy();
    }

    private final ICalc.Stub calcBinder = new ICalc.Stub(){

        @Override
        public int add(int a, int b) throws RemoteException {
            return a+b;
        }

        @Override
        public int sub(int a, int b) throws RemoteException {
            return a-b;
        }
    };
}
