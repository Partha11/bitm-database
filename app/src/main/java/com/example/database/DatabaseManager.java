package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    DatabaseHelper dbHelper;
    SQLiteDatabase sqlHelper;

    private List<Contact> contactList = new ArrayList<>();

    public DatabaseManager(Context context) {

        dbHelper = new DatabaseHelper(context);
    }

    public boolean insertData(String name, String number) {

        sqlHelper = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.KEY_NAME, name);
        contentValues.put(DatabaseHelper.KEY_NUMBER, number);

        long isInserted = sqlHelper.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

        sqlHelper.close();

        if (isInserted > 0)

            return true;

        else

            return false;
    }
    
    public List<Contact> getData() {

        sqlHelper = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;

        Cursor cursor = sqlHelper.rawQuery(query, null);

        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            
            String name = cursor.getString(cursor.getPosition());
            String numb = cursor.getString(cursor.getPosition());

            contactList.add(new Contact(name, numb));
        }

        sqlHelper.close();
        
        return contactList;
    }
}
