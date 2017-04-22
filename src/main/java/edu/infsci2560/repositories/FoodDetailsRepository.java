package edu.infsci2560.repositories;


import edu.infsci2560.models.FoodDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoodDetailsRepository extends CrudRepository<FoodDetails, Long> {

    List<FoodDetails> findByFoodid(Long customerid);
    
}