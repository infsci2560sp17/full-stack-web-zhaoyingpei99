
package edu.infsci2560.controllers;


import java.util.List;
import java.util.ArrayList;
import edu.infsci2560.models.Food;
import edu.infsci2560.models.FoodtoCustomer;
import edu.infsci2560.models.FoodDetail;
import edu.infsci2560.models.CookingStyle;
import edu.infsci2560.models.publicFoods;
import edu.infsci2560.repositories. CustomerRepository;
import edu.infsci2560.repositories.FoodRepository;
import edu.infsci2560.repositories.FoodtoCustomerRepository;
import edu.infsci2560.repositories.FoodDetailRepository;
import edu.infsci2560.repositories.PublicFoodRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FoodsController {
    
    @Autowired
    private FoodRepository repository;
    
    @Autowired
    private PublicFoodRepository publicfoodrepository;
    
    @Autowired
    private FoodDetailRepository fooddetailrepository;
    
    @Autowired
    private FoodtoCustomerRepository foodtocustomerrepository;
    
    @Autowired
    private CustomerRepository customerrepository;

    
    @RequestMapping(value = "foods", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv1 = new ModelAndView("foods");
        
        String username = request.getRemoteUser();
        Long userid = customerrepository.findByUsername(username).getId();
        
        List<FoodtoCustomer> l1 = foodtocustomerrepository.findByCustomerid(userid);
        List<publicFoods> result = new ArrayList<publicFoods>();
        for(FoodtoCustomer ctf : l1) {
            result.add(publicfoodrepository.findOne(ctf.getFoodId()));
        }
        
        
        mv1.addObject("foods", result);
        return mv1;
    }

    
    @RequestMapping(value = "foods/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView createPersonal(@ModelAttribute @Valid Food food, BindingResult result, HttpServletRequest request) {
        
        
        publicFoods foodtoadd = new publicFoods();
        foodtoadd.setTitle(food.getTitle());
        foodtoadd.setCookingStyle(food.getCookingStyle());
        publicfoodrepository.save(foodtoadd);
        
        Long ctfid = publicfoodrepository.findByTitle(food.getTitle()).getId();
        
        String username = request.getRemoteUser();
        Long userid = customerrepository.findByUsername(username).getId();
        
        FoodtoCustomer ftc = new FoodtoCustomer();
        ftc.setFoodId(ctfid);
        ftc.setCustomerId(userid);
        foodtocustomerrepository.save(ftc);
        

        return new ModelAndView("redirect:/foods");
    }
    
    
    @RequestMapping(value = "foods", method = RequestMethod.DELETE, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView deletePersonal(@RequestParam("id") Long id, HttpServletRequest request) {
        
        if (publicfoodrepository.findOne(id).getIfpublic() == 0) {
            publicfoodrepository.delete(id);
        }
        String username = request.getRemoteUser();
        Long userid = customerrepository.findByUsername(username).getId();
        
        Long ftcid = foodtocustomerrepository.findByCustomeridAndFoodid(userid, id).getId();
        foodtocustomerrepository.delete(ftcid);
 
        return new ModelAndView("redirect:/foods");

    }
    
    @RequestMapping(value = "foods", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView updatePersonal(@RequestParam("id") Long id,@RequestParam("cookingStyle") CookingStyle cookingstyle) {
        publicFoods food = publicfoodrepository.findOne(id);
        publicfoodrepository.save(new publicFoods(id, food.getTitle(), cookingstyle, food.getIfpublic()));

        return new ModelAndView("redirect:/foods");
    }
    
    
    @RequestMapping(value = "foods/addtopublic", method = RequestMethod.PUT, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView publicCreate(@RequestParam("id") Long id) {
        publicFoods food = publicfoodrepository.findOne(id);
        publicfoodrepository.save(new publicFoods(id, food.getTitle(), food.getCookingStyle(), 1));
        String alert = "";
            
            

        return new ModelAndView("redirect:/lobby");
        
    }
  
}
