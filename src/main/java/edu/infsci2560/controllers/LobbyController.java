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


@Controller
public class LobbyController {
    
    @Autowired
    private FoodRepository repository;
    
    @Autowired
    private PublicFoodRepository publicfoodrepository;
    
    @Autowired
    private FoodDetailRepository fooddetailrepository;
    
    
    
    
    
    
    @RequestMapping(value = "lobby", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv1 = new ModelAndView("lobby");
        mv1.addObject("publicfoods", publicfoodrepository.findByIfpublic(1));
        return mv1;
    }
    
    @RequestMapping(value = "lobby/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("foodid") Long id, @RequestParam(value = "alert",required = false) String alert, RedirectAttributes redirectAttrs) {
        
        ModelAndView mv1 = new ModelAndView("searchfromlobby");
        if (alert == null) {
            alert = "Here it is!";
        }

        mv1.addObject("alert", alert);
        mv1.addObject("food", publicfoodrepository.findOne(id));
        mv1.addObject("foodreviews", fooddetailrepository.findOne(id).getReviews());
        mv1.addObject("foodrecipes", fooddetailrepository.findOne(id).getRecipes());
        
        return mv1;
    }

}