/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.repositories;

import java.util.List;
import edu.infsci2560.models.publicFoods;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PublicFoodRepository extends PagingAndSortingRepository<publicFoods, Long> {

    
    publicFoods findByTitle(String title);
    
    List<publicFoods> findByIfpublic(Integer ifpublic);
}
