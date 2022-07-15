package almereGym.sporten.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Producten {
    private String FullName;





    public Producten(String fullName) {
        FullName = fullName;

        allProductenLijst.add(this);
    }


    public static List<Producten> allProductenLijst = new ArrayList<>();




    public static List<Producten> getAllProductenLijst() {

        return Collections.unmodifiableList(allProductenLijst);
    }




    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
