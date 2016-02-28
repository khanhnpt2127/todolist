package com.example.tknguyen.todotasklist;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.tknguyen.todotasklist.Model.ToDo;
import com.example.tknguyen.todotasklist.Model.ToDoDAO;

import java.lang.ref.WeakReference;

/**
 * Created by TK's-T420 on 2/27/2016.
 */
public class AddingToDoFragment extends DialogFragment implements View.OnClickListener {

    private Button addButton;


    ToDo todo = null;
    private ToDoDAO todoDAO;
    private AddTodoTask task;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        todoDAO = new ToDoDAO(getActivity());
    }


    private void setEmployee() {
        todo = new ToDo();
        todo.setTask("Test");
        todo.setPriority("1");
    }

    @Override
    public void onResume() {
        getActivity().setTitle("");
        getActivity().getActionBar().setTitle("");
        super.onResume();
    }

    //TODO: FindViewbyID Method





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.addingtodofragment, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        addButton = (Button)rootView.findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        return rootView;

    }

    @Override
    public void onClick(View v) {
        if (v == addButton){
            setEmployee();
            task = new AddTodoTask(getActivity());
            task.execute((Void) null);
        }
    }


    public class AddTodoTask extends AsyncTask<Void, Void, Long>{
        private final WeakReference<Activity> activityWeakRef;

        public AddTodoTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }

        @Override
        protected Long doInBackground(Void... arg0) {
            long result = todoDAO.save(todo);
            return result;
        }



        @Override
        protected void onPostExecute(Long result) {
            if (activityWeakRef.get() != null
                    && !activityWeakRef.get().isFinishing()) {
                if (result != -1)
                    Toast.makeText(activityWeakRef.get(), "Employee Saved",
                            Toast.LENGTH_LONG).show();
            }
        }

    }
}
