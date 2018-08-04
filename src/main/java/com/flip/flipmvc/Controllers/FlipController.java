package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.ClubType;
import com.flip.flipmvc.Models.Data.MarketDiscDao;
import com.flip.flipmvc.Models.MarketDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("flip")
public class FlipController {

    @Autowired
    MarketDiscDao marketDiscDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("discs", marketDiscDao.findAll());
        model.addAttribute("title", "Discs");
        return "flip/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddDiscForm(Model model) {

        model.addAttribute("title","Add Disc");
        model.addAttribute("disc", new MarketDisc());
        model.addAttribute("clubTypes", ClubType.values());
        return "flip/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddDiscForm(MarketDisc newDisc, Model model) {

        marketDiscDao.save(newDisc);

        return "redirect:";
    }

    @RequestMapping(value = "disc")
    public String displaySingleDisc(Model model, @RequestParam int id) {

        MarketDisc singleDisc = marketDiscDao.findOne(id);
        model.addAttribute("disc",singleDisc);
        model.addAttribute("title","Disc Detail");

        return "flip/disc-detail";
    }
}
