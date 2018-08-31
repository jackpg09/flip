package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.ClubType;
import com.flip.flipmvc.Models.Forms.SearchForm;
import com.flip.flipmvc.Models.MarketDisc;
import com.flip.flipmvc.Models.Speed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("list")
public class ListController extends AbstractController {


    @RequestMapping(value="drivers", method = RequestMethod.GET)
    public String listDrivers(Model model){

        ArrayList<MarketDisc> matchingDiscs = new ArrayList<>();

        for (MarketDisc disc : marketDiscDao.findAll()) {
            if (disc.getClubType() == ClubType.DRIVER) {
                matchingDiscs.add(disc);
            }
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("discs", matchingDiscs);
        }
        return "flip/index";
    }

    @RequestMapping(value="fairway-drivers", method = RequestMethod.GET)
    public String listFairwayDrivers(Model model){

        ArrayList<MarketDisc> matchingDiscs = new ArrayList<>();

        for (MarketDisc disc : marketDiscDao.findAll()) {
            if (disc.getClubType() == ClubType.FAIRWAY_DRIVER) {
                matchingDiscs.add(disc);
            }
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("discs", matchingDiscs);
        }
        return "flip/index";
    }

    @RequestMapping(value="mid-ranges", method = RequestMethod.GET)
    public String listMidRanges(Model model){

        ArrayList<MarketDisc> matchingDiscs = new ArrayList<>();

        for (MarketDisc disc : marketDiscDao.findAll()) {
            if (disc.getClubType() == ClubType.MID_RANGE) {
                matchingDiscs.add(disc);
            }
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("discs", matchingDiscs);
        }
        return "flip/index";
    }

    @RequestMapping(value="putters", method = RequestMethod.GET)
    public String listPutters(Model model){

        ArrayList<MarketDisc> matchingDiscs = new ArrayList<>();

        for (MarketDisc disc : marketDiscDao.findAll()) {
            if (disc.getClubType() == ClubType.PUTTER) {
                matchingDiscs.add(disc);
            }
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("discs", matchingDiscs);
        }
        return "flip/index";
    }
}
