package com.senior.techchef;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import com.senior.techchef.restaurant.tables;
import com.senior.techchef.orders.orders;
/**
 * Created by Ali on 12/9/2014.
 */



public class TableView extends Activity {

    ArrayList<String> tableStrings = new ArrayList<String>();
    ArrayAdapter<String> muAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_tables);

        String [] menuItems = {"Table 1","Table 2","Table 3","Table 4"};
        muAdapter = new ArrayAdapter<String>(this,R.layout.single_row, R.id.innerText, menuItems);
        ListView listView = (ListView) findViewById(R.id.monitorlist);
        listView.setAdapter(muAdapter);


        orders order1 = new orders();
        tables table1 = new tables(4);

    }
}
