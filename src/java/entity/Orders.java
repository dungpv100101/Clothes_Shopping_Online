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
public class Orders {
    private int OrderID;
    private String CustomerID;
    private int EmployeeID;
    private String OrderDate;
    private String RequireDate;
    private String ShippedDate;
    private int ShipVia;
    private double Freight;
    private String ShipName;
    private String ShipAddress;
    private String ShipCity;
    private String ShipRegion;
    private String ShipPostalCode;
    private String ShipCountry;
    private String status;

    public Orders(int OrderID, String CustomerID, int EmployeeID, String OrderDate, String RequireDate, String ShippedDate, int ShipVia, double Freight, String ShipName, String ShipAddress, String ShipCity, String ShipRegion, String ShipPostalCode, String ShipCountry, String status) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.EmployeeID = EmployeeID;
        this.OrderDate = OrderDate;
        this.RequireDate = RequireDate;
        this.ShippedDate = ShippedDate;
        this.ShipVia = ShipVia;
        this.Freight = Freight;
        this.ShipName = ShipName;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.ShipRegion = ShipRegion;
        this.ShipPostalCode = ShipPostalCode;
        this.ShipCountry = ShipCountry;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Orders() {
    }

    public Orders(int OrderID, String CustomerID, int EmployeeID, String OrderDate, String RequireDate, String ShippedDate, int ShipVia, double Freight, String ShipName, String ShipAddress, String ShipCity, String ShipRegion, String ShipPostalCode, String ShipCountry) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.EmployeeID = EmployeeID;
        this.OrderDate = OrderDate;
        this.RequireDate = RequireDate;
        this.ShippedDate = ShippedDate;
        this.ShipVia = ShipVia;
        this.Freight = Freight;
        this.ShipName = ShipName;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.ShipRegion = ShipRegion;
        this.ShipPostalCode = ShipPostalCode;
        this.ShipCountry = ShipCountry;
    }

    public Orders(String CustomerID, int EmployeeID, String OrderDate, String RequireDate, String ShippedDate, int ShipVia, double Freight, String ShipName, String ShipAddress, String ShipCity, String ShipRegion, String ShipPostalCode, String ShipCountry) {
        this.CustomerID = CustomerID;
        this.EmployeeID = EmployeeID;
        this.OrderDate = OrderDate;
        this.RequireDate = RequireDate;
        this.ShippedDate = ShippedDate;
        this.ShipVia = ShipVia;
        this.Freight = Freight;
        this.ShipName = ShipName;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.ShipRegion = ShipRegion;
        this.ShipPostalCode = ShipPostalCode;
        this.ShipCountry = ShipCountry;
    }

    public int getOrderID() {
        return OrderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public String getRequireDate() {
        return RequireDate;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public int getShipVia() {
        return ShipVia;
    }

    public double getFreight() {
        return Freight;
    }

    public String getShipName() {
        return ShipName;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public String getShipRegion() {
        return ShipRegion;
    }

    public String getShipPostalCode() {
        return ShipPostalCode;
    }

    public String getShipCountry() {
        return ShipCountry;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setRequireDate(String RequireDate) {
        this.RequireDate = RequireDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public void setShipVia(int ShipVia) {
        this.ShipVia = ShipVia;
    }

    public void setFreight(double Freight) {
        this.Freight = Freight;
    }

    public void setShipName(String ShipName) {
        this.ShipName = ShipName;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    public void setShipCity(String ShipCity) {
        this.ShipCity = ShipCity;
    }

    public void setShipRegion(String ShipRegion) {
        this.ShipRegion = ShipRegion;
    }

    public void setShipPostalCode(String ShipPostalCode) {
        this.ShipPostalCode = ShipPostalCode;
    }

    public void setShipCountry(String ShipCountry) {
        this.ShipCountry = ShipCountry;
    }

    @Override
    public String toString() {
        return "Orders{" + "OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", EmployeeID=" + EmployeeID + ", OrderDate=" + OrderDate + ", RequireDate=" + RequireDate + ", ShippedDate=" + ShippedDate + ", ShipVia=" + ShipVia + ", Freight=" + Freight + ", ShipName=" + ShipName + ", ShipAddress=" + ShipAddress + ", ShipCity=" + ShipCity + ", ShipRegion=" + ShipRegion + ", ShipPostalCode=" + ShipPostalCode + ", ShipCountry=" + ShipCountry + '}';
    }
    
    
}
