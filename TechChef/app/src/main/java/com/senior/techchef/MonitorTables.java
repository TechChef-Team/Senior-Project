package com.senior.techchef;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.senior.techchef.orders.meals;

import java.util.ArrayList;


public class MonitorTables extends Activity {
    ArrayAdapter<String> muAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_tables);

        String [] menuItems = {"Table 1","Table 2","Table 3","Table 4"};
        muAdapter = new ArrayAdapter<String>(this,R.layout.single_row, R.id.innerText, menuItems);
        ListView listView = (ListView) findViewById(R.id.monitorlist);
        listView.setAdapter(muAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monitor_tables, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
