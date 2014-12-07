package com.senior.techchef;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import com.senior.techchef.orders.menu;
import android.widget.ListView;

import java.util.ArrayList;


public class CustomerMenu extends Activity {
    ArrayAdapter<String> muAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);

        menu mainMenu = new menu();
        ArrayList<String> sandwiches=new ArrayList<String>(mainMenu.getSandwiches());
        ArrayList<String> mainCourse=new ArrayList<String>(mainMenu.getMainCourses());
        ArrayList<String> appetizers=new ArrayList<String>(mainMenu.getAppetizers());
        ArrayList<String> desserts=new ArrayList<String>(mainMenu.getDesserts());


        muAdapter = new ArrayAdapter<String>(this,R.layout.single_row, R.id.innerText, sandwiches);

        ListView listView;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cutomer_menu, menu);
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
