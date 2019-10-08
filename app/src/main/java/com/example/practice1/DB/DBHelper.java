package com.example.practice1.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.practice1.Message;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBConstract.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.SQL_CREATE_MESSAGE_ENTRIES);
        db.execSQL(DBContract.SQL_CREATE_USER_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insertMessage(Message message){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(DBContract.MessageEntry.COLUMN_NAME_ID);
        values.put(DBContract.MessageEntry.COLUMN_NAME_MESSAGE, message.getMsg());
        values.put(DBContract.MessageEntry.COLUMN_NAME_SUBJECT, message.getSubject());
        values.put(DBContract.MessageEntry.COLUMN_NAME_USERNAME, message.getUserName());

        long newRowID = db.insert(DBContract.MessageEntry.TABLE_NAME, null, values);

        return newRowID;
    }

    public ArrayList<Message> getAllMessage() {

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                DBContract.MessageEntry.COLUMN_NAME_ID,
                DBContract.MessageEntry.COLUMN_NAME_SUBJECT,
                DBContract.MessageEntry.COLUMN_NAME_MESSAGE,
                DBContract.MessageEntry.COLUMN_NAME_USERNAME
        };

        Cursor cursor = db.query(
                DBContract.MessageEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Message> msgList = new ArrayList<>();
        while (cursor.moveToNext()){
            Message msg = new Message(
                    cursor.getInt(cursor.getColumnIndexOrThrow(DBContract.MessageEntry.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DBContract.MessageEntry.COLUMN_NAME_USERNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DBContract.MessageEntry.COLUMN_NAME_SUBJECT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DBContract.MessageEntry.COLUMN_NAME_MESSAGE))
            );
            msgList.add(msg);
        }
        return msgList;
    }


}
