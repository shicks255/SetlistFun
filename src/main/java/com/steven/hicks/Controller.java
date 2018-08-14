package com.steven.hicks;

import com.steven.hicks.searchForms.ArtistSearchForm;
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
        ArtistSearchForm artistSearcher = new ArtistSearchForm();
        model.addAttribute("artistSearcher", artistSearcher);

        return "index";
    }

}
