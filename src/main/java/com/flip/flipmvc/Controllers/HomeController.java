package com.flip.flipmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

}