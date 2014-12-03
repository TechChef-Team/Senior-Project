package com.senior.techchef;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.senior.techchef.orders.menu;
import com.senior.techchef.orders.orders;
import com.senior.techchef.restaurant.tables;
import com.senior.techchef.users.waiters;

import java.util.ArrayList;


public class WaiterView extends Activity {
    ArrayAdapter<String> muAdapter;
    ArrayList<String> tableStrings = new ArrayList<String>();
    orders order1 = new orders();
    orders order2 = new orders();
    orders order3 = new orders();
    tables table1;
    tables table2;
    tables table3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_view);

        menu mainMenu = new menu();
        mainMenu.getMenu();

        order1.addMeal(mainMenu.getMeal(2));
        order1.addMeal(mainMenu.getMeal(1));
        order1.addMeal(mainMenu.getMeal(3));

        order2.addMeal(mainMenu.getMeal(4));
        order2.addMeal(mainMenu.getMeal(2));
        order2.addMeal(mainMenu.getMeal(1));

        order3.addMeal(mainMenu.getMeal(0));
        order3.addMeal(mainMenu.getMeal(3));
        order3.addMeal(mainMenu.getMeal(5));

        table1 = new tables(10,"ordered",order1);
        table2 = new tables(4,"ordered",order2);
        table3 = new tables(7,"ordered",order3);

        waiters waiter1 = new waiters();
        waiter1.addTable(table1);
        waiter1.addTable(table2);
        waiter1.addTable(table3);


        tableStrings.add(table1.toString());
        tableStrings.add(table2.toString());
        tableStrings.add(table3.toString());
        //String [] menuItems = {"salad","yes"};
        muAdapter = new ArrayAdapter<String>(this,R.layout.single_row, R.id.innerText, tableStrings);
        ListView listView = (ListView) findViewById(R.id.waiterorder);
        listView.setAdapter(muAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_waiter_view, menu);
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
