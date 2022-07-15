package almereGym.sporten.webservices;

import almereGym.sporten.model.Producten;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static almereGym.sporten.model.ProductBalie.getAllProducten;
import static almereGym.sporten.model.Producten.getAllProductenLijst;
@Path("producten")
public class ProductenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String alleProductenDieErZijn() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = " Lijst met Producten die u kan bestelen in de app  ";
        jab.add(intro);

        for (Producten producten : getAllProductenLijst()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = producten.getFullName()  ;
            job.add("Het product  ", bijde);


//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }
}
