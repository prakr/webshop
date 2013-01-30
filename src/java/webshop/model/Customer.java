/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webShop.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author prakash
 */
@Entity
public class Customer implements Serializable, CustomerDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String pseudo;
    private String password;
    private Boolean isLog;
    private Boolean isbanned;

    public Customer (String pseudo,String password) {
        this.pseudo = pseudo;
        this.password = password;
        this.isLog = true;
        this.isbanned = false;
    }
    
    public Customer(){
        
    }
    
    @Override
    public String getId() {
        return pseudo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setIsLog(Boolean isLog) {
        this.isLog = isLog;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Boolean getIsLog() {
        return isLog;
    }

    public void setId(String id) {
        this.pseudo = id;
    }
 
    @Override
    public Boolean getIsbanned() {
        return isbanned;
    }

    @Override
    public void setIsbanned(Boolean isbanned) {
        this.isbanned = isbanned;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pseudo != null ? pseudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.pseudo == null && other.pseudo != null) || 
                (this.pseudo != null && !this.pseudo.equals(other.pseudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webShop.model.Customer[ id=" + pseudo + " ]";
    }
    
}
