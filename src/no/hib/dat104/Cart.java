package no.hib.dat104;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema="webshop", name="cart")
public class Cart {


    @OneToMany(mappedBy = "cart")
    private List<Item> items = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;
//    id = 0;

    public void addItem(Item item) {
//        item.setId(this.id);
//        this.id++;
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
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
