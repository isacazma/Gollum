package almereGym.sporten.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Shopper implements NamedObject {
    private String name;
    private static List<Shopper> allShoppers = new ArrayList<>();
    private List<ShoppingList> allLists = new ArrayList<>();

    public Shopper(String nm) {
        this.name = nm;
        if (!allShoppers.contains(this)) allShoppers.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopper shopper = (Shopper) o;
        return name.equals(shopper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public static List<Shopper> getAllShoppers() {
        return Collections.unmodifiableList(allShoppers);
    }

    public static boolean removeShopper(String shopperName) {
        Shopper foundShopper = null;
        for (Shopper shopper : allShoppers) {
            if (shopper.getName().equals(shopperName)) {
                foundShopper = shopper;
                break;
            }
        }

        if (foundShopper != null) {
            allShoppers.remove(foundShopper);
            ShoppingList.removeListsFrom(foundShopper);
            return true;
        } else return false;
    }


    public boolean addList(ShoppingList newList) {
        if (!allLists.contains(newList)) {
            return allLists.add(newList);
        }
        return false;
    }

    @JsonIgnore //ivm recursie door jackson
    public List<ShoppingList> getAllLists() {
        return Collections.unmodifiableList(allLists);
    }

    public int getAmountOfLists() {
        return allLists.size();
    }
}
