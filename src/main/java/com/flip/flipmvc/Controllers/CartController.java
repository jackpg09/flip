package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.Forms.SearchForm;
import com.flip.flipmvc.Models.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("shoppingCart")
public class CartController extends AbstractController {


    @RequestMapping(value="")
    public String shoppingCart(Model model) {
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("title", "Shopping Cart");
        model.addAttribute("discs", ShoppingCart.getDiscsInCart());

        return "cart/index";
    }

    @RequestMapping(value="add/{discId}")
    public String addDiscToCart(Model model, @PathVariable("discId") int discId) {

        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("title", "Shopping Cart");

        ShoppingCart.addDiscToCart(marketDiscDao.findOne(discId));

        return "cart/index";
    }

    @RequestMapping(value="remove/{discId}", method=RequestMethod.POST)
    public String removeDiscFromCart(@PathVariable("discId") int discId) {
        ShoppingCart.removeDiscFromCart(marketDiscDao.findOne(discId));
        return "redirect:";
    }
}
