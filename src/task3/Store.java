package task3;

import java.util.*;

public class Store {
    private Map<String, Product> products = new HashMap<>();
    private int maxQuantity;

    public Store(int maxQuantity) {
        this.maxQuantity = maxQuantity;

    }

    public int availableOfQuantity(String product) {
        if (!products.containsKey(product)) {
            return 0;
        }
        Product p = products.get(product);
        return p.quantity;
    }

    public void addProduct(Product product) {
        Product p = products.get(product.name);
        if (products.containsKey(product.name) && p.quantity + product.quantity > maxQuantity || product.quantity > maxQuantity) {
            throw new WareHouseException("No enough Space!");
        }
        if (products.containsKey(product.name)) {
            int newQuantity = products.get(product.name).quantity + product.quantity;
            products.replace(product.name, new Product(product.name, product.price, newQuantity));
            return;
        }
        products.put(product.name, product);
    }

    public void sellProduct(String product, int amount) {
        if (product == null || availableOfQuantity(product) < amount) {
            throw new WareHouseException("No Enough Products!");
        }
        Product p = products.get(product);
        int newAmount = availableOfQuantity(product) - amount;
        products.put(product, new Product(product, p.price, newAmount));
    }

    public List<Product> sortByPrice() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.price > o2.price) {
                    return 1;
                }
                if (o1.price < o2.price) {
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }
}

