package org.example.simplecrud;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.example.simplecrud.resources.ItemResource;
import org.example.simplecrud.services.ItemService;

public class SimpleCrudApplication extends Application<SimpleCrudConfiguration> {

    public static void main(String[] args) throws Exception {
        new SimpleCrudApplication().run(args);
    }

    @Override
    public void run(SimpleCrudConfiguration configuration, Environment environment) {
        final ItemService itemService = new ItemService();
        final ItemResource itemResource = new ItemResource(itemService);

        environment.jersey().register(itemResource);
    }
}