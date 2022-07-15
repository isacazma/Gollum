package almereGym.sporten.webservices;

import almereGym.sporten.model.Berichten;
import almereGym.sporten.model.User;
import almereGym.sporten.model.berichtRequest;
import almereGym.sporten.model.userRequest;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static almereGym.sporten.model.Berichten.getAllBerichetn;
import static almereGym.sporten.model.User.getAllUser;

@Path("online")
public class OnlineResource {


    @GET
    @Path("medewerker")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMedewerker() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (User p : User.getDitMedewerker()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("De online medewerker ", p.getName());
            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();
    }


    @GET
    @Path("lid")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (User p : User.getdit()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("De online lid is ", p.getName());

            jab.add(job);
        }
        JsonArray array = jab.build();
        return array.toString();
    }

    @GET
    @Path("alleUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleUsers() {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = "Alle users ";
        jab.add(intro);

        for (User p : getAllUser()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getName() + " en wachtwoord is " + p.getPass() + " en zijn rol is " + p.getRole()+ " en zijn nr " + p.getNr();
            job.add("De User", bijde);

            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();
    }

    @POST
    @Path("nieuwLid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addnieuweLeden(userRequest requestData) {
        String naam = requestData.name;
        String pas = requestData.pass;
        String roll = requestData.roll;
        if(roll == null){
            roll = "lid";
        }
        User newUser = new User(naam, pas, roll,getAllUser().size() + 1);
        return Response.ok(newUser).build();
    }


    @POST
    @Path("nieuwLidMedewerker")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addnieuweLedenMedewerker(userRequest requestData) {
        String naam = requestData.name;
        String pas = requestData.pass;
        String roll = "lid";
        User newUser = new User(naam, pas, roll,getAllUser().size() + 1);
        return Response.ok(newUser).build();

    }


    @POST
    @Path("nieuwBericht")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response NieuwBericht(berichtRequest requestData) {

        String fullName = requestData.FullName;
        String email = requestData.Email;
        String reden = requestData.Reden;
        String bericht = requestData.Bericht;
        Berichten newBericht = new Berichten(fullName, email, reden,bericht);
        return Response.ok(newBericht).build();
    }


    @GET
    @Path("lidOnlineKeuze")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserskeuze() {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        int een = 0;
        for (User p : User.getdit()) {
            een ++;

        }
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("Er zijn zo veel personen momenteel in de sportschol   ", een);
        jab.add(job);
        JsonArray array = jab.build();
        return array.toString();

    }



    @GET
    @Path("alleBerichtenTerug")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleBerichtenTerug() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = "Alle Berichten ";
        jab.add(intro);

        for (Berichten p : getAllBerichetn()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getFullName() + " en email is " + p.getEmail() + " en zijn rede " + p.getReden()+ " Bericht " + p.getBericht();
            job.add("Het bericht van ", bijde);



            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }

}




