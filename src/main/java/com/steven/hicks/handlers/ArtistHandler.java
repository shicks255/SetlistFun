package com.steven.hicks.handlers;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.interfaces.IHandler;
import com.steven.hicks.logic.dao.ArtistSearcher;
import com.steven.hicks.logic.dao.SetlistSearcher;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import com.steven.hicks.searchForms.SearchFormImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/artist")
@SessionAttributes(names = "searchForm")
public class ArtistHandler implements IHandler
{
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listResults(ModelMap model,
                              @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        ArtistQueryBuilder builder = new ArtistQueryBuilder.Builder()
                .artistName(searchForm.m_artistSearchForm.name)
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        searchForm.m_artistSearchForm.m_artistList = searcher.searchAndGet(builder, searchForm.m_artistSearchForm.m_artistList.getPage());

        model.addAttribute("artistList", searchForm.m_artistSearchForm.m_artistList);
        return "artistSearchResults";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public RedirectView search(@RequestParam(name = "artistName")String artistName,
                               @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        searchForm.m_artistSearchForm.name = artistName;
        return new RedirectView("/artist/list");
    }

    @RequestMapping(value = "/changePage")
    public RedirectView changePage(
            @RequestParam(name = "pageNumber")int pageNumber,
            @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        searchForm.m_artistSearchForm.m_artistList.setPage(pageNumber);
        return new RedirectView("/artist/list");
    }


//   -------------Methods for the actual artist stuff

    @RequestMapping(method = RequestMethod.GET)
    public String artist(ModelMap model,
                         @RequestParam(required = false, name = "mbid")String mbid,
                         @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        if (mbid != null && mbid.length() > 0)
            searchForm.m_artistSearchForm.mbid = mbid;

        ArtistSearcher artistSearcher = new ArtistSearcher();
        Artist artist = artistSearcher.get(searchForm.m_artistSearchForm.mbid);

        model.addAttribute("artist", artist);

        SetlistQueryBuilder queryBuilder = new SetlistQueryBuilder.Builder()
                .artistMbid(artist.getMbid())
                .build();

        SetlistSearcher setlistSearcher = new SetlistSearcher();
        searchForm.m_setlistSearchForm.m_setlistList = setlistSearcher.searchAndGet(queryBuilder, searchForm.m_setlistSearchForm.m_setlistList.getPage());

        model.addAttribute("setlistList", searchForm.m_setlistSearchForm.m_setlistList);
        return "artistSetlistsResults";
    }

    @RequestMapping(value = "/changeSetlistPage", method = RequestMethod.GET)
    public RedirectView changeSetlistPage(@ModelAttribute("searchForm") SearchFormImp searchForm,
                                          @RequestParam(name = "pageNumber") int pageNumber)
    {
        searchForm.m_setlistSearchForm.m_setlistList.setPage(pageNumber);
        return new RedirectView("/artist");
    }

}
