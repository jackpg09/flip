package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.Forms.SearchForm;
import com.flip.flipmvc.Models.MarketDisc;
import com.flip.flipmvc.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("shoppingCart")
public class CartController extends AbstractController {


    @RequestMapping(value="")
    public String shoppingCart(Model model, HttpServletRequest request) {

        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("title", "Shopping Cart");

        Integer userId = (Integer) request.getSession().getAttribute(userSessionKey);
        User user = userDao.findOne(userId);

        model.addAttribute("discs", user.getCartDiscs());

        return "cart/index";
    }


    @RequestMapping(value="add/{discId}", method = RequestMethod.GET)
    public String addDiscToCart(@PathVariable("discId") int discId, HttpServletRequest request) {

        MarketDisc newCartDisc = marketDiscDao.findOne(discId);

        Integer userId = (Integer) request.getSession().getAttribute(userSessionKey);
        User user = userDao.findOne(userId);

        user.addCartDisc(newCartDisc);
        userDao.save(user);

        return "redirect:/shoppingCart";
    }



    @RequestMapping(value="remove/{discId}", method = RequestMethod.GET)
    public String removeDiscFromCart(@PathVariable("discId") int discId, HttpServletRequest request) {

        MarketDisc oldCartDisc = marketDiscDao.findOne(discId);

        Integer userId = (Integer) request.getSession().getAttribute(userSessionKey);
        User user = userDao.findOne(userId);

        user.removeCartDisc(oldCartDisc);
        userDao.save(user);

        return "redirect:/shoppingCart";
    }
}
