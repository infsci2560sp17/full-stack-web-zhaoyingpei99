package edu.infsci2560.controllers;

import edu.infsci2560.models.Food;
import edu.infsci2560.models.Customer;
import edu.infsci2560.models.CookingStyle;
import edu.infsci2560.models.publicFoods;
import edu.infsci2560.repositories.CustomerRepository;
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


@Controller
public class RegisterController {
    
    @Autowired
    private CustomerRepository customerrepository;    
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView show() {
//        Customer customer = new Customer();
//        customer.setUsername(username);
//        customer.setPassword(password);
//        customer.setnickName(nickname);
//        
//        customerrepository.save(new Customer(1L,"123","zypppp","8888"));
        
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