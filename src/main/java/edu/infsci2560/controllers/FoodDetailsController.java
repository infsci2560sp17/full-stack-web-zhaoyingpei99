package edu.infsci2560.controllers;

import edu.infsci2560.models.Food;
import edu.infsci2560.models.Customer;
import edu.infsci2560.models.FoodtoCustomer;
import edu.infsci2560.models.FoodDetails;
import edu.infsci2560.models.CookingStyle;
import edu.infsci2560.models.publicFoods;
import edu.infsci2560.repositories.FoodRepository;
import edu.infsci2560.repositories.CustomerRepository;
import edu.infsci2560.repositories.FoodtoCustomerRepository;
import edu.infsci2560.repositories.PublicFoodRepository;
import edu.infsci2560.repositories.FoodDetailsRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Iterator;



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
