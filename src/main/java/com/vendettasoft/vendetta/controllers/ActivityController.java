package com.vendettasoft.vendetta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {

    @RequestMapping(path = "/activity")
    public String showActivityList() {
        return "html/activity";
    }

    @RequestMapping(path = "/")
    public String welcome() {
        return "html/activity";
    }



}
