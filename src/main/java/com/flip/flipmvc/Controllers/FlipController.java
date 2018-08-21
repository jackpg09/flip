package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.ClubType;
import com.flip.flipmvc.Models.Forms.SearchForm;
import com.flip.flipmvc.Models.MarketDisc;
import com.flip.flipmvc.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import java.util.ArrayList;


@Controller
@RequestMapping("flip")
public class FlipController extends AbstractController {


    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("discs", marketDiscDao.findAll());
        model.addAttribute("title", "All Discs");

        return "flip/index";
    }


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

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddDiscForm(Model model) {

        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("title","Add Disc");
        model.addAttribute("disc", new MarketDisc());
        model.addAttribute("clubTypes", ClubType.values());
        return "flip/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddDiscForm(@ModelAttribute("disc") @Valid MarketDisc newDisc, Errors errors, HttpServletRequest request, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Disc");
            model.addAttribute("clubTypes", ClubType.values());
            model.addAttribute("disc",newDisc);
            return "flip/add";
        }
        Integer userId = (Integer) request.getSession().getAttribute(userSessionKey);
        User user = userDao.findOne(userId);
        newDisc.setUser(user);
        marketDiscDao.save(newDisc);
        return "redirect:/user/home";
    }

    @RequestMapping(value = "disc")
    public String displaySingleDisc(Model model, @RequestParam int id) {
        model.addAttribute("searchForm", new SearchForm());
        MarketDisc singleDisc = marketDiscDao.findOne(id);
        model.addAttribute("disc",singleDisc);
        model.addAttribute("title","Disc Detail");
        return "flip/disc-detail";
    }

    @RequestMapping(value = "edit/{marketDiscId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int marketDiscId){

        MarketDisc d = marketDiscDao.findOne(marketDiscId);
        model.addAttribute("disc", d);
        model.addAttribute("clubTypes",ClubType.values());
        model.addAttribute("title","Edit Disc");
        return "flip/edit-disc";
    }


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute("disc") @Valid MarketDisc editedDisc, Errors errors, Model model, int marketDiscId, String name, String brand, ClubType clubType, String color,
                              String plastic, String description, int weight, int speed, int glide, int turn, int fade){
        if(errors.hasErrors()){
            model.addAttribute("title", "Edit Disc");
            model.addAttribute("clubTypes",ClubType.values());
            model.addAttribute("disc", editedDisc);

            return "flip/edit-disc";
        }
        marketDiscDao.findOne(marketDiscId);
        MarketDisc d = marketDiscDao.findOne(marketDiscId);
        d.setName(name);
        d.setBrand(brand);
        d.setClubType(clubType);
        d.setColor(color);
        d.setPlastic(plastic);
        d.setDescription(description);
        d.setWeight(weight);
        d.setSpeed(speed);
        d.setGlide(glide);
        d.setTurn(turn);
        d.setFade(fade);

        marketDiscDao.save(d);
        model.addAttribute("disc", d);

        return "flip/disc-detail";
    }
}