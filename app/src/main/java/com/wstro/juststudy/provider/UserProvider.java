package com.wstro.juststudy.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.wstro.juststudy.utils.LogUtils;

import java.util.HashMap;

/**
 * ClassName: UserProvider
 * Function:
 * Date:     2017/11/6 0006 16:19
 *
 * @author pengl
 * @see
 */
public class UserProvider extends ContentProvider {

    public static UriMatcher uriMatcher;

    private static final int USER_COLLECTION = 0;
    private static final int USER_SINGLE = 1;

    private DataBaseHelper databaseHelper;

    private static HashMap<String,String> dataMap;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ProviderMetaData.AUTHORITY, "/users",USER_COLLECTION);
        uriMatcher.addURI(ProviderMetaData.AUTHORITY, "/users/#",USER_SINGLE);

        dataMap = new HashMap<>();
        dataMap.put(ProviderMetaData.UserTableMetaData._ID,ProviderMetaData.UserTableMetaData._ID);
        dataMap.put(ProviderMetaData.UserTableMetaData.USER_NAME,ProviderMetaData.UserTableMetaData.USER_NAME);
        dataMap.put(ProviderMetaData.UserTableMetaData.USER_AGE,ProviderMetaData.UserTableMetaData.USER_AGE);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DataBaseHelper(getContext(),ProviderMetaData.DB_NAME,
                null,ProviderMetaData.DB_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        LogUtils.d("query");
        /*SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri)){
            case USER_COLLECTION:
                queryBuilder.setTables(ProviderMetaData.USER_TABLE_NAME);
                queryBuilder.setProjectionMap(dataMap);
                break;
            case USER_SINGLE:
                String id = uri.getPathSegments().get(1);
                queryBuilder.setTables(ProviderMetaData.USER_TABLE_NAME);
                queryBuilder.setProjectionMap(dataMap);
                queryBuilder.appendWhere(ProviderMetaData.UserTableMetaData._ID + "=" + id);
                break;
        }*/
        if(TextUtils.isEmpty(sortOrder)){
            sortOrder = ProviderMetaData.UserTableMetaData.DEFAULT_SORT_ORDER;
        }

        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.query(ProviderMetaData.USER_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        LogUtils.d("getType");
        switch (uriMatcher.match(uri)){
            case USER_COLLECTION:
                return ProviderMetaData.UserTableMetaData.CONTENT_TYPE;
            case USER_SINGLE:
                return ProviderMetaData.UserTableMetaData.CONTENT_TYPE_ITEM;
            default:
                throw new IllegalArgumentException("Unknown URI"+uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        LogUtils.d("insert");
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        long rowId = database.insert(ProviderMetaData.USER_TABLE_NAME, null, values);
        if(rowId > 0){
            Uri insertUri = ContentUris.withAppendedId(ProviderMetaData.UserTableMetaData.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(insertUri,null);
            return insertUri;
        }else {
            throw new IllegalArgumentException("failed to insert row into "+ rowId);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int rowId = database.delete(ProviderMetaData.USER_TABLE_NAME, selection, selectionArgs);
        if(rowId > 0){
            Uri insertUri = ContentUris.withAppendedId(ProviderMetaData.UserTableMetaData.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(insertUri,null);
            return rowId;
        }else {
            throw new IllegalArgumentException("failed to delete row into "+ rowId);
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        int rowId = database.update(ProviderMetaData.USER_TABLE_NAME, values,selection, selectionArgs);
        if(rowId > 0){
            Uri insertUri = ContentUris.withAppendedId(ProviderMetaData.UserTableMetaData.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(insertUri,null);
            return rowId;
        }else {
            throw new IllegalArgumentException("failed to update row into "+ rowId);
        }
    }
}
