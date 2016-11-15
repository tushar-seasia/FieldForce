package com.etonsolution.fieldforce.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BawejaTushar on 11/15/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "eton.db";

    // Contacts table name
    private static final String TABLE_SHOP_DETAIL = "shop_detail";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_SHOP_STATUS = "shop_status";
    private static final String KEY_SHOP_NAME = "shop_name";
    private static final String KEY_SHOP_OWNER_NAME = "shop_owner_name";
    private static final String KEY_SHOP_CONTACT_NUMBER = "shop_contact_number";
    private static final String KEY_SHOP_ADDRESS = "shop_address";
    private static final String KEY_STATE = "state";
    private static final String KEY_CITY = "city";
    private static final String KEY_VARIANT = "variants";
    private static final String KEY_SCHEME = "scheme";
    private static final String KEY_REMARK = "remark";
    private static final String KEY_GIVE_STATUS = "give_status";

    //query to create table
    String CREATE_SHOP_DETAIL_TABLE = "CREATE TABLE " + TABLE_SHOP_DETAIL + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LATITUDE + " TEXT,"
            + KEY_LONGITUDE + " TEXT," + KEY_DATE + " TEXT,"
            + KEY_TIME + " TEXT," + KEY_IMAGE + " TEXT,"
            + KEY_SHOP_STATUS + " TEXT," + KEY_SHOP_NAME + " TEXT,"
            + KEY_SHOP_OWNER_NAME + " TEXT," + KEY_SHOP_CONTACT_NUMBER + " TEXT,"
            + KEY_SHOP_ADDRESS + " TEXT," + KEY_STATE + " TEXT,"
            + KEY_CITY + " TEXT," + KEY_VARIANT + " TEXT,"
            + KEY_SCHEME + " TEXT," + KEY_REMARK + " TEXT,"
            + KEY_GIVE_STATUS + " TEXT" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SHOP_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP_DETAIL);

        // Create tables again
        onCreate(db);
    }

    
}
