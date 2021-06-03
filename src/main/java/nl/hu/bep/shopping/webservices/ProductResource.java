package nl.hu.bep.shopping.webservices;

import nl.hu.bep.shopping.model.Product;
import nl.hu.bep.shopping.model.Shop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("product/{name}")
public class ProductResource {

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchProduct(@PathParam("name") String oldName, @FormParam("newproductname") String newName) {
        Product product = Product.getProductByName(oldName);

        if (product != null) {
            if (!newName.isBlank()) {
                product.setName(newName);
                return Response.ok().build();
            } else return Response.status(Response.Status.BAD_REQUEST).build();
        } else return Response.status(Response.Status.NOT_FOUND).build();
    }

}
