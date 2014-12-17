/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.senior.techend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.google.api.server.spi.response.ConflictException;
import com.googlecode.objectify.ObjectifyService;
import com.senior.techend.user.Waiter;


import javax.inject.Named;


/**
 * Created by Mohammad on 12/17/2014.
 */

/**
 * An endpoint class we are exposing
 */
@Api(name = "tempApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "techend.senior.com", ownerName = "techend.senior.com", packagePath = ""))
public class TempEndpoint {

    public TempEndpoint(){

        ObjectifyService.register(Waiter.class);

    }

    /**
     * This inserts a new <code>Order</code> object.
     * @param waiter The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertWaiter")
    public Waiter insertWaiter(Waiter waiter) throws ConflictException {
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
        ObjectifyService.ofy().save().entity(waiter).now();
        //ofy().save().entity(order).now();
        return waiter;
    }

    /**
     * This insert a new  <code>Order</code> object by variables.
     * @param id,name The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertWaiterByVar")
    public Waiter insertWaiterByVar(@Named("id") Long id, @Named("status") String name) throws ConflictException{

        Waiter response = new Waiter(id,name);
        response= insertWaiter(response);
        return response;
    }

    /**
     * This insert a new  <code>Order</code> object by variables.
     * @param id,status The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "newInsertWaiterByVar")
    public Waiter newInsertWaiterByVar(@Named("id") Long id, @Named("status") String name) throws ConflictException{

        Waiter response = new Waiter(id,name);
        //response= insertWaiter(response);
        return response;
    }


}