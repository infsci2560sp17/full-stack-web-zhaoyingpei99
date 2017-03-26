package edu.infsci2560.controllers;

import edu.infsci2560.models.Food;
import edu.infsci2560.models.FoodDetail;
import edu.infsci2560.models.CookingStyle;
import edu.infsci2560.models.publicFoods;
import edu.infsci2560.repositories.FoodRepository;
import edu.infsci2560.repositories.PublicFoodRepository;
import edu.infsci2560.repositories.FoodDetailRepository;
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
public class SearchFromLobbyController {
    
    @Autowired
    private FoodRepository repository;
    
    @Autowired
    private PublicFoodRepository publicfoodrepository;
    
    @Autowired
    private FoodDetailRepository fooddetailrepository;
    
    
    
    
    
    
    @RequestMapping(value = "searchfromlobby/addreview", method = RequestMethod.POST,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView createreview(@RequestParam("id") Long id, @RequestParam("review") String review) {
        FoodDetail fd = new FoodDetail();
        fd.setId(id);
        Iterator<String> reviewsit =  fooddetailrepository.findOne(id).getReviews().iterator();
        Iterator<String> recipesit =  fooddetailrepository.findOne(id).getRecipes().iterator();
        while(reviewsit.hasNext()) {
            String temp = reviewsit.next();
            if(!temp.equals("0")) {
                fd.setNewReview(temp);
            }
        }
        while(recipesit.hasNext()) {
            String temp2 = recipesit.next();
            if(!temp2.equals("0")) {
            
                fd.setNewRecipe(temp2);
            }
        }
        fd.setNewReview(review);
        
        fooddetailrepository.save(fd);
        
        
        
        ModelAndView mv1 = new ModelAndView("searchfromlobby");
        mv1.addObject("alert", "Added review Successfully");
        mv1.addObject("food", publicfoodrepository.findOne(id));
        mv1.addObject("foodreviews", fooddetailrepository.findOne(id).getReviews());
        mv1.addObject("foodrecipes", fooddetailrepository.findOne(id).getRecipes());
        return mv1;
    }
    
    @RequestMapping(value = "searchfromlobby/addrecipe", method = RequestMethod.POST,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView createrecipe(@RequestParam("id") Long id, @RequestParam("recipe") String recipe) {
        FoodDetail fd = new FoodDetail();
        fd.setId(id);
        Iterator<String> reviewsit =  fooddetailrepository.findOne(id).getReviews().iterator();
        Iterator<String> recipesit =  fooddetailrepository.findOne(id).getRecipes().iterator();
        while(reviewsit.hasNext()) {
            String temp = reviewsit.next();
            if(!temp.equals("0")) {
                fd.setNewReview(temp);
            }
        }
        while(recipesit.hasNext()) {
            String temp2 = recipesit.next();
            if(!temp2.equals("0")) {
            
                fd.setNewRecipe(temp2);
            }
        }
        fd.setNewRecipe(recipe);
        
        fooddetailrepository.save(fd);
        
        
        
        ModelAndView mv1 = new ModelAndView("searchfromlobby");
        mv1.addObject("alert", "Added recipe Successfully");
        mv1.addObject("food", publicfoodrepository.findOne(id));
        mv1.addObject("foodreviews", fooddetailrepository.findOne(id).getReviews());
        mv1.addObject("foodrecipes", fooddetailrepository.findOne(id).getRecipes());
        return mv1;
    }
    
//    @RequestMapping(value = "searchfromlobby/backtolobby", method = RequestMethod.GET)
//    public ModelAndView backtolobby() {
//        return new ModelAndView("redirect:/lobby");
//    }
//    
//    @RequestMapping(value = "searchfromlobby/backtofood", method = RequestMethod.GET)
//    public ModelAndView backtofood() {
//        return new ModelAndView("redirect:/foods");
//    }
}