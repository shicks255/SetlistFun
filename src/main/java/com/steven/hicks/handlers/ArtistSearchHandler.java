package com.steven.hicks.handlers;

import com.steven.hicks.searchForms.ArtistSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/artist")
public class ArtistSearchHandler
{

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchArtist(@ModelAttribute("artistSearcher")ArtistSearchForm searchForm,
                               BindingResult result, ModelMap model)
    {
        if (result.hasErrors())
        {
            return "searchError";
        }

        model.addAttribute("");

        return "artistSearch";
    }
}
