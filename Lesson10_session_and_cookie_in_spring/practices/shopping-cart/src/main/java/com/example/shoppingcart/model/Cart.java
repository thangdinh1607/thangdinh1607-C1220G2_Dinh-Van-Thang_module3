package com.example.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> cart = new HashMap<>();

    public Cart() {
    }

     public void addToCard(Product product){
        if(cart.containsKey(product)){
            cart.replace(product,cart.get(product),cart.get(product)+1);
        }else{
            cart.put(product,1);
        }
     }

    public Cart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }
}
