package almereGym.sporten.model;



import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements NameObjectUser, Principal {
    private String name;
    private String pass;
    private String role;
    private int nr;
    public static List<User> allNr = new ArrayList<>();
//
//    public ArrayList<Product> boodschapenMand = new ArrayList<Product>() ;

    public static List<User> allUsers = new ArrayList<>();

    public static List<User> onlineAllUsers = new ArrayList<>();

    public static List<User> getdit() {
        return onlineAllUsers;
    }

    public static List<User> onlineMedewerker = new ArrayList<>();

    public static List<User> getDitMedewerker() {
        return onlineMedewerker;
    }








    public static List<User> getAllUser() {

        return Collections.unmodifiableList(allUsers);
    }






    public User(){}

    public User(String name){ this.name = name;}

    public User(String name, String pass, String role,int nr){

        this.name = name;
        this.pass = pass;

        if(!role.equals("lid") && !role.equals("medewerker") &&!role.equals("manager")){
            this.role = "lid";
        }
        else{
            this.role = role;}

        if(nr > allUsers.size() && !allUsers.contains(nr) ){
            this.nr = allUsers.size() + 1;
        }


        allUsers.add(this);
    }








    private static User aanWezig = new User();

    public static User getGAanwezig() {
        return aanWezig;
    }



    public static void setAanWezig(User user) {
        aanWezig = user;
    }

    private static User deUser = new User();

    public static User getUser() {
        return deUser;
    }






    public static String validateLogin(String name, String pass){
        for (User user : allUsers) {
            if(user.name.equals(name) && user.pass.equals(pass)){
                return user.role;
            }
        }
        return null;
    }
    public static User getUserNr(int nr){
        for (User user : allUsers){
            if(user.nr ==(nr)){
                return user;
            }
        }
        return null;
    }

    public static User getUserByName(String name){
        for (User user : allUsers){
            if(user.name.equals(name)){
                return user;
            }
        }
        return null;
    }



    public static boolean getGeheleUser(String name, String pass , String role,int nr){
        User s = new User(name,pass,role, nr);
        boolean d = false;
        for (User user : allUsers){
            if(user.getName().equals(s.getName()) && user.getPass().equals(s.getPass()) &&user.getRole().equals(s.getRole())){
                if(allUsers.contains(user)){
                    allUsers.remove(user);
                    d = true;}

            }
        }return d;
    }
    public static boolean removeUserNr(int userNrm) {
        boolean fout = false;
        User deGuy = null;
        for (User user : allUsers) {
            if (user.getNr() == userNrm) {
                deGuy = user;
                if (deGuy != null) {
                    allUsers.remove(deGuy);
                    onlineAllUsers.remove(deGuy);
                    fout = true;
                }
            }
        }
        return fout;  }

    public static boolean verwijderUser(User g){
        boolean fout = false;
        if(allUsers.contains(g)){
            allUsers.remove(g);
            fout = true;
        } return  fout;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }

    public String getRole(){
        return role;
    }

    public String getPass() {
        return pass;
    }

    public  int getNr(){
        return  nr;
    }

    public static void setAllNr(List<User> allNr) {
        User.allNr = allNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

