/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 *
 */
@Entity
public class publicFoods {

    private static final long serialVersionUID = 1L;

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long publicid;
    protected String title;
    protected CookingStyle cookingStyle;
    private Integer ifpublic;

    public publicFoods() {
        this.publicid = Long.MAX_VALUE;
        this.title = null;
        this.cookingStyle = CookingStyle.Others;
        this.ifpublic = 0;
    }

    public publicFoods(Long id, String name, CookingStyle cookingStyle, Integer ifpublic) {
        this.publicid = id;
        this.title = name;
        this.cookingStyle = cookingStyle;
        this.ifpublic = ifpublic;
    }

    @Override
    public String toString() {
        return "[ id=" + this.publicid + ", public=" +this.ifpublic + ", title="+  this.title + ", cookingStyle=" + this.cookingStyle + " ]";
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
    public String getTitle() {
        return title;
    }

    /**
     * @param title the name to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the workoutType
     */
    public CookingStyle getCookingStyle() {
        return cookingStyle;
    }

    /**
     * @param workoutType the workoutType to set
     */
    public void setCookingStyle(CookingStyle cookingStyle) {
        this.cookingStyle = cookingStyle;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return publicid;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.publicid = id;
    }
    
    public int getIfpublic() {
        return ifpublic;
    }
    
    public void setIfpublic(int ifpublic) {
        this.ifpublic = ifpublic;
    }
    
//    

}
