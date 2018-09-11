package com.flip.flipmvc.Models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {


//    private static ArrayList<MarketDisc> discsInCart = new ArrayList<>();


    @OneToMany
    @JoinColumn(name = "user_id")
    private static List<MarketDisc> discsInCart = new ArrayList<>();



    public static void addDiscToCart(MarketDisc newDisc) {
        discsInCart.add(newDisc);
    }

    public static void removeDiscFromCart(MarketDisc goneDisc) {
        discsInCart.remove(goneDisc);
    }

    public static List<MarketDisc> getDiscsInCart() {
        return discsInCart;
    }
}
