package edu.infsci2560.controllers;

import edu.infsci2560.models.FoodDetails;
import edu.infsci2560.repositories.CustomerRepository;
import edu.infsci2560.repositories.FoodtoCustomerRepository;
import edu.infsci2560.repositories.PublicFoodRepository;
import edu.infsci2560.repositories.FoodDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;




@Controller
public class FoodDetailsController {
    
    @Autowired
    private FoodtoCustomerRepository foodtocustomerrepository;
    
    @Autowired
    private PublicFoodRepository publicfoodrepository;
    
    @Autowired
    private FoodDetailsRepository fooddetailsrepository;
    
    @Autowired
    private CustomerRepository customerrepository;
    
    
    
    
    @RequestMapping(value = "fooddetail/add", method = RequestMethod.POST,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView add(@RequestParam("id") Long id, @RequestParam("star") Integer star, @RequestParam("review") String review, @RequestParam("receipe") String receipe, HttpServletRequest request) {
        
        String username = request.getRemoteUser();
        String usernickname = customerrepository.findByUsername(username).getnickName();
        
        FoodDetails fd = new FoodDetails();
        fd.setFoodId(id);
        fd.setCustomer(usernickname);
        fd.setReviews(review);
        fd.setReceipes(receipe);
        fd.setStars(star);
        fooddetailsrepository.save(fd);
        ModelAndView mv1 = new ModelAndView("fooddetail");
        mv1.addObject("fooddetails", fooddetailsrepository.findByFoodid(id));
        mv1.addObject("id", id);
        return mv1;
        
    }
    
}
