package com.example.practice1.DB;

import android.provider.BaseColumns;

import com.example.practice1.Message;
import com.example.practice1.User;

public final class DBContract {

    private DBContract(){

    }

    public static class MessageEntry implements BaseColumns{
        public static final String TABLE_NAME = "Message";
        public static final String COLUMN_NAME_ID = "MsgID";
        public static final String COLUMN_NAME_SUBJECT = "Subject";
        public static final String COLUMN_NAME_MESSAGE = "Msg";
        public static final String COLUMN_NAME_USERNAME = "userName";
    }

    public static final String SQL_CREATE_MESSAGE_ENTRIES = "CREATE TABLE " + MessageEntry.TABLE_NAME + " (" +
            MessageEntry.COLUMN_NAME_ID +  " INTEGER PRIMARY KEY," +
            MessageEntry.COLUMN_NAME_SUBJECT + " TEXT," +
            MessageEntry.COLUMN_NAME_MESSAGE + " TEXT," +
            MessageEntry.COLUMN_NAME_USERNAME + " TEXT)";


    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "User";
        public static final String COLUMN_NAME_ID = "UserID";
        public static final String COLUMN_NAME_USERNAME = "UserName";
        public static final String COLUMN_NAME_PASSWORD = "Password";
        public static final String COLUMN_NAME_TYPE = "Type";
    }

    public static final String SQL_CREATE_USER_ENTRIES = "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
            UserEntry.COLUMN_NAME_ID +  " INTEGER PRIMARY KEY," +
            UserEntry.COLUMN_NAME_USERNAME + " TEXT," +
            UserEntry.COLUMN_NAME_PASSWORD + " TEXT," +
            UserEntry.COLUMN_NAME_TYPE + " TEXT)";

}
