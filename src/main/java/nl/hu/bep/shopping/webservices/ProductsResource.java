package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Shop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("products")
public class ProductsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        if (Shop.getShop().getAllProducts().isEmpty()) return Response.noContent().build();
        return Response.ok(Shop.getShop().getAllProducts()).build();
    }

}
