package com.wstro.juststudy.provider;

import android.net.Uri;

/**
 * ClassName: ProviderMetaData
 * Function:
 * Date:     2017/11/6 0006 16:12
 *
 * @author pengl
 * @see
 */
public class ProviderMetaData {
    public static final String AUTHORITY = "com.wstro.juststudy";

    public static final String DB_NAME = "data.db";

    public static final int DB_VERSION = 1;

    public static final String USER_TABLE_NAME = "user";

    public static class UserTableMetaData{
        public static final String TABLE_NAME = "user";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/users");

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/com.wstro.juststudy.user";

        public static final String CONTENT_TYPE_ITEM = "vnd.android.cursor.item/com.wstro.juststudy.user";

        public static final String USER_NAME = "name";
        public static final String USER_AGE = "age";
        public static final String _ID = "_id";

        public static final String DEFAULT_SORT_ORDER = "_id desc";
    }
}
