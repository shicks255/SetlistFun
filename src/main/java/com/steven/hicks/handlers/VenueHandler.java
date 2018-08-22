package com.steven.hicks.handlers;

import com.steven.hicks.beans.Venue;
import com.steven.hicks.logic.dao.VenueDAO;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;
import com.steven.hicks.searchForms.VenueSearchForm;
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
@RequestMapping("/venue")
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

        List<Venue> venueList = VenueDAO.search(builder);

        model.addAttribute("venueList", venueList);


        return "venueSearchResults";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String venue(@RequestParam("id") String id, Model model)
    {
        Venue venue = VenueDAO.getVenue(id);

        model.addAttribute("venue", venue);

        return "venue";
    }

}
