package com.dandelion.thirdproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class MainActivity18DBHelper extends SQLiteOpenHelper {

    private static MainActivity18DBHelper dbHelper;
    private static SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_TABLE = "cats";
    private static final String ID_COLUMN = "id";
    private static final String CAT_NAME_COLUMN = "name";
    private static final String AGE_COLUMN = "age";

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + ID_COLUMN
            + " integer primary key autoincrement, " + CAT_NAME_COLUMN
            + " text not null, " + AGE_COLUMN + " integer);";

    private MainActivity18DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

        onCreate(db);
    }

    public static MainActivity18DBHelper getInstance(Context context) {
        if(null == dbHelper) {
            dbHelper = new MainActivity18DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();
        }
        return dbHelper;
    }

    public void createData(String name) {
        ContentValues values = new ContentValues();
        values.put(CAT_NAME_COLUMN, name);
        values.put(AGE_COLUMN, 7);
        sqLiteDatabase.insert(DATABASE_TABLE, null, values);
    }

    public void updateData(String name) {
        ContentValues values = new ContentValues();
        values.put(CAT_NAME_COLUMN, "Мурзик");
        sqLiteDatabase.update(DATABASE_TABLE, values,
                CAT_NAME_COLUMN + "= ?", new String[]{name});
    }

    public void deleteData(String name) {
        sqLiteDatabase.delete(DATABASE_TABLE,
                CAT_NAME_COLUMN + "= ?", new String[]{name});
    }

    public void getData() {
        Cursor cursor = sqLiteDatabase.query(DATABASE_TABLE,
                null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(ID_COLUMN));
            String catName = cursor.getString(cursor.getColumnIndex(CAT_NAME_COLUMN));
            int age = cursor.getInt(cursor.getColumnIndex(AGE_COLUMN));
            Log.e("LOG_TAG", "id " + id + " catName " + catName + " age " + age);
        }
        cursor.close();
    }

    public void closeData() {
        sqLiteDatabase.close();
        dbHelper.close();
    }
}
