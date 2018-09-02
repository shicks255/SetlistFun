package com.steven.hicks.handlers;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.beans.SetlistList;
import com.steven.hicks.interfaces.IHandler;
import com.steven.hicks.logic.dao.ArtistSearcher;
import com.steven.hicks.logic.dao.SetlistSearcher;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artist")
public class ArtistHandler implements IHandler
{
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(ModelMap model,
                         @RequestParam(name = "artistName")String artistName,
                         @RequestParam(name = "pageNumber", required = false) Integer pageNumber)
    {
        if (pageNumber == null)
            pageNumber = 1;

        ArtistQueryBuilder queryBuilder = new ArtistQueryBuilder.Builder()
                .artistName(artistName)
                .build();

        ArtistSearcher searcher = new ArtistSearcher();
        ArtistList artistList = searcher.searchAndGet(queryBuilder, pageNumber);

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
