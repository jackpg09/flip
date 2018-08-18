//package com.flip.flipmvc.Controllers;
//
//import com.flip.flipmvc.Models.Forms.SearchForm;
//import com.flip.flipmvc.Models.MarketDisc;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.ArrayList;
//
//@Controller
//@RequestMapping("flip")
//public class SearchController extends FlipController {
//
//    @RequestMapping(value="search", method = RequestMethod.GET)
//    public String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
//
//        ArrayList<MarketDisc> matchingDiscs = new ArrayList<>();
//
//        for (MarketDisc disc : marketDiscDao.findAll()) {
//            if (disc.getName().toLowerCase().contains(searchForm.getKeyword())){
//
//                matchingDiscs.add(disc);
//                model.addAttribute("discs", matchingDiscs);
//
//                return "redirect:/flip";
//            }
//        }
//        return "redirect:/flip";
//    }
//}
