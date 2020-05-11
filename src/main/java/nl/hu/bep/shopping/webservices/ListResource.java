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
import javax.ws.rs.core.Response;

@Path("list")
public class ListResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppingLists() {
        if(Shop.getShop().getAllShoppingLists().isEmpty()) return Response.noContent().build(); // 204: succesvol verzoek, maar niets om te tonen
        return Response.ok(Shop.getShop().getAllShoppingLists()).build(); //kleine consequentie is dat hier de listitems ook getoond worde, voorheen was dat niet zo
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Response getShoppingListByName(@PathParam("name") String name) {
        if(Shop.getShop().getShoppingListByName(name)==null) return Response.noContent().build();
        return Response.ok(Shop.getShop().getShoppingListByName(name)).build();

    }
}
