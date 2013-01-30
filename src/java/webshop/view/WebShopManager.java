/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webShop.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import webShop.controller.WebShopFacade;
import webShop.model.CartObject;
import webShop.model.CustomerDTO;
import webShop.model.Gnome;
import webShop.model.GnomeDTO;

/**
 *
 * @author Prakash
 */
@Named(value = "webShopManager")
@ConversationScoped
public class WebShopManager implements Serializable { 
    @EJB
    private WebShopFacade webShopFacade;
    private String currentPseudo;
    private String currentPassword;
    private String message;
    private String error = null;
    //private Boolean homePage = false;
    private Exception transactionFailure;
    private boolean loginSuccessfullyUser;
    private boolean loginSuccessfullyAdmin;
    private List<GnomeDTO> gnomes;
   private List<CartObject> unconfirmedCart = new ArrayList<CartObject>();
    private List<CartObject> shoppingCart = new ArrayList<CartObject>();
    private String gnomeType;
    private int gnomeAmount;
    private int gnomePrice;
    private String gnome1Type;
    private int gnome1Amount;
    private int gnome1Price;
    private String gnome2Type;
    private int gnome2Amount;
    private int gnome2Price;
    private String gnome3Type;
    private int gnome3Amount;
    private int gnome3Price;
    
    private String gnome1CartType;
    private int gnome1CartAmount;
    private int gnome1CartPrice;
    private String gnome2CartType;
    private int gnome2CartAmount;
    private int gnome2CartPrice;
    private String gnome3CartType;
    private int gnome3CartAmount;
    private int gnome3CartPrice;
    
    private String userName;
    private String desiredCartType;
    @Inject
    private Conversation conversation;
    
    /**
     * Creates a new instance of webShopManager
     */
    public WebShopManager() {
    }
    
    /**
     * Handles exceptions
     */
    private void handleException(Exception e) {
        stopConversation();
        e.printStackTrace(System.err);
        transactionFailure = e;
    }

    /**
     * Start the conversation with the bean
     */
    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    /**
     * stop the conversation with the beans
     */
     public void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        loginSuccessfullyUser = false;
        loginSuccessfullyAdmin = false;
     }
    
    /**
     * Returns
     * <code>false</code> if the latest transaction failed, otherwise
     * <code>false</code>.
     */
    public boolean getSuccess() {
        return transactionFailure == null;
    }

    /**
     * Returns the latest thrown exception.
     */
    public Exception getException() {
        return transactionFailure;
    }
    
    /*************************** Getter and Setter ***************************/

    public String getCurrentPseudo() {
        return currentPseudo;
    }

    public String getError() {
        return error;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setCurrentPseudo(String currentPseudo) {
        this.currentPseudo = currentPseudo;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
    
     public String getGnomeType() {
        return gnomeType;
    }
    
     public void setGnomeType(String gnomeType) {
        this.gnomeType = gnomeType;
    }
     
     
     public String getDesiredCartType() {
        return desiredCartType;
    }
    
     public void setDesiredCartType(String desiredCartType) {
        this.desiredCartType = desiredCartType;
    }
     
       public String getUserName() {
        return userName;
    }
    
     public void setUserName(String userName) {
        this.userName = userName;
    }

      public int getGnomeAmount() {
        return gnomeAmount;
    }
    
     public void setGnomeAmount(int gnomeAmount) {
        this.gnomeAmount = gnomeAmount;
    }
     
      public int getGnomePrice() {
        return gnomePrice;
    }
    
     public void setGnomePrice(int gnomePrice) {
        this.gnomePrice = gnomePrice;
    }
   
    
     public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    
     public void setSuccessfulLoginUser(boolean loginUser) {
        this.loginSuccessfullyUser = loginUser;
    }
    
     public boolean getSuccessfulLoginUser() {
        return loginSuccessfullyUser;
    }
     
   public void setSuccessfulLoginAdmin(boolean loginAdmin) {
        this.loginSuccessfullyAdmin = loginAdmin;
    }
    
    public boolean getSuccessfulLoginAdmin() {
        return loginSuccessfullyAdmin;
    }
    
     public List<CartObject> getUnconfirmedCart() {
        return unconfirmedCart;
    }

    public void setUnconfirmedCart(List<CartObject> unconfirmedCart) {
        this.unconfirmedCart = unconfirmedCart;
    }
    
     public List<CartObject> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<CartObject> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
     public List<GnomeDTO> getGnomes() {
        return gnomes;
    }
     
     
    public String getGnome1Type() {
        return gnome1Type;
    }
    
     public void setGnome1Type(String gnome1Type) {
        this.gnome1Type = gnome1Type;
    }
    
    
      public int getGnome1Amount() {
        return gnome1Amount;
    }
    
     public void setGnome1Amount(int gnome1Amount) {
        this.gnome1Amount = gnome1Amount;
    }
     
      public int getGnome1Price() {
        return gnome1Price;
    }
    
     public void setGnome1Price(int gnome1Price) {
        this.gnome1Price = gnome1Price;
    }
     
     public String getGnome2Type() {
        return gnome2Type;
    }
    
     public void setGnome2Type(String gnome2Type) {
        this.gnome2Type = gnome2Type;
    }
    
    
      public int getGnome2Amount() {
        return gnome2Amount;
    }
    
     public void setGnome2Amount(int gnome2Amount) {
        this.gnome2Amount = gnome2Amount;
    }
     
      public int getGnome2Price() {
        return gnome2Price;
    }
    
     public void setGnome2Price(int gnome2Price) {
        this.gnome2Price = gnome2Price;
    }
     
      public String getGnome3Type(){
        return gnome3Type;
    }
    
     public void setGnome3Type(String gnome3Type) {
        this.gnome3Type = gnome3Type;
    }
    
    
      public int getGnome3Amount() {
        return gnome3Amount;
    }
    
     public void setGnome3Amount(int gnome3Amount) {
        this.gnome3Amount = gnome3Amount;
    }
     
      public int getGnome3Price() {
        return gnome3Price;
    }
    
     public void setGnome3Price(int gnome3Price) {
        this.gnome3Price = gnome3Price;
    }
     
     
    public String getGnome1CartType() {
        return gnome1CartType;
    }
    
     public void setGnome1CartType(String gnome1CartType) {
        this.gnome1CartType = gnome1CartType;
    }
    
    
      public int getGnome1CartAmount() {
        return gnome1CartAmount;
    }
    
     public void setGnome1CartAmount(int gnome1CartAmount) {
        this.gnome1CartAmount = gnome1CartAmount;
    }
     
      public int getGnome1CartPrice() {
        return gnome1CartPrice;
    }
    
     public void setGnome1CartPrice(int gnome1CartPrice) {
        this.gnome1CartPrice = gnome1CartPrice;
    }
     
     public String getGnome2CartType() {
        return gnome2CartType;
    }
    
     public void setGnome2CartType(String gnome2CartType) {
        this.gnome2CartType = gnome2CartType;
    }
    
    
      public int getGnome2CartAmount() {
        return gnome2CartAmount;
    }
    
     public void setGnome2CartAmount(int gnome2CartAmount) {
        this.gnome2CartAmount = gnome2CartAmount;
    }
     
      public int getGnome2CartPrice() {
        return gnome2CartPrice;
    }
    
     public void setGnome2CartPrice(int gnome2CartPrice) {
        this.gnome2CartPrice = gnome2CartPrice;
    }
     
      public String getGnome3CartType(){
        return gnome3CartType;
    }
    
     public void setGnome3CartType(String gnome3CartType) {
        this.gnome3CartType = gnome3CartType;
    }
    
    
      public int getGnome3CartAmount() {
        return gnome3CartAmount;
    }
    
     public void setGnome3CartAmount(int gnome3CartAmount) {
        this.gnome3CartAmount = gnome3CartAmount;
    }
     
      public int getGnome3CartPrice() {
        return gnome3CartPrice;
    }
    
     public void setGnome3CartPrice(int gnome3CartPrice) {
        this.gnome3CartPrice = gnome3CartPrice;
    }
     
     /*************************** Getter and Setter ***************************/
     
    /**
     * LogOut a customer or admin
     *
     */
    public void logOut() {
        webShopFacade.logoutCustomer(currentPseudo);
        loginSuccessfullyUser = false;
        loginSuccessfullyAdmin = false;
        message = null;
        stopConversation();
    }
   
    /**
     * Log on the customer.
     * 
     * A error message is displayed if :
     *          - The name does not exist
     *          - The password and the name don't correspond
     *          - The user is banned
     */
    
    public void loginCustomer(){
        startConversation();
        CustomerDTO customer;
        try {
            
            customer = webShopFacade.getCustomer(currentPseudo);
            if (customer == null) {
                error = "Error : This name does not exist";
            } else if (! (customer.getPassword().equals(currentPassword))) {
                System.out.println("password mismatch");
                error = "Error : The password or the pseudo is not correct";
            } else if (customer.getIsbanned()) {
                error = "Error : This user has been banned";
            }else {
                System.out.println("login success");
                webShopFacade.loginCustomer(currentPseudo);
                if(currentPseudo.equalsIgnoreCase("admin")){
                    System.out.println("adminnavigation");
                    loginSuccessfullyAdmin = true;
                }
                else{
                    System.out.println("usernavigate");
                   loginSuccessfullyUser = true; 
                }
                error = null;
               }
          } catch (Exception e) {
            handleException(e);
        }
    }
    
    /**
     * Create a new customer.
     * 
     * A error message is displayed if :
     *          - The password lentgh in smaller than 8 characters
     *          - The user name is used by another customer
     */
    
    public void createNewCustomer() {
        startConversation();
        try {
            if (currentPassword.length() < 8) {
                error = "Error : Password length should be longer than 8 characters";            
            } else if (webShopFacade.getCustomer(currentPseudo) != null) {
                error = "Error : This name has already been registered";
            } else {
                error = null;
                CustomerDTO customer; 
                System.out.println("beforecallingfacde");
                customer = webShopFacade.createCustomerDTO(
                                                    currentPseudo,
                                                    currentPassword);
                System.out.println(customer.getId());
                if(currentPseudo.equalsIgnoreCase("admin")){
                    System.out.println("loginadminnav");
                    loginSuccessfullyAdmin = true;
                }
                else{
                    System.out.println("logusernav");
                   loginSuccessfullyUser = true; 
                }
            }
        } catch (Exception e) {
            handleException(e);
        }
    
    }
    
     /**
     * Display available gnome in the inventory
     * 
     */
    
   public void showAvailableGnomes() {
        try {
             System.out.println("inavailablegnomes");
           gnomes = webShopFacade.getAllGnomes();
            for(int i=0; i<gnomes.size(); i++){
                Gnome gnome = (Gnome)gnomes.get(i);
                System.out.println(gnome.getType());
                unconfirmedCart.add(new CartObject(gnome,0));
               // shoppingCart.add(new CartObject(gnome,0));
            }
            showInventory();
           // message = null;
        } catch (Exception e) {
            handleException(e);
        }
    }
   
    public void showInventory() {
     if(unconfirmedCart != null){
         for (CartObject aMap : unconfirmedCart) {
             System.out.println(aMap.getGnome().getType());
             if(aMap.getGnome().getType().equalsIgnoreCase("gnome1")){
                 System.out.println("ingnome1");
                 gnome1Type = aMap.getGnome().getType();
                 gnome1Price = aMap.getGnome().getPrice();
                 gnome1Amount = aMap.getGnome().getAmount();
             }else if(aMap.getGnome().getType().equalsIgnoreCase("gnome2")){
                 System.out.println("ingonme2");
                 gnome2Type = aMap.getGnome().getType();
                 gnome2Price = aMap.getGnome().getPrice();
                 gnome2Amount = aMap.getGnome().getAmount();
             }else{
                 System.out.println("gnome3");
                 gnome3Type = aMap.getGnome().getType();
                 gnome3Price = aMap.getGnome().getPrice();
                 gnome3Amount = aMap.getGnome().getAmount();
             }
             
         }
     }
  }   
     
     /**
     * Display the shopping basket
     * 
     */  
    
   public void showCart() {
     if(unconfirmedCart != null){
         for (CartObject aMap : unconfirmedCart) {
             System.out.println(aMap.getGnome().getType());
             if(aMap.getGnome().getType().equalsIgnoreCase("gnome1")){
                 System.out.println("ingnome1");
                 gnome1CartType = aMap.getGnome().getType();
                 gnome1CartPrice = aMap.getGnome().getPrice();
                 gnome1CartAmount = aMap.getAmount();
               }else if(aMap.getGnome().getType().equalsIgnoreCase("gnome2")){
                 System.out.println("ingnome1");
                 gnome2CartType = aMap.getGnome().getType();
                 gnome2CartPrice = aMap.getGnome().getPrice();
                 gnome2CartAmount = aMap.getAmount();
                }else{
                 System.out.println("ingnome1");
                 gnome3CartType = aMap.getGnome().getType();
                 gnome3CartPrice = aMap.getGnome().getPrice();
                 gnome3CartAmount = aMap.getAmount();
             }
             
         }
     }
  }   
    
     /**
     * Add gnome to shopping cart
     * 
     */  
   
  public void addToCart() {
      System.out.println("addtocart");
      for (CartObject aMap : unconfirmedCart) {
          if(aMap.getGnome().getType().equalsIgnoreCase(desiredCartType)){
              System.out.println("desiredfound");
              int amount = aMap.getGnome().getAmount();
              aMap.getGnome().setAmount(amount-1);
              int shoppingcartAmount = aMap.getAmount();
              aMap.setAmount(shoppingcartAmount+1); 
              break;
          }
      }
    }  
  
    /**
     * remove gnome to shopping cart
     * 
     */  
  
  public void removeFromCart() {
      System.out.println("removedfromcart");
      for (CartObject aMap : unconfirmedCart) {
          if(aMap.getGnome().getType().equalsIgnoreCase(desiredCartType)){
              System.out.println("removedresiredif");
              int amount = aMap.getGnome().getAmount();
              aMap.getGnome().setAmount(amount+1);
              int shoppingcartAmount = aMap.getAmount();
              aMap.setAmount(shoppingcartAmount-1); // shoppin cart goes like 1,2,3,
              break;
          }
      }
    }  
  
    /**
     * empty shopping cart
     * 
     */  
  public void removeCart() {
      System.out.println("emptybasket");
      for (CartObject aMap : unconfirmedCart) {
          aMap.setAmount(0);
      }
   }
  
  
    /**
     * buy items in the shopping cart
     * 
     */  
       
    public void buy() {
          System.out.println("buy");
          for (CartObject Map : unconfirmedCart) {
            webShopFacade.updateGnome(Map.getGnome().getType(),Map.getGnome().getAmount());
          }
    removeCart();
  }
    
     /**
     * Admin can ban Customers
     */
    public void banUser(){
        startConversation();
        Boolean check = webShopFacade.ban(userName);
        if (!check) {
            error = "Error : this user does not exist";
        } else {
            error = null;
        }
    }
    
     /**
     * Add a new Gnome to the inventory by Admin
     */
    
     public void createGnome() {
         startConversation();
        try {
            webShopFacade.createGnome(gnomeType, gnomePrice, gnomeAmount);
          } catch (Exception e) {
            handleException(e);
        }
    }

     /**
     * delete a new Gnome to the inventory by Admin
     */
      public void deleteGnome() {
          startConversation();
          webShopFacade.deleteGnome(gnomeType);
       }
      
      /**
     * modify a new Gnome to the inventory by Admin
     */
      public void updateGnome() {
          startConversation();
          webShopFacade.updateGnomeAdmin(gnomeType, gnomePrice, gnomeAmount);
      } 

    
 }
