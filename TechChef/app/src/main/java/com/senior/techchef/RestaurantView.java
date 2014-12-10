package com.senior.techchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.senior.techchef.orders.menu;
import com.senior.techchef.orders.orders;
import com.senior.techchef.restaurant.tables;
import com.senior.techchef.users.ordersList;
import com.senior.techchef.users.waiters;

import java.util.ArrayList;


public class RestaurantView extends Activity {
    ArrayList<String> tableStrings = new ArrayList<String>();
    ArrayAdapter<String> muAdapter;
    ArrayAdapter<String> muAdapter2;
    orders currentOrder = new orders();
    orders order1 = new orders();
    orders order2 = new orders();
    orders order3 = new orders();
    ArrayList<String> orderDetails= new ArrayList<String>();
    tables currentTable;
    tables table1;
    tables table2;
    tables table3;
    ListView listView;

    menu mainMenu = new menu();
    ArrayList<String> sandwiches = new ArrayList<String>(mainMenu.getSandwiches());
    ArrayList<String> mainCourse = new ArrayList<String>(mainMenu.getMainCourses());
    ArrayList<String> appetizers = new ArrayList<String>(mainMenu.getAppetizers());
    ArrayList<String> desserts = new ArrayList<String>(mainMenu.getDesserts());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        // Tab implementation on java code

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        // Customer tab
        TabHost.TabSpec spec = tabs.newTabSpec("Customer View");
        spec.setContent(R.id.customer_tab);
        spec.setIndicator("Customer");
        //  res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        // Waiter tab
        spec = tabs.newTabSpec("Waiter View");
        spec.setContent(R.id.waiter_tab);
        spec.setIndicator("Waiter");
        //res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //Chef tab
        spec = tabs.newTabSpec("Chef View");
        spec.setContent(R.id.chef_tab);
        spec.setIndicator("Chef");
        //res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        // Select the specified View (Customer, Waiter, Chef) when
        // creating restaurant view by using the intent.
        int selectedTab = 0;

        Intent intent = getIntent();
        selectedTab = intent.getIntExtra("POSITION", selectedTab);


        tabs.setCurrentTab(selectedTab);

        // Implement adapters


        createCustomerAdapters();
        createChefAdapters();
        createWaiterAdapters();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant, menu);
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

    public void createCustomerAdapters() {


        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, sandwiches);


        listView = (ListView) findViewById(R.id.salad_list);
        listView.setAdapter(muAdapter);

        listView = (ListView) findViewById(R.id.poteto_list);
        listView.setAdapter(muAdapter);

        listView = (ListView) findViewById(R.id.sweet_list);
        listView.setAdapter(muAdapter);

        listView = (ListView) findViewById(R.id.pasta_list);
        listView.setAdapter(muAdapter);

        listView = (ListView) findViewById(R.id.wraps_list);
        listView.setAdapter(muAdapter);


    }

    public void createWaiterAdapters() {
        mainMenu = new menu();
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

        table1 = new tables(10, "ordered", order1);
        table2 = new tables(4, "ordered", order2);
        table3 = new tables(7, "ordered", order3);

        final waiters waiter1 = new waiters();
        waiter1.addTable(table1);
        waiter1.addTable(table2);
        waiter1.addTable(table3);


        tableStrings.add(table1.toString());
        tableStrings.add(table2.toString());
        tableStrings.add(table3.toString());
        //String [] menuItems = {"salad","yes"};
        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, tableStrings);

        listView = (ListView) findViewById(R.id.waiterorder);
        listView.setAdapter(muAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                currentOrder=waiter1.getTables().get(position).getOrder();
                orderDetails = currentOrder.viewOrder();

                setContentView(R.layout.activity_table_view_for_monitor_table);
                setNewAdapter();






            }
        });
    }
    public ArrayList<String> getOrderDetails(){
        return orderDetails;
    }

    public void createChefAdapters() {
        ordersList orderlist = new ordersList();

        mainMenu = new menu();


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

        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, chefOrdersString);
        listView = (ListView) findViewById(R.id.cheflist);
        listView.setAdapter(muAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();


            }
        });

    }
    public void setNewAdapter(){
        muAdapter2 = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, orderDetails);
        listView.setAdapter(muAdapter2);
    }
}