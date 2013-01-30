/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webShop.model;

/**
 *
 * @author Prakash
 */
public class CartObject {
    private Gnome gnome;
    private int amount;

    public CartObject(Gnome gnome, int amount) {
        this.gnome = gnome;
        this.amount = amount;
    }

    public Gnome getGnome() {
        return gnome;
    }

    public void setGnome(Gnome gnome) {
        this.gnome = gnome;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
