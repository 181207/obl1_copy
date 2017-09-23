package no.hib.dat104;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="webshop", name="item")
public class Item {
    @Id
    private String name;
    private double price;

    public Item (String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Item (String name) {
        this.name = name;
        this.price = 0;
    }
    public String getName() {return name;}
    public double getPrice() {return price;}
}
