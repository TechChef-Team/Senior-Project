package com.senior.techchef;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.senior.techchef.orders.menu;
import com.senior.techchef.orders.orders;
import com.senior.techchef.users.ordersList;

import java.util.ArrayList;


public class ChefView extends Activity {

    ArrayAdapter<String> muAdapter;
    orders order1 = new orders();
    orders order2 = new orders();
    orders order3 = new orders();

    final Context context = this;
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












    }
   /* private static class ColoredView extends View {

        private boolean mExpanded = false;

        private LinearLayout.LayoutParams mCompressedParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 50);

        private LinearLayout.LayoutParams mExpandedParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 200);

        private ColoredView(Context context) {
            super(context);
            int red = (int)(Math.random() * 128 + 127);
            int green = (int)(Math.random() * 128 + 127);
            int blue = (int)(Math.random() * 128 + 127);
            int color = 0xff << 24 | (red << 16) |
                    (green << 8) | blue;
            setBackgroundColor(color);
            setLayoutParams(mCompressedParams);
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Size changes will cause a LayoutTransition animation if the CHANGING
                    // transition is enabled
                    setLayoutParams(mExpanded ? mCompressedParams : mExpandedParams);
                    mExpanded = !mExpanded;
                    requestLayout();
                }
            });
        }
    }*/

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

    public void orderFinished(View t) {



    }
}

