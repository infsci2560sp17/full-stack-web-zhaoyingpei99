package edu.infsci2560.controllers;

import edu.infsci2560.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
    
    @Autowired
    private CustomerRepository customerrepository;    
    
    
    
    @RequestMapping(value = "login/register", method = RequestMethod.POST,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("nickname") String nickname) {

        
        return new ModelAndView("redirect:/home");
    }
    
}