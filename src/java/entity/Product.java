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
public class Product {
    private int ProductID;
    private String ProductName;
    private int SupplierID;
    private int CategoryID;
    private String QuantityPerUnit;
    private double UnitPrice;
    private int UnitsInStock;
    private int UnitOnOrder;
    private int ReordeerLevel;
    private int Discontinued;

    public Product() {
    }

    public Product(int ProductID, String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitOnOrder, int ReordeerLevel, int Discontinued) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitOnOrder = UnitOnOrder;
        this.ReordeerLevel = ReordeerLevel;
        this.Discontinued = Discontinued;
    }

    public Product(String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitOnOrder, int ReordeerLevel, int Discontinued) {
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitOnOrder = UnitOnOrder;
        this.ReordeerLevel = ReordeerLevel;
        this.Discontinued = Discontinued;
    }
    
    

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public int getUnitOnOrder() {
        return UnitOnOrder;
    }

    public int getReordeerLevel() {
        return ReordeerLevel;
    }

    public int getDiscontinued() {
        return Discontinued;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setUnitsInStock(int UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public void setUnitOnOrder(int UnitOnOrder) {
        this.UnitOnOrder = UnitOnOrder;
    }

    public void setReordeerLevel(int ReordeerLevel) {
        this.ReordeerLevel = ReordeerLevel;
    }

    public void setDiscontinued(int Discontinued) {
        this.Discontinued = Discontinued;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", SupplierID=" + SupplierID + ", CategoryID=" + CategoryID + ", QuantityPerUnit=" + QuantityPerUnit + ", UnitPrice=" + UnitPrice + ", UnitsInStock=" + UnitsInStock + ", UnitOnOrder=" + UnitOnOrder + ", ReordeerLevel=" + ReordeerLevel + ", Discontinued=" + Discontinued + '}';
    }
    
    
}
