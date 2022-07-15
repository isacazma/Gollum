package almereGym.sporten.webservices;
import almereGym.sporten.model.*;
//import almereGym.sporten.model.Shop;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static almereGym.sporten.model.User.allUsers;

@Path("verwijder/{nr}")
public class VerwijderResource {

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("nr") String nr) {
        int i=Integer.parseInt(nr);
        if(User.removeUserNr(i))
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build(); //dit geeft een 404
    }



//        @DELETE
//        @Path("verwijdere/{nr}")
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response deleteLeden(@PathParam("nr") String nr) {
//            int i=Integer.parseInt(nr);
//                for (User user : allUsers){
//                    if(user.getNr() == i){
//                       if(user.getRole().equals("medewerker")|| user.getRole().equals("manager")){
//
//                          return  Response.status(Response.Status.BAD_REQUEST).build();
//                    }
//                       else{
//
//                           User.removeUserNr(i);
//                           return Response.ok().build();
//                       }
//                }
//
//            }return Response.status(Response.Status.NOT_FOUND).build(); //dit geeft een 404
}
