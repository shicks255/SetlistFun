package com.steven.hicks.handlers;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.SetlistList;
import com.steven.hicks.interfaces.IHandler;
import com.steven.hicks.logic.dao.ArtistSearcher;
import com.steven.hicks.logic.dao.SetlistSearcher;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import com.steven.hicks.searchForms.ArtistSearchForm;
import com.steven.hicks.searchForms.SetlistSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/artist")
@SessionAttributes(names = {"artistSearchForm", "setlistSearchForm"})
public class ArtistHandler implements IHandler
{
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listResults(ModelMap model,
                              @ModelAttribute("artistSearchForm") ArtistSearchForm artistSearchForm)
    {
        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder()
                .artistName(artistSearchForm.name)
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        artistSearchForm.m_artistList = searcher.searchAndGet(builder, artistSearchForm.m_artistList.getPage());

        model.addAttribute("artistList", artistSearchForm.m_artistList);
        return "artistSearchResults";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public RedirectView search(@RequestParam(name = "artistName")String artistName,
                               @ModelAttribute("artistSearchForm") ArtistSearchForm artistSearchForm)
    {
        artistSearchForm.name = artistName;
        return new RedirectView("/artist/list");
    }

    @RequestMapping(value = "/changePage")
    public RedirectView changePage(
            @RequestParam(name = "pageNumber")int pageNumber,
            @ModelAttribute("artistSearchForm") ArtistSearchForm artistSearchForm)
    {
        artistSearchForm.m_artistList.setPage(pageNumber);
        return new RedirectView("/artist/list");
    }


//   -------------Methods for the actual artist stuff

    @RequestMapping(method = RequestMethod.GET)
    public String artist(ModelMap model,
                         @RequestParam(required = false, name = "mbid")String mbid,
                         @ModelAttribute("setlistSearchForm") SetlistSearchForm setlistSearchForm,
                         @ModelAttribute("artistSearchForm") ArtistSearchForm artistSearchForm)
    {
        if (mbid != null && mbid.length() > 0)
            artistSearchForm.mbid = mbid;

        ArtistSearcher artistSearcher = new ArtistSearcher();
        Artist artist = artistSearcher.get(artistSearchForm.mbid);

        model.addAttribute("artist", artist);

        SetlistQueryBuilder queryBuilder = new SetlistQueryBuilder.Builder()
                .artistMbid(artist.getMbid())
                .build();

        SetlistSearcher setlistSearcher = new SetlistSearcher();
        setlistSearchForm.m_setlistList = setlistSearcher.searchAndGet(queryBuilder, setlistSearchForm.m_setlistList.getPage());

        model.addAttribute("setlistList", setlistSearchForm.m_setlistList);
        return "artistSetlistsResults";
    }

    @RequestMapping(value = "/changeSetlistPage", method = RequestMethod.GET)
    public RedirectView changeSetlistPage(@ModelAttribute("setlistSearchForm") SetlistSearchForm setlistSearchForm,
                                          @RequestParam(name = "pageNumber") int pageNumber)
    {
        setlistSearchForm.m_setlistList.setPage(pageNumber);
        return new RedirectView("/artist");
    }

    @ModelAttribute("setlistSearchForm")
    public SetlistSearchForm getSetlistSearchForm()
    {
        SetlistSearchForm searchForm = new SetlistSearchForm();
        searchForm.m_setlistList = new SetlistList();
        searchForm.m_setlistList.setPage(1);
        return searchForm;
    }
}
