/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webShop.model;

/**
 *
 * @author prakash
 */
public interface CustomerDTO {
      public String getId();

      public String getPassword();

      public Boolean getIsLog();
      
      public void setIsLog(Boolean isLog);
      
      public Boolean getIsbanned();

      public void setIsbanned(Boolean isbanned);

}
