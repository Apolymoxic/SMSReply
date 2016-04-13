package com.example.apolymoxic.smsreply;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.Date;


// create database helper class - todoData
public class ContactDataHelper extends SQLiteOpenHelper {

    // create a tag for this class
    public static final String TAG = "ContactList";

    // define our database, table, and fields for data
    public static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_NAME = "contact_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CONTACT";
    public static final String COL_3 = "MESSAGE";

    // default constructor
    public ContactDataHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT," +
                "CONTENT TEXT, TIMESTAMP TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // function to insert data into the database
    public boolean insertData(String contact, String message) {
        // call the database
        SQLiteDatabase db = this.getWritableDatabase();

        // contentValues will allow us to take the data and insert it into the proper field
        ContentValues contentValues = new ContentValues();

        // Columns are named COL_1 - 3, rather than the name of that data that
        // will populate the field (such as ID, TITLE, etc...). This makes it a little
        // less confusing when reading the code
        // Match the columns with the correct data
        contentValues.put(COL_2, contact);
        contentValues.put(COL_3, message);

        // insert data and test results (ensure data was inserted
        long result = db.insert(TABLE_NAME, null, contentValues);

        // not inserted = -1
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {
        // call the database
        SQLiteDatabase db = this.getWritableDatabase();

        // query the database
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return result;
    }

    public int clearDB() {
        // call the database
        SQLiteDatabase db = this.getWritableDatabase();

        // query the database
        int result = db.delete(ContactDataHelper.TABLE_NAME, null, null);

        return result;
    }

    public Cursor searchTitleDB(String searchStr) {
        // call the database
        SQLiteDatabase db = this.getWritableDatabase();

        // query the database
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE COL_1 = " + searchStr, null);

        return result;
    }

    public void updateDatabase(String id, String contact, String message){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, contact);
        contentValues.put(COL_3, message);

        db.update(TABLE_NAME, contentValues, COL_1 + "=" + id, null);
    }

    public void deleteItem (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL_1 + "=" + id, null);
    }
}

