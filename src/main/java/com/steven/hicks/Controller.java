package com.steven.hicks;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller
{

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(Model model)
    {
        ArtistQuerySearcher artistSeacher = new ArtistQuerySearcher();
        model.addAttribute("artistSearcher", artistSeacher);


        return "index";
    }

}
