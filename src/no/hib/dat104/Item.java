package no.hib.dat104;

import javax.persistence.*;

@Entity
@Table(schema="webshop", name="item")
public class Item {

    public Item (){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {return price;}
    public void setPrice(double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}
}
