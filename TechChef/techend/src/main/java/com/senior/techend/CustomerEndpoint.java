package com.senior.techend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.ConflictException;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.ObjectifyService;


import com.googlecode.objectify.cmd.Query;
import com.senior.techend.restaurant.Table;
import com.senior.techend.user.Waiter;
import com.senior.techend.order.Order;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * Created by Mohammad on 12/16/2014.
 */

@Api(name = "customerApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "techend.senior.com", ownerName = "techend.senior.com", packagePath = ""))
public class CustomerEndpoint {

    public CustomerEndpoint () {

        // register classes here
        ObjectifyService.register(Order.class);
        ObjectifyService.register(Table.class);


    }

    /**
     * This inserts a new <code>Order</code> object.
     * @param order The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertOrder")
    public Order insertOrder(Order order) throws ConflictException {
        //If if is not null, then check if it exists. If yes, throw an Exception
        //that it is already present
        /*if (order.getId() != -1) {
            if (findOrder(order.getId()) != null) {
                throw new ConflictException("Object already exists");
            }
        }*/
        //Since our @Id field is a Long, Objectify will generate a unique value for us
        //when we use put
        //ObjectifyService.register(Order.class);

        Table t = getTableOrder(order.getTableId());
        t.addOrder(order);
        ObjectifyService.ofy().save().entity(t).now();

        //ofy().save().entity(order).now();
        return order;
    }


    private Table getTableOrder(long id) {

        return ObjectifyService.ofy().load().type(Table.class).id(id).now();
    }



    




}
