package com.senior.techchef;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toolbar;


import com.senior.techchef.orders.menu;
import com.senior.techchef.orders.orders;
import com.senior.techchef.restaurant.tables;
import com.senior.techchef.users.ordersList;
import com.senior.techchef.users.waiters;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class RestaurantView extends Activity {
    ArrayList<String> tableStrings = new ArrayList<String>();
    ArrayAdapter<String> muAdapter;

    orders currentOrder = new orders();
    orders order1 = new orders();
    orders order2 = new orders();
    orders order3 = new orders();
    static ArrayList<String> orderDetails= new ArrayList<String>();
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

        final LinearLayout container = (LinearLayout) findViewById(R.id.chefListContainer);
        LayoutTransition transition = container.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);

        // Tab implementation on java code
        final Button addOrderButton = (Button)findViewById(R.id.addOrderToTableButton);
        final Button DoneButton1 =(Button) findViewById(R.id.orderDone1);
        final Button DoneButton2 =(Button) findViewById(R.id.orderDone2);
        final Button DoneButton3 =(Button) findViewById(R.id.orderDone3);
        final Button DoneButton4 =(Button) findViewById(R.id.orderDone4);
        final RelativeLayout tableOrderDetailsContainer = (RelativeLayout)findViewById(R.id.tableOrderView);

        final FrameLayout container1 = (FrameLayout) findViewById(R.id.framentItemListContainer1);
        final FrameLayout container2 = (FrameLayout) findViewById(R.id.framentItemListContainer2);
        final FrameLayout container3 = (FrameLayout) findViewById(R.id.framentItemListContainer3);
        final FrameLayout container4 = (FrameLayout) findViewById(R.id.framentItemListContainer4);
        final Context context = this;
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

        // Style tabs colors

        TabWidget widget = tabs.getTabWidget();
        for(int i = 0; i < widget.getChildCount(); i++)
        {
            View v = widget.getChildAt(i);
            v.setBackgroundResource(R.drawable.tab_indicator_techchef);
        }


        // Implement adapters
        createCustomerAdapters();
        createChefAdapters();
        createWaiterAdapters();



        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              tableOrderDetailsContainer.addView((View)createChefLayout(container));

            }

        });

       DoneButton1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                //container.removeView((View)container1);
               container.addView((View)createChefLayout(container));



           }
        });
        DoneButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                container.removeView((View)container2);

            }
        });
        DoneButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                container.removeView((View)container3);

            }
        });
        DoneButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                container.removeView((View)container4);

            }
        });




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

        ArrayList<String> dummyArray = new ArrayList<String>();


        dummyArray.add("Appetizer Platter                                                 48$");
        dummyArray.add("Chocolate Souffle                                               38$");
        dummyArray.add("Mix Chicken Pasta                                              21$");
        dummyArray.add("Grill Shrimp  Combo                                           41$");
        dummyArray.add("Rib-Eye Steak BBQ                                              73$");
        dummyArray.add("Fried Italy Chicken                                              21$");
        dummyArray.add("Caesar Salad Sandwich                                     51$");

        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, dummyArray);

        //muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, sandwiches);


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

        muAdapter = new ArrayAdapter<String>(this, R.layout.table_row, R.id.innerText2, tableStrings);
        //muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, tableStrings);

        listView = (ListView) findViewById(R.id.waiterorder);
        listView.setAdapter(muAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                currentOrder=waiter1.getTables().get(position).getOrder();
                orderDetails = currentOrder.viewOrder();

                showDetailedOrderView(view);

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

        ArrayList<String> chefOrdersString1 = new ArrayList<String>(orderlist.getOrderDetails(0));
        ArrayList<String> chefOrdersString2 = new ArrayList<String>(orderlist.getOrderDetails(1));
        ArrayList<String> chefOrdersString3 = new ArrayList<String>(orderlist.getOrderDetails(2));
        ArrayList<String> chefOrdersString4 = new ArrayList<String>(orderlist.getOrderDetails(1));


        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, chefOrdersString1);

        ListView listView;
        listView = (ListView) findViewById(R.id.cheflist1);
        listView.setAdapter(muAdapter);
        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, chefOrdersString2);
        listView = (ListView) findViewById(R.id.cheflist2);
        listView.setAdapter(muAdapter);
        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, chefOrdersString3);
        listView = (ListView) findViewById(R.id.cheflist3);
        listView.setAdapter(muAdapter);
        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, chefOrdersString4);
        listView = (ListView) findViewById(R.id.cheflist4);
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

    public void showDetailedOrderView(View v) {
        Intent intent = new Intent(this,TableViewForMonitorTable.class);
        startActivity(intent);
    }

    public FrameLayout createChefLayout(final LinearLayout container){
        final FrameLayout newFrameLayout = new FrameLayout(this);
        RelativeLayout newRelativeLayout = new RelativeLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);// or wrap_content
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT); // or wrap_content
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams2.addRule(RelativeLayout.CENTER_HORIZONTAL);


        //newLayout.setOrientation(LinearLayout.VERTICAL);
        ListView listView = new ListView(this);

        ArrayList<String> chefOrdersString1 = new ArrayList<String>();
        chefOrdersString1.add("HotDog Sandwich");
        chefOrdersString1.add("Chilly Tacos");
        chefOrdersString1.add("burrito Sandwich");
        muAdapter = new ArrayAdapter<String>(this, R.layout.single_row, R.id.innerText, chefOrdersString1);
        listView.setAdapter(muAdapter);
        Button newButton = new Button(this);
        newButton.setBackgroundColor(Color.argb(90,218,165,32));
        newButton.setText("Done");
        newRelativeLayout.addView((View) listView);
        newRelativeLayout.addView((View)newButton,layoutParams2);
        newFrameLayout.addView((View)newRelativeLayout,layoutParams);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                container.removeView((View)newFrameLayout);

            }
        });

        return newFrameLayout;


    }

   
}