/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Dung
 */
public class ProductInCart {
    private int ProductID;
    private String ProductName;
    private double UnitPrice;
    private int quantity;

    public ProductInCart(int ProductID, String ProductName, double UnitPrice, int quantity) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.quantity = quantity;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
            
}
