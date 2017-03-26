package edu.infsci2560;

import edu.infsci2560.models.FoodDetail;
import edu.infsci2560.models.publicFoods;
import edu.infsci2560.models.CookingStyle;
import edu.infsci2560.repositories.FoodDetailRepository;
import edu.infsci2560.repositories.PublicFoodRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FullStackWebApplication {

    private static final Logger log = LoggerFactory.getLogger(FullStackWebApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FullStackWebApplication.class, args);
        
        PublicFoodRepository publicrepository = ctx.getBean(PublicFoodRepository.class);
        FoodDetailRepository fooddetailrepository = ctx.getBean(FoodDetailRepository.class);
        
        publicrepository.save(new publicFoods(1L, "General Tso's chicken", CookingStyle.Chinese));
        publicrepository.save(new publicFoods(2L, "Tako", CookingStyle.Mexican));
        publicrepository.save(new publicFoods(3L, "Onion soup", CookingStyle.French));
        publicrepository.save(new publicFoods(4L, "Ramen", CookingStyle.Japanese));
        publicrepository.save(new publicFoods(5L, "CheeseBurger", CookingStyle.American));   
        publicrepository.save(new publicFoods(6L, "Hawaii Pizza", CookingStyle.Italian));        
        
        
        
        
        FoodDetail fd4 = new FoodDetail(4L, "boil water and do anything you want!"," love this!!");
        
        fooddetailrepository.save(new FoodDetail(1L, "start with chicken with the kind of crisp, craggy, deep-fried coating that Colonel Sanders himself would be proud of (what is it with military men and fried chicken anyway?), then toss it in a sweet and punchy sauce flavored with garlic, ginger, scallions, and dried chilies. Throw it all on a plate with some steamed white rice and you've got one of America's most popular dishes."," Awesome!!!!!"));        
        fooddetailrepository.save(new FoodDetail(2L, "i just make some tacos wth ground beef and than i add some onins wth the ground beef its tast good and 2/3 cup water shredded lettuce diced tomatoes tacos shells and if you want to add jalapenos is good and spicy to"," Surprisingly tasty even with so few ingredients. Quick and easy!"));        
        fooddetailrepository.save(new FoodDetail(3L, "Your soup will only be as good as the stock you are using. This soup traditionally is made with beef stock, though sometimes a good beef stock can be hard to come by and expensive to make."," Not so good!"));            
        fooddetailrepository.save(fd4);        
        fooddetailrepository.save(new FoodDetail(5L, "Heat the olive oil in a large skillet over medium heat. Cook the burgers, turning occasionally, to desired temperature, 15 to 20 minutes for well done. Top each patty with a slice of Swiss cheese shortly before removing from the skillet; serve on hamburger buns."," Tasty!"));        
        fooddetailrepository.save(new FoodDetail(6L, "Hawaiian pizza is made up of a dough crust, tomato sauce, ham pieces, and pineapple rings or chunks. Often versions will have mixed peppers, mushrooms and bacon."," Disgusting"));        
        
//        fooddetailrepository.save(new FoodDetail(4L, "boil water and do anything you want!"," love this!!"));        
    
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
//    @Bean
//    public CommandLineRunner databaseDemo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//            repository.save(new Customer("Billy", "Bean"));
//
//            // fetch all customers
//            log.info("[Database Demo] Customers found with findAll():");
//            log.info("[Database Demo] -------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info("[Database Demo] " + customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("[Database Demo] Customer found with findOne(1L):");
//            log.info("[Database Demo] --------------------------------");
//            log.info("[Database Demo] " + customer.toString());
//
//            // fetch customers by last name
//            log.info("[Database Demo] Customer found with findByLastName('Bauer'):");
//            log.info("[Database Demo] --------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info("[Database Demo] " + bauer.toString());
//            }
//        };
//    }
}
