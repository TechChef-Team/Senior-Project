package com.senior.techchef;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.senior.techchef.orders.menu;
import com.senior.techchef.orders.orders;
import com.senior.techchef.users.ordersList;

import java.util.ArrayList;


public class ChefView extends Activity {
    ArrayAdapter<String> muAdapter;
    orders order1 = new orders();
    orders order2 = new orders();
    orders order3 = new orders();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_view);
        ordersList orderlist = new ordersList();

        menu mainMenu = new menu();


        order1.addMeal(mainMenu.getMeal(2));
        order1.addMeal(mainMenu.getMeal(1));
        order1.addMeal(mainMenu.getMeal(3));

        order2.addMeal(mainMenu.getMeal(4));
        order2.addMeal(mainMenu.getMeal(2));
        order2.addMeal(mainMenu.getMeal(1));

        order3.addMeal(mainMenu.getMeal(0));
        order3.addMeal(mainMenu.getMeal(3));
        order3.addMeal(mainMenu.getMeal(5));

        orderlist.addOrder(order1);
        orderlist.addOrder(order2);
        orderlist.addOrder(order3);

        ArrayList<String> chefOrdersString = new ArrayList<String>(orderlist.getOrderDetails(2));

        muAdapter = new ArrayAdapter<String>(this,R.layout.single_row, R.id.innerText, chefOrdersString);
        ListView listView = (ListView) findViewById(R.id.cheflist);
        listView.setAdapter(muAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chef_view, menu);
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
