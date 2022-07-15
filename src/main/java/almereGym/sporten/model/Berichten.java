package almereGym.sporten.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Berichten {
    private String FullName;
    private String Email;
    private String Reden;
    private String Bericht;


    public Berichten(String fullName, String email, String reden, String bericht) {
        FullName = fullName;
        Email = email;
        Reden = reden;
        Bericht = bericht;
        allBerichetn.add(this);
    }


    public static List<Berichten> allBerichetn = new ArrayList<>();




    public static List<Berichten> getAllBerichetn() {

        return Collections.unmodifiableList(allBerichetn);
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getReden() {
        return Reden;
    }

    public void setReden(String reden) {
        Reden = reden;
    }

    public String getBericht() {
        return Bericht;
    }

    public void setBericht(String bericht) {
        Bericht = bericht;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
