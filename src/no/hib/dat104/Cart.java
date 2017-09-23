package no.hib.dat104;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema="webshop", name="cart")
public class Cart {
    @Id
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
    public void removeItem(Item item) {items.remove(item); }
    public void removeItem(int itemIndex) {items.remove(itemIndex); }
    public void removeItem(String itemname) {
        Item toBeRemoved = null;
        for (Item i : items) {
            if (i.getName().contains(itemname)) {
                toBeRemoved = i;
                break;
            }
        }
        if (toBeRemoved != null) {
            removeItem(toBeRemoved);
        }
    }
}
