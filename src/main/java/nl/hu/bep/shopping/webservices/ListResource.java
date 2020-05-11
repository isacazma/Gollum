package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Item;
import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.ShoppingList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("list")
public class ListResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getShoppingLists() {
        Shop shop = Shop.getShop();
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (ShoppingList sl : shop.getAllShoppingLists()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", sl.getName());
            job.add("owner", sl.getOwner().getName());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public String getShoppingListByName(@PathParam("name") String name) {
        Shop shop = Shop.getShop();
        JsonObjectBuilder listjob = Json.createObjectBuilder();
        ShoppingList list = shop.getShoppingListByName(name);
        try {
            listjob.add("name", list.getName());
            listjob.add("owner", list.getOwner().getName());
            JsonArrayBuilder jab = Json.createArrayBuilder();
            for (Item e : list.getListItems()) {
                JsonObjectBuilder itemjob = Json.createObjectBuilder();
                itemjob.add("itemName", e.getName());
                itemjob.add("itemAmount", e.getAmount());
                jab.add(itemjob);
            }
            listjob.add("items", jab);
        } catch (NullPointerException e) {
            listjob.add("error", "No list by that name");
        }
        return listjob.build().toString();

    }
}
