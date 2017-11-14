package com.wstro.juststudy.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wstro.juststudy.utils.LogUtils;

/**
 * ClassName: DataBaseHelper
 * Function:
 * Date:     2017/11/6 0006 16:21
 *
 * @author pengl
 * @see
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtils.d("onCreate");
        String sql = "create table user(_id integer primary key autoincrement,name text,age integer)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table user";
        db.execSQL(sql);
    }
}
