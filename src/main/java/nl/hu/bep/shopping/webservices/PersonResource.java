package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.Shopper;
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
import javax.ws.rs.core.Response;
import java.util.List;

@Path("shopper")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppers() {
        Shop shop = Shop.getShop();

        List<Shopper> shoppers = shop.getAllPersons();
        if(shoppers.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(shoppers).build();

    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppingListsFromPerson(@PathParam("name") String name) {
        Shop shop = Shop.getShop();
        List<ShoppingList> lists = shop.getListFromPerson(name);
        if(lists == null){
            return Response.status(Response.Status.NO_CONTENT).build(); //dit geeft een 204
        }
        return Response.ok(lists).build(); //inclusief lijstitems dus weer
    }
}
