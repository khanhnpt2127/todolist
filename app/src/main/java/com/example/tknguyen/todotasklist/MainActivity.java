package com.example.tknguyen.todotasklist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getSupportActionBar().setLogo(R.drawable.ic_appicon);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#26B998'>Listly</font>"));
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.FragmentManager fm = getFragmentManager();
        switch (item.getItemId()){
            case R.id.action_cart:
                Toast.makeText(this, "Okay", Toast.LENGTH_LONG).show();
                AddingToDoFragment frg = new AddingToDoFragment();
                frg.show(fm,"");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
