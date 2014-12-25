package com.jaiwo99.mailagent.userwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jaiwo99
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home() {
        return "redirect:/msg/";
    }
}
