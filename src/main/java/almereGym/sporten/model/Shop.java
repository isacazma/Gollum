package almereGym.sporten.model;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Shop {
    private static Shop deShop = new Shop();

    private static Predicate<NamedObject> hasName(String name) {
        return e -> e.getName().equals(name);
    }

    public static Shop getShop() {
        return deShop;
    }

    public Shop() {
        //Initializing dummy data moved to contextinitialization
    }

    public List<ShoppingList> getAllShoppingLists() {
        return Collections.unmodifiableList(ShoppingList.getAllLists());
    }

    public ShoppingList getShoppingListByName(String nm) {
        return ShoppingList.getAllLists().stream().filter(hasName(nm)).findFirst().orElse(null);
    }

    public List<Shopper> getAllPersons() {
        return Collections.unmodifiableList(Shopper.getAllShoppers());
    }

    public List<ShoppingList> getListFromPerson(String nm) {
        Shopper found = Shopper.getAllShoppers().stream().filter(hasName(nm)).findFirst().orElse(null);
        return found == null ? null : Collections.unmodifiableList(found.getAllLists());
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(Product.getAllProducts());
    }
}
