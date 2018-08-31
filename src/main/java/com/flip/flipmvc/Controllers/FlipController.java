package com.flip.flipmvc.Controllers;
import com.flip.flipmvc.Models.*;
import com.flip.flipmvc.Models.Forms.SearchForm;
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

    @RequestMapping(value = "disc")
    public String displaySingleDisc(Model model, @RequestParam int id) {
        model.addAttribute("searchForm", new SearchForm());
        MarketDisc singleDisc = marketDiscDao.findOne(id);
        model.addAttribute("disc",singleDisc);
        model.addAttribute("title","Disc Detail");
        return "flip/disc-detail";
    }



    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddDiscForm(Model model) {

        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("title","Add Disc");
        model.addAttribute("disc", new MarketDisc());
        model.addAttribute("clubTypes", ClubType.values());
        model.addAttribute("speeds",Speed.values());
        model.addAttribute("glides",Glide.values());
        model.addAttribute("turns",Turn.values());
        model.addAttribute("fades",Fade.values());
        return "flip/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddDiscForm(@ModelAttribute("disc") @Valid MarketDisc newDisc, Errors errors,
                                     HttpServletRequest request, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("title", "Add Disc");
            model.addAttribute("disc",newDisc);
            model.addAttribute("clubTypes", ClubType.values());
            model.addAttribute("speeds", Speed.values());
            model.addAttribute("glides",Glide.values());
            model.addAttribute("turns",Turn.values());
            model.addAttribute("fades",Fade.values());
            return "flip/add";
        }
        Integer userId = (Integer) request.getSession().getAttribute(userSessionKey);
        User user = userDao.findOne(userId);
        newDisc.setUser(user);
        marketDiscDao.save(newDisc);
        return "redirect:/user/home";
    }



    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int id){
        model.addAttribute("searchForm", new SearchForm());

        MarketDisc d = marketDiscDao.findOne(id);
        model.addAttribute("title","Edit Disc");
        model.addAttribute("disc", d);
        model.addAttribute("clubTypes",ClubType.values());
        model.addAttribute("speeds", Speed.values());
        model.addAttribute("glides",Glide.values());
        model.addAttribute("turns",Turn.values());
        model.addAttribute("fades",Fade.values());
        return "flip/edit-disc";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute("disc") @Valid MarketDisc editedDisc, @PathVariable int id,
                                  Errors errors, Model model, String name, String brand,
                                  ClubType clubType, String color, String plastic, String description, int weight,
                                  Speed speed, Glide glide, Turn turn, Fade fade){
        if(errors.hasErrors()){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("title", "Edit Disc");
            model.addAttribute("clubTypes",ClubType.values());
            model.addAttribute("speeds", Speed.values());
            model.addAttribute("glides",Glide.values());
            model.addAttribute("turns",Turn.values());
            model.addAttribute("fades",Fade.values());
            model.addAttribute("disc", editedDisc);
            model.addAttribute("id", id);
            return "flip/edit-disc";
        }
        MarketDisc d = marketDiscDao.findOne(id);
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
        return "redirect:/flip/disc?id="+d.getId();
    }
}