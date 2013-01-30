/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webShop.model;

/**
 *
 * @author prakash
 */
public interface GnomeDTO {
      
    public String getType();

    public Integer getPrice();
    
    public Integer getAmount();
    
   // public Boolean getIsAvailable();

   // public void setIsAvailable(Boolean isAvailable);

    /**
     * set the price of the current kind of gnome
     * @param price 
     */
    public void setPrice(Integer price);
    
    /**
     * set the type of the gnome
     * @param type 
     */
     public void setType(String type);
     
     /**
      * set the amount of gnome in the shop
      * @param amount 
      */
    public void setAmount(Integer amount);
}
