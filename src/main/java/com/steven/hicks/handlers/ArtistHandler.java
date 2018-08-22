package com.steven.hicks.handlers;

import com.steven.hicks.beans.Artist;
import com.steven.hicks.beans.Setlist;
import com.steven.hicks.logic.dao.ArtistDAO;
import com.steven.hicks.logic.dao.SetlistDAO;
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

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistHandler
{
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@ModelAttribute("artistSearcher")ArtistSearchForm searchForm,
                               BindingResult result, ModelMap model)
    {
        //:todo make search error page
        if (result.hasErrors())
            return "searchError";

        ArtistQueryBuilder queryBuilder = new ArtistQueryBuilder.Builder()
                .artistName(searchForm.getName())
                .mbId(searchForm.getMbId())
                .tmId(searchForm.getTmId())
                .build();

        List<Artist> artistList = ArtistDAO.search(queryBuilder);


        model.addAttribute("artistList", artistList);

        return "artistSearchResults";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String artist(@RequestParam(name = "mbid") String mbid, Model model)
    {
        Artist artist = ArtistDAO.getArtist(mbid);
        model.addAttribute("artist", artist);

        SetlistQueryBuilder queryBuilder = new SetlistQueryBuilder.Builder().artistMbid(mbid).build();
        List<Setlist> setlists = SetlistDAO.search(queryBuilder);
        model.addAttribute("setlists", setlists);

        return "artist";
    }
}
