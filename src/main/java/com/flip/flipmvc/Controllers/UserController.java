package com.flip.flipmvc.Controllers;


import com.flip.flipmvc.Models.Data.UserDao;
import com.flip.flipmvc.Models.Forms.LoginForm;
import com.flip.flipmvc.Models.Forms.SignUpForm;
import com.flip.flipmvc.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;
    public static final String userSessionKey = "user_id";
    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }
    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUserId());
    }
    @ModelAttribute("user")
    public User getUserForModel(HttpServletRequest request) {
        return getUserFromSession(request.getSession());
    }






    @RequestMapping(value="home", method = RequestMethod.GET)
    public String processHomePage () {
        return "user/index";
    }

    @RequestMapping(value = "/signUp")
    public String registerForm(Model model) {
        model.addAttribute(new SignUpForm());
        model.addAttribute("title", "Register");
        return "user/signup";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid SignUpForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "user/signup";
        }

        User existingUser = userDao.findByUsername(form.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "user/signup";
        }

        User newUser = new User(form.getUsername(), form.getPassword());
        userDao.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new LoginForm());
        model.addAttribute("title", "Log In");
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "user/login";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            return "user/login";
        }

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "user/login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:user/login";
    }
}