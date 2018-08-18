package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.ClubType;
import com.flip.flipmvc.Models.Data.MarketDiscDao;
import com.flip.flipmvc.Models.Data.UserDao;
import com.flip.flipmvc.Models.MarketDisc;
import com.flip.flipmvc.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.flip.flipmvc.Controllers.UserController.userSessionKey;

@Controller
@RequestMapping("flip")
public class FlipController extends AbstractController {


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("discs", marketDiscDao.findAll());
        model.addAttribute("title", "All Discs");
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
    public String processAddDiscForm(@ModelAttribute @Valid MarketDisc newDisc, Errors errors, HttpServletRequest request, Model model) {

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

        MarketDisc singleDisc = marketDiscDao.findOne(id);
        model.addAttribute("disc",singleDisc);
        model.addAttribute("title","Disc Detail");
        return "flip/disc-detail";
    }

    @RequestMapping(value = "edit/{marketDiscId}", method = RequestMethod.GET)
    public String displayEditForm(@Valid Model model, @PathVariable int marketDiscId){
        MarketDisc d = marketDiscDao.findOne(marketDiscId);
        model.addAttribute("disc", d);
        model.addAttribute("clubTypes",ClubType.values());
        return "flip/edit-disc";
    }


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(Model model, int marketDiscId, String name, String brand, ClubType clubType, String color,
                              String plastic, String description, int weight, int speed, int glide, int turn, int fade){

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