package almereGym.sporten.model;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PriveLes {

    private String name;
    public static List<PriveLes> allPriveLes = new ArrayList<>();
    public ArrayList<User> losseLessen = new ArrayList<User>() ;




    public PriveLes(String nm) {
        this.name = nm;

        if (!allPriveLes.contains(this)) allPriveLes.add(this);
    }
    public String getNaam() {
        return name;
    }

    public static boolean addUser(PriveLes gg, User g){
        boolean fout = false;
        if (allPriveLes.contains(gg)) {
            if(gg.losseLessen.size() <= 60){
                gg.losseLessen.add(g);
                fout = true;
            }

        } return fout;}


    public String getName() {
        return name;
    }

    public void setPriveName(String name) {
        this.name = name;
    }



    public static List<PriveLes> getAllPriveLes() {
        return Collections.unmodifiableList(allPriveLes);
    }

    public static boolean verwijderlosseLessen(User g,PriveLes gg){
        boolean fout = false;
        if(gg.losseLessen.contains(g)){
            gg.losseLessen.remove(g);
            fout = true;
        }

        return fout;}

    public static boolean verwijderLes(PriveLes g){
        boolean fout = false;
        if(allPriveLes.contains(g)){
            allPriveLes.remove(g);
            fout = true;
        } return  fout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriveLes product = (PriveLes) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


