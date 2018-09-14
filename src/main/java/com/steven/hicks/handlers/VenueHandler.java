package com.steven.hicks.handlers;

import com.steven.hicks.beans.Venue;
import com.steven.hicks.beans.VenueList;
import com.steven.hicks.logic.dao.SetlistSearcher;
import com.steven.hicks.logic.dao.VenueSearcher;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;
import com.steven.hicks.searchForms.SearchFormImp;
import com.steven.hicks.searchForms.VenueSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/venue")
@SessionAttributes(names = "searchForm")
public class VenueHandler
{
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@ModelAttribute("venueSearcher") VenueSearchForm searchForm,
                         BindingResult result, ModelMap model)
    {
        if (result.hasErrors())
        {
            //:todo error handling logic going here
        }

        VenueQueryBuilder builder = new VenueQueryBuilder.Builder()
                .cityId(searchForm.getCity().getId())
                .cityName(searchForm.getCity().getName())
                .countryName(searchForm.getCity().getCountry().getName())
                .state(searchForm.getCity().getState())
                .name(searchForm.getName())
                .build();

        VenueSearcher searcher = new VenueSearcher();
        VenueList venueLists = searcher.searchAndGet(builder, 1);

        model.addAttribute("venueList", venueLists);

        return "venueSearchResults";
    }

//    ---------Methods for the actual Venue stuff

    @RequestMapping(method = RequestMethod.GET)
    public String venue(@RequestParam("id") String id,
                        @ModelAttribute(name = "searchForm") SearchFormImp searchForm,
                        Model model)
    {
        VenueSearcher venueSearcher = new VenueSearcher();
        Venue venue = venueSearcher.get(id);
        model.addAttribute("venue", venue);

        SetlistQueryBuilder queryBuilder = new SetlistQueryBuilder.Builder()
                .venueId(venue.getId())
                .build();

        SetlistSearcher setlistSearcher = new SetlistSearcher();
        searchForm.getSetlistSearchForm().setSetlistList(setlistSearcher.searchAndGet(queryBuilder, searchForm.getSetlistSearchForm().getSetlistList().getPage()));

        model.addAttribute("venue", venue);
        return "venue";
    }

    @RequestMapping(value = "/changeVenueSetlistPage", method = RequestMethod.GET)
    public RedirectView changeVenueSetlistPage(@ModelAttribute("searchForm") SearchFormImp searchForm,
                                               @RequestParam(name = "pageNumber") int pageNumber)
    {
        searchForm.getSetlistSearchForm().getSetlistList().setPage(pageNumber);
        return new RedirectView("/venue");
    }

}
