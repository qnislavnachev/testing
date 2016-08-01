package task3;

import java.util.*;

public class Store {
    private Map<Products, Integer> storeList;

    public Store() {
        storeList = new HashMap<>();

    }

    public int getAmount(Products product) {
        return storeList.get(product);

    }

    public void addProduct(Products product, int amount) {
        if (!storeList.containsKey(product)) {
            if (product.getMaxAmount() >= amount) {
                storeList.put(product, amount);
            } else {
                throw new NoEnoughSpace("No Enough Space!");
            }
        } else {
            if ((getAmount(product) + amount) >= amount){
                storeList.replace(product, getAmount(product) + amount);
            } else {
                throw new NoEnoughSpace("No Enough Space!");
            }

        }
    }

    public void sellProduct(Products product, int amount) {
        if (getAmount(product) == 0) {
            storeList.remove(product);
        } else {
            if (storeList.containsKey(product) && getAmount(product) >= amount) {
                storeList.replace(product, getAmount(product) - amount);
            } else {
                throw new NoEnoughProducts("No enough products");
            }
        }

    }

    public void printProducts() {
        for (Products each : storeList.keySet()) {
            System.out.println("Key = " + each + ", Available amount = " + storeList.get(each));
        }
    }

    public List<Products> sort() {
        List<Products> list = new ArrayList<>(storeList.keySet());
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

