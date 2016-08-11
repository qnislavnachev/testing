package task3;

public class Product {

    public final String name;
    public final int price;
    public int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price;
    }


}

