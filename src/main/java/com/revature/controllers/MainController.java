package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@RequestMapping(value="*")
    public ModelAndView getHelp(HttpSession session, ModelMap modelMap) {
        // TODO Add logic
        return new ModelAndView("forward:resources/index.html", modelMap);
    }
	
	
}
