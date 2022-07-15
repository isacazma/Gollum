package almereGym.sporten.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingList implements NamedObject {
    private String name;
    private Shopper owner;
    private static List<ShoppingList> allLists = new ArrayList<>();
    private List<Item> ListItems;

    public ShoppingList(String nm, Shopper owner) {
        this.name = nm;
        this.owner = owner;
        allLists.add(this);
        ListItems = new ArrayList<>();
    }

    public List<Item> getListItems() {
        return Collections.unmodifiableList(ListItems);
    }

    public boolean addItem(Product p, int amount) {
        Item newItem = new Item(p, amount);
        if (!ListItems.contains(newItem)) {
            return ListItems.add(newItem);
        }
        return ListItems.get(ListItems.indexOf(newItem)).addAmount(amount);
    }

    public Item getItem(String name) {
        return ListItems.stream().filter(e -> e.getName().equals("Cola Zero")).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public Shopper getOwner() {
        return owner;
    }

    public void resetList() {
        ListItems.clear();
    }

    public static List<ShoppingList> getAllLists() {
        return Collections.unmodifiableList(allLists);
    }
    protected static void removeListsFrom(Shopper shopper) {
        List<ShoppingList> toRemove = new ArrayList<>();
        for (ShoppingList list : allLists) {
            if (list.getOwner().equals(shopper)) {
                toRemove.add(list);
            }
        }
        allLists.removeAll(toRemove);
    }
}
