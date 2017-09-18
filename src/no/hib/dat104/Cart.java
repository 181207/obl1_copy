package no.hib.dat104;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
    public void removeItem(Item item) {items.remove(item); }
    public void removeItem(int itemIndex) {items.remove(itemIndex); }
}
