package com.alex.repo.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alex.repo.models.User;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String testEndPoint(ModelMap modelMap) {
        modelMap.addAttribute("message","Spring MVC");
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void testEndPost(ModelMap modelMap, String username){
        User user = new User();
    }
}
