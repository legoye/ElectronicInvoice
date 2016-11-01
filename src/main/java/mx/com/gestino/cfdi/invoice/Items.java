/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.gestino.cfdi.invoice;

/**
 *
 * @author developer
 */
public class Items {
    
    private String quantity;
    private String unit;
    private String noIdetificacion;
    private String description;
    private String price;
    private String amount;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNoIdetificacion() {
        return noIdetificacion;
    }

    public void setNoIdetificacion(String noIdetificacion) {
        this.noIdetificacion = noIdetificacion;
    }
    
}
