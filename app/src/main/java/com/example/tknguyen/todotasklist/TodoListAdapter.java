package com.example.tknguyen.todotasklist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tknguyen.todotasklist.Model.ToDo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by TK's-T420 on 2/28/2016.
 */
public class TodoListAdapter extends ArrayAdapter<ToDo> {
    private Context context;
    List<ToDo> todoss;


    public TodoListAdapter(Context context, List<ToDo> todos) {
        super(context, R.layout.list_item, todos);
        this.context = context;
        this.todoss = todos;
    }

    private class ViewHolder {
        TextView todoIdTxt;
        TextView taskTxt;
        TextView priorityTxt;
    }

    @Override
    public int getCount() {
        return todoss.size();
    }

    @Override
    public ToDo getItem(int position) {
        return todoss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.todoIdTxt = (TextView) convertView
                    .findViewById(R.id.txt_emp_id);
            holder.taskTxt = (TextView) convertView
                    .findViewById(R.id.txt_emp_name);
            holder.priorityTxt = (TextView) convertView
                    .findViewById(R.id.txt_emp_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ToDo todo = (ToDo) getItem(position);
        holder.todoIdTxt.setText(todo.getId() + "");
        holder.taskTxt.setText(todo.getTask());
        holder.priorityTxt.setText(todo.getPriority() + "");

        return convertView;
    }

    @Override
    public void add(ToDo employee) {
        todoss.add(employee);
        notifyDataSetChanged();
        super.add(employee);
    }

    @Override
    public void remove(ToDo employee) {
        todoss.remove(employee);
        notifyDataSetChanged();
        super.remove(employee);
    }




}
