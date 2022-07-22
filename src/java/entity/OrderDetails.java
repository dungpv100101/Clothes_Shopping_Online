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
public class OrderDetails {
    private int OrderID;
    private  int ProductID;
    private  double UnitPrice;
    private int Quantity;
    private double Discount;

    public OrderDetails() {
    }

    public OrderDetails(int OrderID, int ProductID, double UnitPrice, int Quantity, double Discount) {
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Discount = Discount;
    }
    
    public OrderDetails(int ProductID, double UnitPrice, int Quantity, double Discount) {
        this.ProductID = ProductID;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Discount = Discount;
    }

    public int getOrderID() {
        return OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "OrderID=" + OrderID + ", ProductID=" + ProductID + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", Discount=" + Discount + '}';
    }
    
    
}
