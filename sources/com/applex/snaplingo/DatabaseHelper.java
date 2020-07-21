package com.applex.snaplingo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SnapDatabase007.db";
    private static final String TABLE_NAME = "mylist_data007";
    private static final String col1 = "ID";
    private static final String col2 = "Item1";
    private static final String col3 = "Date";
    private static final String col4 = "Sel";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE mylist_data007 (ID INTEGER PRIMARY KEY AUTOINCREMENT, Item1 TEXT, Date TEXT, Sel TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mylist_data007");
    }

    public boolean addData2(String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, str);
        contentValues.put(col3, str2);
        return writableDatabase.insert(TABLE_NAME, null, contentValues) != -1;
    }

    public boolean addData(int i, String str, String str2) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, str);
        contentValues.put(col3, str2);
        contentValues.put(col1, Integer.valueOf(i));
        return writableDatabase.insert(TABLE_NAME, null, contentValues) != -1;
    }

    public Cursor getListContents() {
        return getWritableDatabase().rawQuery("SELECT * FROM mylist_data007", null);
    }

    public Cursor getItemId(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        return writableDatabase.rawQuery("SELECT ID FROM mylist_data007 WHERE Item1= '" + str + "'", null);
    }

    public void deleteItem(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM mylist_data007 WHERE ID ='" + i + "'");
    }
}
