package com.example.tknguyen.todotasklist.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.tknguyen.todotasklist.Services.DataBaseHelper;
import com.example.tknguyen.todotasklist.Services.TodoDBDAO;

import java.util.ArrayList;

/**
 * Created by TK's-T420 on 2/28/2016.
 */
public class ToDoDAO extends TodoDBDAO {
    public ToDoDAO(Context context) {
        super(context);
    }


    public ArrayList<ToDo> getTodo() {
        ArrayList<ToDo> toDos = new ArrayList<ToDo>();

        Cursor cursor = database.query(DataBaseHelper.TODO_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.TASK_COLUMN,
                        DataBaseHelper.PRIORITY_COLUMN
                       }, null, null, null,
                null, null);

        while (cursor.moveToNext()) {
            ToDo todo = new ToDo();
            todo.setId(cursor.getInt(0));
            todo.setTask(cursor.getString(1));
            todo.setPriority(cursor.getString(2));
            toDos.add(todo);
        }
        return toDos;
    }



    public long save(ToDo todo){
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.TASK_COLUMN, todo.getTask());
        values.put(DataBaseHelper.PRIORITY_COLUMN, todo.getPriority());
        return database.insert(DataBaseHelper.TODO_TABLE, null, values);
    }
}
