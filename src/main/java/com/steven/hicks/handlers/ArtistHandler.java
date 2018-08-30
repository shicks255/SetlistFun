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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artist")
public class ArtistHandler implements IHandler
{
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@ModelAttribute("artistSearcher") ArtistSearchForm searchForm,
                               BindingResult result, ModelMap model, @RequestParam(name = "pageNumber") int pageNumber)
    {
        //:todo make search error page
        if (result.hasErrors())
            return "searchError";

        ArtistQueryBuilder queryBuilder = new ArtistQueryBuilder.Builder()
                .artistName(searchForm.getName())
                .mbId(searchForm.getMbId())
                .tmId(searchForm.getTmId())
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        ArtistList artistList = searcher.searchAndGet(queryBuilder, 1);

        model.addAttribute("artistList", artistList);

        return "artistSearchResults";
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
}
