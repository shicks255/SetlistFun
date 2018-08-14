package com.steven.hicks.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/setlist")
public class SetlistHandler
{
    @RequestMapping(value = "/search")
    public String searchSetlist(@RequestParam(name = "setlistId")String setlistId, Model model)
    {

        return "";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setlist(@RequestParam(name = "id") String setlistId)
    {

        return "";
    }

}
