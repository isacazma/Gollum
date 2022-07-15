package almereGym.sporten.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductBalie {
    private String FullName;
    private String Status;
    private String Bericht;


    public ProductBalie (String fullName,  String status, String bericht) {
        FullName = fullName;
        Status = status;
        Bericht = bericht;
        allProducten.add(this);
    }


    public static List<ProductBalie> allProducten = new ArrayList<>();




    public static List<ProductBalie> getAllProducten() {

        return Collections.unmodifiableList(allProducten);
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    public static ProductBalie getUserByName(String name){
        for (ProductBalie user : allProducten){
            if(user.getFullName().equals(name)){
                return user;
            }
        }
        return null;
    }
}
