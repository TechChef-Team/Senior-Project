package com.senior.techend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.ObjectifyService;

import javax.inject.Named;


/**
 * Created by Mohammad on 12/16/2014.
 */

@Api(name = "waiterApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "techend.senior.com", ownerName = "techend.senior.com", packagePath = ""))
public class WaiterEndpoint {

    public WaiterEndpoint () {

        // register classes here
        //ObjectifyService.register(Order.class);

    }
}
