package com.example.tknguyen.todotasklist.Model;

import android.content.ContentValues;
import android.content.Context;

import com.example.tknguyen.todotasklist.Services.DataBaseHelper;
import com.example.tknguyen.todotasklist.Services.TodoDBDAO;

/**
 * Created by TK's-T420 on 2/28/2016.
 */
public class ToDoDAO extends TodoDBDAO {
    public ToDoDAO(Context context) {
        super(context);
    }


    public long save(ToDo todo){
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.TASK_COLUMN, todo.getTask());
        values.put(DataBaseHelper.PRIORITY_COLUMN, todo.getPriority());
        return database.insert(DataBaseHelper.TODO_TABLE, null, values);
    }
}
