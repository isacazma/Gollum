package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Shop;
import nl.hu.bep.shopping.model.Shopper;
import nl.hu.bep.shopping.model.ShoppingList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;

@Path("lists")
public class ListsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppingLists() {
        if (Shop.getShop().getAllShoppingLists().isEmpty())
            return Response.noContent().build(); // 204: succesvol verzoek, maar niets om te tonen
        ArrayList<HashMap<String,String>> info = new ArrayList<>();
        for(ShoppingList sl : Shop.getShop().getAllShoppingLists()){
            HashMap<String,String> lijst = new HashMap<>();
            lijst.put("listname", sl.getName());
            lijst.put("owner", sl.getOwner().getName());
            info.add(lijst);
        }
        return Response.ok(info).build(); //op deze manier houden we jackson binnen de perken zonder @JsonIgnore
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createShoppingList(@FormParam("owner") String owner, @FormParam("name") String listname) {
        //Dit voorbeeld zo expliciet mogelijk uitgewerkt, bevat vele checks, maar geeft ENKEL statuscodes terug en gebruikt FormParam als input
        Shopper found = Shopper.getAllShoppers().stream().filter(e->e.getName().equals(owner)).findFirst().orElse(null);
        if (found != null) { //werkt want equals checkt enkel op name van shopper
            if (found.addList(new ShoppingList(listname, found))) { //addList laat ons weten of het toevoegen gelukt is (ivm dubbele namen kan dit mislukken)
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.CONFLICT).build(); //er bestond al zo'n lijst waarschijnlijk
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); //er bestond geen shopper met die naam
        }
    }
}
