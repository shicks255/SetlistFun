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
                .artistName(searchForm.getArtistSearchForm().getName())
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        searchForm.getArtistSearchForm().setArtistList(searcher.searchAndGet(builder, searchForm.getArtistSearchForm().getArtistList().getPage()));

        model.addAttribute("searchForm", searchForm);
        return "artistSearchResults";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public RedirectView search(@RequestParam(name = "artistName")String artistName,
                               @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        searchForm.getArtistSearchForm().setName(artistName);
        return new RedirectView("/artist/list");
    }

    @RequestMapping(value = "/changePage")
    public RedirectView changePage(
            @RequestParam(name = "pageNumber")int pageNumber,
            @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        searchForm.getArtistSearchForm().getArtistList().setPage(pageNumber);
        return new RedirectView("/artist/list");
    }


//   -------------Methods for the actual artist stuff

    @RequestMapping(method = RequestMethod.GET)
    public String artist(ModelMap model,
                         @RequestParam(required = false, name = "mbid")String mbid,
                         @ModelAttribute("searchForm") SearchFormImp searchForm)
    {
        if (mbid != null && mbid.length() > 0)
            searchForm.getArtistSearchForm().setMbid(mbid);

        ArtistSearcher artistSearcher = new ArtistSearcher();
        Artist artist = artistSearcher.get(searchForm.getArtistSearchForm().getMbid());

        model.addAttribute("artist", artist);

        SetlistQueryBuilder queryBuilder = new SetlistQueryBuilder.Builder()
                .artistMbid(artist.getMbid())
                .build();

        SetlistSearcher setlistSearcher = new SetlistSearcher();
        searchForm.getSetlistSearchForm().setSetlistList(setlistSearcher.searchAndGet(queryBuilder, searchForm.getSetlistSearchForm().getSetlistList().getPage()));

        model.addAttribute("setlistList", searchForm.getSetlistSearchForm().getSetlistList());
        return "artistSetlistsResults";
    }

    @RequestMapping(value = "/changeSetlistPage", method = RequestMethod.GET)
    public RedirectView changeSetlistPage(@ModelAttribute("searchForm") SearchFormImp searchForm,
                                          @RequestParam(name = "pageNumber") int pageNumber)
    {
        searchForm.getSetlistSearchForm().getSetlistList().setPage(pageNumber);
        return new RedirectView("/artist");
    }

}
