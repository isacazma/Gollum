package almereGym.sporten.webservices;

import almereGym.sporten.model.Shop;
import almereGym.sporten.model.Shopper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

@Path("shoppers")
public class PersonsResource {

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createShopper(@FormParam("owner") String owner, @FormParam("name") String shopperName) {
        if ("".equals(shopperName)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new SimpleEntry<>("message", "name is empty"))
                    .build();
        }

        new Shopper(shopperName);
        return Response.ok().build();
    }
}
