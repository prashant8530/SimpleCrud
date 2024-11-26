package org.example.simplecrud.resources;

import org.example.simplecrud.models.Item;
import org.example.simplecrud.services.ItemService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GET
    public Collection<Item> getItems() {
        return itemService.getAllItems();
    }

    @GET
    @Path("/{id}")
    public Response getItem(@PathParam("id") int id) {
        Item item = itemService.getItemById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(item).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(Item item) {
        Item createdItem = itemService.createItem(item);
        return Response.status(Response.Status.CREATED).entity(createdItem).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateItem(@PathParam("id") int id, Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        if (updatedItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedItem).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") int id) {
        boolean deleted = itemService.deleteItem(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}