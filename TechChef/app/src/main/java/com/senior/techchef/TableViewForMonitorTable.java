package com.senior.techchef;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.senior.techchef.restaurant.tables;
import com.senior.techchef.orders.orders;

import java.util.ArrayList;

import static com.senior.techchef.R.layout.activity_table_view_for_monitor_table;

public class TableViewForMonitorTable extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_table_view_for_monitor_table);




        //Adapter
        RestaurantView r = new RestaurantView();
        ArrayList<String> detailedOrder = r.getOrderDetails();
        ArrayAdapter<String> muAdapter, muAdapter1;

        /*muAdapter = new ArrayAdapter<String>(this, activity_table_view_for_monitor_table, R.id.detailedOrder, detailedOrder);
        ListView myListView1 = (ListView)findViewById(R.id.detailedOrder);
        myListView1.setAdapter(muAdapter);

        */
        muAdapter1 = new ArrayAdapter<String>(this,R.layout.single_row, R.id.innerText, detailedOrder);

        ListView listView;
        listView = (ListView) findViewById(R.id.poteto_list);
        listView.setAdapter(muAdapter1);

        //myListView1.setOnClickListener();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table_view_for_monitor_table, menu);
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