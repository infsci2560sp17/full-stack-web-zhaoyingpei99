package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;





@Entity
@Table(name = "customer_food")
public class FoodtoCustomer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    
    private Long foodid;
    
    
    private Long customerid;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        FoodtoCustomer other = (FoodtoCustomer) obj;
        if ( !Objects.equals(other.foodid, foodid) )
            return false;

        return Objects.equals(other.getCustomerId(), getCustomerId());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getFoodId());
        hash = 29 * hash + Objects.hashCode(this.getCustomerId());
        return hash;
    }

    /**
     * @return the foodId
     */
    public Long getFoodId() {
        return foodid;
    }

    /**
     * @param foodId the foodId to set
     */
    public void setFoodId(Long foodId) {
        this.foodid = foodId;
    }

    /**
     * @return the customerId
     */
    public Long getCustomerId() {
        return customerid;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Long customerId) {
        this.customerid = customerId;
    }

    
}
