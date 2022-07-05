package com.alex.repo.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String testEndPoint(ModelMap modelMap) {
        modelMap.addAttribute("message","Spring MVC");
        return "Hello World";
    }
}
