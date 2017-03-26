package edu.infsci2560.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.ArrayList;

@Entity
public class FoodDetail {
    
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    protected Long foodid;
    protected ArrayList<String> recipes;
    protected ArrayList<String> reviews;

    public FoodDetail() {
        this.foodid = Long.MAX_VALUE;
        this.recipes = new ArrayList<String>();
        this.reviews = new ArrayList<String>();
    }

    public FoodDetail(Long foodid, String recipe, String review) {
        this.foodid = foodid;
        this.recipes = new ArrayList<String>();
        this.reviews = new ArrayList<String>();
        recipes.add(recipe);
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "[ foodid=" + this.foodid + ", recipes=" + this.recipes.toString() + ", reviews =" + this.reviews.toString() + " ]";
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * @return the name
     */
    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * @param title the name to set
     */
    public void setNewReview(String review) {
        reviews.add(review);
    }

    /**
     * @return the workoutType
     */
    public ArrayList<String> getRecipes() {
        return recipes;
    }

    /**
     * @param workoutType the workoutType to set
     */
    public void setNewRecipe(String recipe) {
        recipes.add(recipe);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return foodid;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.foodid = id;
    }

}

