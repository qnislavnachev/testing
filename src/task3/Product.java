package task3;

public class Product {

    private final String name;
    private int price;
    private int maxAmount;
    private int quantity;

    public Product(String name, int price, int maxAmount) {
        this.name = name;
        this.price = price;
        this.maxAmount = maxAmount;
        this.quantity = 0;
    }

    public Product(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price;
    }


}

