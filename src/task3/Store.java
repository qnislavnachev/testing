package task3;

import java.util.*;

public class Store {
    private Map<String, Products> storeList;

    public Store() {
        storeList = new HashMap<>();

    }

    public int getAmount(Products product) {
        return product.getQuantity();

    }

    public int availableOfQuantity(String product) {
        int value = 0;
        for (Products each : storeList.values()) {
            if (each.getName() == product) {
                value = each.getQuantity();
            }
        }
        return value;
    }

    public void addProduct(Products product, int amount) {
        if (!storeList.containsKey(product.getName()) && product.getMaxAmount() >= amount) {
            storeList.put(product.getName(), product);
            product.setQuantity(amount);
        } else if (storeList.containsKey(product.getName()) && product.getMaxAmount() >= (getAmount(product) + amount)) {
            int currentAmount = getAmount(storeList.get(product.getName()));
            storeList.get(product.getName()).setQuantity(currentAmount + amount);
        } else {
            throw new NoEnoughSpace("No Enough Space");
        }
    }


    public void sellProduct(String product, int amount) {
        Products p = storeList.get(product);
        if (getAmount(p) == 0) {
            storeList.remove(product);
        }
        if (getAmount(p) >= amount) {
            p.setQuantity(p.getQuantity() - amount);
        } else {
            throw new NoEnoughProducts("No Enough Products");
        }

    }


    /**
     * @return list of products sort by price
     */

    public List<Products> sort() {
        List<Products> list = new ArrayList<>(storeList.values());
        Collections.sort(list, new Comparator<Products>() {
            @Override
            public int compare(Products o1, Products o2) {
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

