package edu.infsci2560.repositories;

import edu.infsci2560.models.FoodtoCustomer;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodtoCustomerRepository extends CrudRepository<FoodtoCustomer, Long> {

    List<FoodtoCustomer> findByCustomerid(Long customerid);
    
    FoodtoCustomer findByCustomeridAndFoodid(Long customerid, Long foodid);
}