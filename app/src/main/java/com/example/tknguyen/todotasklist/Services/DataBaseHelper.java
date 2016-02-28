package com.example.tknguyen.todotasklist.Services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by TK's-T420 on 2/28/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_NAME = "tododb";
    private static final int DATABASE_VERSION = 1;
    public static final String TODO_TABLE = "todo";

    public static final String ID_COLUMN = "id";
    public static final String TASK_COLUMN = "tasks";
    public static final String PRIORITY_COLUMN = "priority";

    public static final String CREATE_TODO_TABLE = "CREATE TABLE " +
                    TODO_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, " +
                    TASK_COLUMN +  " TEXT, " + PRIORITY_COLUMN + " TEXT" + ")";

    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("stringCreate", "stringCreate: " + CREATE_TODO_TABLE);
        db.execSQL(CREATE_TODO_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
