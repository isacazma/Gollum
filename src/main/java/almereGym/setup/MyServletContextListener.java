package almereGym.setup;

import almereGym.sporten.model.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static almereGym.sporten.model.User.*;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    User lid1 = new User("kees","koen","lid",1);
    User lid2 = new User("henk","a","lid",2);
    User lid3 = new User("c","c","medewerker",3);
    User a = new User("a","a", "lid",4);
    User b = new User("b","b", "manager",5);
    PriveLes lesje = new PriveLes("rennen");
    PriveLes lesjee = new PriveLes("boxen");
    Berichten ber = new Berichten("d","d","d","d");

    Producten product1 = new Producten("koekje");
    Producten product2 = new Producten("zonnebank + 15");
    Producten product3 = new Producten("cola");
    Producten product4 = new Producten("handoek");
    Producten product5 = new Producten("water fles");
    Producten product6 = new Producten("slipers");

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        onlineAllUsers.add(lid1);
        onlineAllUsers.add(a);
        onlineMedewerker.add(lid3);
        allUsers.add(a);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("terminating application");
    }

}
