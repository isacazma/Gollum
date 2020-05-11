package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Product;
import nl.hu.bep.shopping.model.Shop;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("product")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts() {
        Shop shop = Shop.getShop();
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Product p : shop.getAllProducts()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("name", p.getName());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }
}
