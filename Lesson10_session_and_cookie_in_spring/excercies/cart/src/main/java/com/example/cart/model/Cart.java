package com.example.cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> cart;


    public Cart() {
        cart = new HashMap<>();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public Integer countProductQuantity(Product product) {
        return cart.get(product);
    }

    public Integer countItemQuantity() {
        return cart.size();
    }
    public void addToCart(Product product) {
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product), cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    public double countTotalPayment() {
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            payment += entry.getKey().getPrice() *  entry.getValue();
        }
        return payment;
    }
}
