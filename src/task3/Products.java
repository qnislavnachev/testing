package task3;

public class Products {

    private String name;
    private int price;
    private int maxAmount;

    public Products(String name, int price, int maxAmount) {
        this.name = name;
        this.price = price;
        this.maxAmount = maxAmount;
    }

    public int getMaxAmount(){
        return maxAmount;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "name: " + name + ", price: " + price;
    }


}

