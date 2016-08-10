package task3;

import java.util.*;

public class Store {
    private Map<Product, Integer> storeList;

    public Store() {
        storeList = new HashMap<>();

    }

    public int availableOfQuantity(Product product) {
        int value = 0;
        if (storeList.containsKey(product)) {
            value = storeList.get(product);
        }
        return value;
    }

    public void addProduct(Product product, int amount) {
        int newAmount = availableOfQuantity(product) + amount;
        if (product.getMaxQuantity() <= amount || product.getMaxQuantity() <= newAmount) {
            throw new NoEnoughSpace("NoEnoughSpace!");
        }
        if (storeList.containsKey(product)) {
            storeList.replace(product, newAmount);
        } else {
            storeList.put(product, amount);
        }
    }

    public void sellProduct(Product product, int amount) {
        if (product == null || availableOfQuantity(product) < amount) {
            throw new NoEnoughProducts("No Enough Products!");
        } else {
            int newAmount = availableOfQuantity(product) - amount;
            storeList.replace(product, newAmount);
        }
    }

    public List<Product> sortByPrice() {
        List<Product> list = new ArrayList<>(storeList.keySet());
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                }
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }
}

