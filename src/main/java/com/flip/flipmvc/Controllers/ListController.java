package com.flip.flipmvc.Controllers;

import com.flip.flipmvc.Models.Forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("list")
public class ListController extends AbstractController {


    @RequestMapping(value="list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("searchForm", new SearchForm());
        return "flip/index";
    }
}
