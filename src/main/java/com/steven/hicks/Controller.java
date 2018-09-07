package com.steven.hicks;

import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.searchForms.ArtistSearchForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@SessionAttributes("artistSearchForm")
public class Controller
{
    @RequestMapping(method = RequestMethod.GET)
    public String homePage(@ModelAttribute("artistSearchForm") ArtistSearchForm artistSearchForm)
    {
        return "index";
    }

    @ModelAttribute("artistSearchForm")
    public ArtistSearchForm getArtistSearchForm()
    {
        ArtistSearchForm searchForm = new ArtistSearchForm();
        searchForm.m_artistList = new ArtistList();
        searchForm.m_artistList.setPage(1);
        return searchForm;
    }

}
