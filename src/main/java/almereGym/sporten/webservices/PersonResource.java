package almereGym.sporten.webservices;

import almereGym.sporten.model.Shop;
import almereGym.sporten.model.Shopper;
import almereGym.sporten.model.ShoppingList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("shopper/{name}")
public class PersonResource {

    @GET
    @Path("shoppinglists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppingListsFromPerson(@PathParam("name") String name) {
        Shop shop = Shop.getShop();
        List<ShoppingList> lists = shop.getListFromPerson(name);
        if(lists == null){
            return Response.status(Response.Status.NO_CONTENT).build(); //dit geeft een 204
        }
        return Response.ok(lists).build(); //inclusief lijstitems dus weer
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("name") String name) {
        if(Shopper.removeShopper(name))
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build(); //dit geeft een 404
    }
}
