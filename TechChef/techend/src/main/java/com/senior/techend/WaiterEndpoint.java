package com.senior.techend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import com.senior.techend.order.Order;
import com.senior.techend.restaurant.Table;
import com.senior.techend.user.Waiter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;


/**
 * Created by Mohammad on 12/16/2014.
 */

@Api(name = "waiterApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "techend.senior.com", ownerName = "techend.senior.com", packagePath = ""))
public class WaiterEndpoint {

    public WaiterEndpoint () {

        // register classes here
        ObjectifyService.register(Waiter.class);
        ObjectifyService.register(Table.class);

    }

/**
 * Return a collection of tables
 *
 * @param count The number of tables
 * @return a list of tables
 */

@ApiMethod(name="getTableList")
public CollectionResponse<Table> getTableList(@Nullable @Named("cursor") String cursorString,
                                           @Nullable @Named("count") Integer count) {

    Query<Table> query = ObjectifyService.ofy().load().type(Table.class);
    if (count != null) query.limit(count);
    if (cursorString != null && cursorString != "")
    {
        query = query.startAt(Cursor.fromWebSafeString(cursorString));
    }

    List<Table> records = new ArrayList<Table>();
    QueryResultIterator<Table> iterator = query.iterator();
    int num = 0;
    while (iterator.hasNext())
    {
        records.add(iterator.next());
        if (count != null) {
            num++;
            if (num == count) break;
        }
    }

    //Find the next cursor
    if (cursorString != null && cursorString != "") {
        Cursor cursor = iterator.getCursor();
        if (cursor != null) {
            cursorString = cursor.toWebSafeString();
        }
    }
    return CollectionResponse.<Table>builder().setItems(records).setNextPageToken(cursorString).build();
}

    /**
     * This set Status of existing <code>Table</code> object.
     * @param order The object to be added.
     * @return The object to be updated.
     */


    @ApiMethod(name="confirmOrderStatus")
public void confirmOrderStatus(Order order)throws NotFoundException
    {
        Table response = findTable(order.getTableId());


        response.setTableStatus("Confirmed");

         ObjectifyService.ofy().save().entity(response).now();

    }

    private Table findTable(long tableId) {

        return ObjectifyService.ofy().load().type(Table.class).id(tableId).now();

    }


}


