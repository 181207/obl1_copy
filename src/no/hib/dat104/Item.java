package no.hib.dat104;

public class Item {
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
