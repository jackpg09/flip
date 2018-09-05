package com.flip.flipmvc.Models;

import javax.persistence.Entity;

import java.util.ArrayList;

@Entity
public class ShoppingCart {


    private static ArrayList<MarketDisc> discsInCart = new ArrayList<>();


    public static void addDiscToCart(MarketDisc newDisc) {
        discsInCart.add(newDisc);
    }

    public static void removeDiscFromCart(MarketDisc goneDisc) {
        discsInCart.remove(goneDisc);
    }

    public static ArrayList<MarketDisc> getDiscsInCart() {
        return discsInCart;
    }
}
