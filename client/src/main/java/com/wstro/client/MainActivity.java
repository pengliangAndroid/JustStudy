package com.wstro.client;

import android.app.Service;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wstro.juststudy.aidl.ICalc;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int num;

    private ICalc calcService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_query).setOnClickListener(this);
        findViewById(R.id.btn_insert).setOnClickListener(this);
        findViewById(R.id.btn_update).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_sub).setOnClickListener(this);

        Intent intent = new Intent();
        intent.setAction("com.wstro.aidl.calc");
        intent.setPackage("com.wstro.juststudy");
        bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);

    }

    final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            calcService = ICalc.Stub.asInterface(service);
            System.out.println("onServiceConnected:"+calcService);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            calcService = null;
            System.out.println("onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    @Override
    public void onClick(View v) {
        ContentResolver resolver = getContentResolver();
        switch (v.getId()){
            case R.id.btn_add:
                try {
                    int sum = calcService.add(10, 5);
                    System.out.println("sum:"+sum);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_sub:
                try {
                    int result = calcService.sub(10, 5);
                    System.out.println("result:"+result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_insert:
                Uri insertUri = Uri.parse("content://com.wstro.juststudy.UserProvider/users");
                ContentValues values = new ContentValues();
                values.put("name","test"+num);
                values.put("age",10);
                resolver.insert(insertUri,values);
                num++;
                break;
            case R.id.btn_query:
                Uri queryUri = Uri.parse("content://com.wstro.juststudy.UserProvider/users");
                Cursor cursor = resolver.query(queryUri, new String[]{"name", "age"}, null, null, null);
                while (cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Log.d("info",name + "," + age);
                }
                cursor.close();
                break;
            case R.id.btn_update:
                Uri updateUri = Uri.parse("content://com.wstro.juststudy.UserProvider/users");
                values = new ContentValues();
                values.put("name","test"+num);
                values.put("age",10);
                resolver.update(updateUri,values,"_id = ?",new String[]{"1"});
                break;
            case R.id.btn_delete:
                Uri deleteUri = Uri.parse("content://com.wstro.juststudy.UserProvider/users");
                resolver.delete(deleteUri,"_id = ?",new String[]{"1"});
                break;
        }
    }
}
