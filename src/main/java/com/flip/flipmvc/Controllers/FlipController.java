package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.ClubType;
import com.flip.flipmvc.Models.Data.MarketDiscDao;
import com.flip.flipmvc.Models.Data.UserDao;
import com.flip.flipmvc.Models.MarketDisc;
import com.flip.flipmvc.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.flip.flipmvc.Controllers.UserController.userSessionKey;

@Controller
@RequestMapping("flip")
public class FlipController {

    @Autowired
    MarketDiscDao marketDiscDao;

    @Autowired
    UserDao userDao;

    public static final String userSessionKey = "user_id";
    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }
    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }
    @ModelAttribute("user")
    public User getUserForModel(HttpServletRequest request) {
        return getUserFromSession(request.getSession());
    }


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
    public String processAddDiscForm(MarketDisc newDisc, HttpServletRequest request, Model model) {

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
}