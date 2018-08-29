package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.Forms.SearchForm;
import com.flip.flipmvc.Models.MarketDisc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@Controller
@RequestMapping("search")
public class SearchController extends AbstractController {

    @RequestMapping(value="results", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute SearchForm searchForm) {

        model.addAttribute("searchForm", new SearchForm());

        String k = searchForm.getKeyword().toLowerCase();
        ArrayList<MarketDisc> matchingDiscs = new ArrayList<>();

        for (MarketDisc disc : marketDiscDao.findAll()) {
            if (disc.getPlastic().toLowerCase().contains(k) || disc.getDescription().toLowerCase().contains(k) ||
                    disc.getColor().toLowerCase().contains(k) || disc.getBrand().toLowerCase().contains(k) ||
                    disc.getName().toLowerCase().contains(k)) {
                matchingDiscs.add(disc);
            }
            model.addAttribute("discs", matchingDiscs);
        }
        return "flip/index";
    }
}
