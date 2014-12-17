package com.senior.techend;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.senior.techend.order.Order;
import com.senior.techend.restaurant.Table;
import com.senior.techend.user.Waiter;

/**
 * Created by Mohammad on 12/15/2014.
 */
public class OfyService {

    static {
       ObjectifyService.register(Order.class);
        ObjectifyService.register(Table.class);
        ObjectifyService.register(Waiter.class);
    }

    public static Objectify ofy()
    {
        return OfyService.ofy();
    }

    public static ObjectifyFactory factory()
    {
        return OfyService.factory();
    }
}


