package com.steven.hicks;

import com.steven.hicks.searchForms.ArtistSearchForm;
import com.steven.hicks.searchForms.SearchFormImp;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@SessionAttributes("searchForm")
public class Controller
{
    @RequestMapping(method = RequestMethod.GET)
    public String homePage(@ModelAttribute("artistSearchForm") ArtistSearchForm artistSearchForm)
    {
        return "index";
    }

    @ModelAttribute("searchForm")
    public SearchFormImp getArtistSearchForm()
    {
        SearchFormImp searchForm = new SearchFormImp();
        return searchForm;
    }

}
