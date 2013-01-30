/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webShop.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import webShop.model.Customer;
import webShop.model.CustomerDTO;
import webShop.model.Gnome;
import webShop.model.GnomeDTO;

/**
 *
 * @author prakash
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class WebShopFacade {
    
    @PersistenceContext(unitName = "webshopPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    /**
     * Create a new customer.
     * @param pseudo pseudo of the new customer
     * @param password password of the new customer
     * @return the new customer
     */
    
    public CustomerDTO createCustomerDTO(String pseudo, String password) {
        CustomerDTO customer = new Customer(pseudo, password);
         System.out.println(customer.getId());
        em.persist(customer);
        return customer;
    }
    
    /**
     * Log in a customer
     * @param pseudo customer's pseudo
     */
    public void loginCustomer(String pseudo){
        CustomerDTO customer = em.find(Customer.class, pseudo);
        System.out.println("loginfacedecustomer");
        System.out.println(customer.getId());
        customer.setIsLog(true);
        em.merge(customer);
        System.out.println("aftercommit");
    }
    
   /**
     * LogOut in a customer
     * @param pseudo customer's pseudo
     */ 
    public void logoutCustomer(String pseudo){
        CustomerDTO customer = em.find(Customer.class, pseudo);
        customer.setIsLog(false);
        em.merge(customer);
    }
    
    /**
     * Get the customer wich calls 'pseudo'
     * @param pseudo the customer's pseudo
     * @return the customer or null if the customer doesn't exist
     */
    public CustomerDTO getCustomer(String pseudo){
        CustomerDTO customer = em.find(Customer.class, pseudo);
        if (customer == null) {
            return null;
        }
        return customer;
    }
    
     /**
     * Ban a customer
     * @param pseudo the customer's pseudo
     * @return if the customer has been found
     */
    public Boolean ban(String pseudo){
        CustomerDTO customer = em.find(Customer.class, pseudo);
        if (customer == null) {
            return false;
        } else {
            customer.setIsbanned(true);
            em.merge(customer);
            return true;            
        }
    }
    
    /**
     * getInventory
     * @return List of Gnome
     */  
 public List<GnomeDTO> getAllGnomes() {
       Query query = em.createQuery("SELECT g FROM Gnome g ORDER BY g.type", Gnome.class);
        List<GnomeDTO> gnomes = (List<GnomeDTO>) query.getResultList();
        return gnomes;
         
    }
     
     public void updateGnome(String gnomeType,int updateAmount) {
        GnomeDTO gnome = em.find(Gnome.class,gnomeType);
        gnome.setAmount(updateAmount);
        em.merge(gnome);
    }
     
    /**
     * Add gnomes in the inventory
     * @param type the gnomes' type
     * @param price the amount of the gnomes
     * @param amount the amount of the gnomes
     */  
   public void createGnome(String Type, int price, int amount) {
         Gnome newGnome = new Gnome(Type, price, amount);
         em.persist(newGnome);
       }
    
    /**
     * delete gnomes in the inventory
     * @param gnomeType the gnomes' type
     */  
    public void deleteGnome(String gnomeType) {
        GnomeDTO gnome = em.find(Gnome.class, gnomeType);
        em.remove(gnome);
    }
    
    /**
     * update gnomes in the inventory
     * @param Type the gnomes' type
     * @param price the gnomes' price
     * @param amount the gnomes' amount
     */  
     public void updateGnomeAdmin(String Type, int price, int amount) {
           GnomeDTO gnome = em.find(Gnome.class, Type);
           gnome.setPrice(price);
           gnome.setAmount(amount);
           em.merge(gnome);
    }    
    
    

}
