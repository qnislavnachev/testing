package task3;

import java.util.*;

public class Store {
    private Map<String, Product> storeList;
    private int maxQuantity;

    public Store() {
        storeList = new HashMap<>();
        maxQuantity = 20;

    }

    public int availableOfQuantity(String product) {
        if (!storeList.containsKey(product)) {
            return 0;
        }
        Product p = storeList.get(product);
        return p.quantity;
    }

    public void addProduct(Product product) {
        Product p = storeList.get(product.name);
        if ((storeList.containsKey(product.name) && p.quantity + product.quantity > maxQuantity) || product.quantity > maxQuantity) {
            throw new NoEnoughSpace("No enough Space!");
        }
        if (storeList.containsKey(product.name)) {
            int newQuantity = storeList.get(product.name).quantity + product.quantity;
            storeList.replace(product.name, new Product(product.name, product.price, newQuantity));
        } else {
            storeList.put(product.name, product);

        }
    }

    public void sellProduct(String product, int amount) {
        if (product == null || availableOfQuantity(product) < amount) {
            throw new NoEnoughProducts("No Enough Products!");
        }
        Product p = storeList.get(product);
        int newAmount = availableOfQuantity(product) - amount;
        storeList.put(product, new Product(product, p.price, newAmount));


    }

    public List<Product> sortByPrice() {
        List<Product> list = new ArrayList<>(storeList.values());
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

