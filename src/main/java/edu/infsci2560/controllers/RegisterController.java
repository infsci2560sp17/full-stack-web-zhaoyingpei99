package edu.infsci2560.controllers;

import edu.infsci2560.models.Customer;
import edu.infsci2560.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {
    
    @Autowired
    private CustomerRepository customerrepository;    
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView show() {

        return new ModelAndView("register");
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("nickname") String nickname) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setnickName(nickname);
        
        customerrepository.save(customer);
        
        return new ModelAndView("redirect:/home");
    }
    
}