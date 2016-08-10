package task3;

public class Product {

    private final String name;
    private final int price;
    private final int maxQuantity;

    public Product(String name, int price, int maxQuantity) {
        this.name = name;
        this.price = price;
        this.maxQuantity = maxQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;

    }

    public int getPrice() {
        return price;

    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price;
    }


}

