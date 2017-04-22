package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodDetails {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private Long foodid;
    
    private String customer;
    
    private int stars;
    
    private String reviews;
    
    private String receipes;
    
    public FoodDetails() {
        
    }
    
    public FoodDetails( Long id, Long foodid, String customer, int stars, String reviews, String receipes) {
        this.id = id;
        this.foodid = foodid;
        this.customer = customer;
        this.stars = stars;
        this.reviews = reviews;
        this.receipes = receipes;
    }

    /**
     * @return the fooddetailspk
     */
    public Long getId() {
        return id;
    }

    /**
     * @param fooddetailspk the fooddetailspk to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
    
    
    
    
        /**
     * @return the receipes
     */
    public String getReceipes() {
        return receipes;
    }

    /**
     * @param receipes the receipes to set
     */
    public void setReceipes(String receipes) {
        this.receipes = receipes;
    }
    
        /**
     * @return the stars
     */
    public int getStars() {
        return stars;
    }

    /**
     * @param stars the stars to set
     */
    public void setStars(int stars) {
        this.stars = stars;
    }
    
    public Long getFoodId() {
        return foodid;
    }

    /**
     * @param fooddetailspk the fooddetailspk to set
     */
    public void setFoodId(Long foodid) {
        this.foodid = foodid;
    }
    
    
    public String getCustomer() {
        return customer;
    }

    /**
     * @param fooddetailspk the fooddetailspk to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
