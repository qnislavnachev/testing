package task3;

import java.util.*;

public class Store {
    private Map<String, Product> storeList;

    public Store() {
        storeList = new HashMap<>();

    }

    public int availableOfQuantity(String product) {
        int value = 0;
        for (Product each : storeList.values()) {
            if (each.getName() == product) {
                value = each.getQuantity();
            }
        }
        return value;
    }

    public void addProduct(Product product, int amount) {
        if (!storeList.containsKey(product.getName()) && product.getMaxAmount() >= amount) {
            storeList.put(product.getName(), product);
            product.setQuantity(amount);
        } else if (storeList.containsKey(product.getName()) && storeList.get(product.getName()).getMaxAmount() >= (storeList.get(product.getName()).getQuantity() + amount)) {
            int currentAmount = storeList.get(product.getName()).getQuantity();
            storeList.get(product.getName()).setQuantity(currentAmount + amount);
        } else {
            throw new NoEnoughSpace("No Enough Space");
        }
    }


    public void sellProduct(String product, int amount) {
        Product p = storeList.get(product);
        if (p.getQuantity() == 0) {
            storeList.remove(product);
        }
        if (p.getQuantity() >= amount) {
            p.setQuantity(p.getQuantity() - amount);
        } else {
            throw new NoEnoughProducts("No Enough Products");
        }

    }

    public List<Product> sort() {
        List<Product> list = new ArrayList<>(storeList.values());
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }
}

