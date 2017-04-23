package edu.infsci2560.controllers;

import edu.infsci2560.models.FoodtoCustomer;
import edu.infsci2560.repositories.FoodtoCustomerRepository;
import edu.infsci2560.repositories.FoodDetailsRepository;
import edu.infsci2560.repositories.PublicFoodRepository;
import edu.infsci2560.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LobbyController {
    
    
    @Autowired
    private PublicFoodRepository publicfoodrepository;
    
    
    @Autowired
    private FoodtoCustomerRepository foodtocustomerrepository;
    
    @Autowired
    private CustomerRepository customerrepository;

    @Autowired
    private FoodDetailsRepository fooddetailsrepository;
    
    
    
    @RequestMapping(value = "lobby", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv1 = new ModelAndView("lobby");
        mv1.addObject("publicfoods", publicfoodrepository.findByIfpublic(1));
        return mv1;
    }
    
    @RequestMapping(value = "lobby/fooddetail", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("foodid") Long id, @RequestParam(value = "alert",required = false) String alert, RedirectAttributes redirectAttrs) {
        
        ModelAndView mv1 = new ModelAndView("fooddetail");

        mv1.addObject("fooddetails", fooddetailsrepository.findByFoodid(id));
        mv1.addObject("id", id);
        
        return mv1;
    }
    
    @RequestMapping(value = "lobby/add", method = RequestMethod.POST)
    public ModelAndView addPersonal(@RequestParam("foodid") Long id, @RequestParam(value = "alert",required = false) String alert, RedirectAttributes redirectAttrs, HttpServletRequest request) {
        
        String username = request.getRemoteUser();
        Long userid = customerrepository.findByUsername(username).getId();
        
        
        FoodtoCustomer ftc = new FoodtoCustomer();
        ftc.setFoodId(id);
        ftc.setCustomerId(userid);
        foodtocustomerrepository.save(ftc);
        
      
        
        return new ModelAndView("redirect:/foods");
    }

}