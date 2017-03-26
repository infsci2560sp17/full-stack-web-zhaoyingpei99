
package edu.infsci2560.repositories;


import edu.infsci2560.models.FoodDetail;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface FoodDetailRepository extends PagingAndSortingRepository<FoodDetail, Long> {}
