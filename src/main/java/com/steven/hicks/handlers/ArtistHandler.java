package com.steven.hicks.handlers;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.beans.SetlistList;
import com.steven.hicks.interfaces.IHandler;
import com.steven.hicks.logic.dao.ArtistSearcher;
import com.steven.hicks.logic.dao.SetlistSearcher;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import com.steven.hicks.searchForms.ArtistSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/artist")
@SessionAttributes("artistSearchForm")
public class ArtistHandler implements IHandler
{
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String search(ModelMap model, @ModelAttribute("artistSearchForm") ArtistSearchForm searchForm)
    {
        model.addAttribute("artistList", searchForm.getArtistList());

        return "artistSearchResults";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public RedirectView search(@RequestParam(name = "artistName")String artistName,
                               @ModelAttribute("artistSearchForm") ArtistSearchForm searchForm)
    {
        ArtistQueryBuilder queryBuilder = new ArtistQueryBuilder.Builder()
                .artistName(artistName)
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        ArtistList artistList = searcher.searchAndGet(queryBuilder, searchForm.getPageNumber());
        searchForm.setName(artistName);

        searchForm.setArtistList(artistList);

        return new RedirectView("/artist/list");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String artist(@RequestParam(name = "mbid") String mbid, Model model)
    {
        ArtistSearcher artistSearcher = new ArtistSearcher();
        Artist artist = artistSearcher.get(mbid);
        model.addAttribute("artist", artist);

        SetlistQueryBuilder queryBuilder = new SetlistQueryBuilder.Builder()
                .artistMbid(mbid)
                .build();

        SetlistSearcher setlistSearcher = new SetlistSearcher();
        SetlistList setlistList = setlistSearcher.searchAndGet(queryBuilder, 1);
        model.addAttribute("setlistList", setlistList);

        return "artist";
    }

    @RequestMapping(value = "/changePage")
    public RedirectView changePage(
            @RequestParam(name = "pageNumber")int pageNumber,
            @ModelAttribute("artistSearchForm")ArtistSearchForm artistSearchForm)
    {
        ArtistList artistList = artistSearchForm.getArtistList();
        artistList.setPage(pageNumber);

        return new RedirectView("/artist/search?artistName=" + artistSearchForm.getName());
    }

}
