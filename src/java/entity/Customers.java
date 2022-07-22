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
public class Customers {
    private String CustomerID;
    private String CompanyName;
    private String ContactName;
    private String ContactTitle;
    private String Address;
    private String City;
    private String Region;
    private String PostalCode;
    private String Country;
    private String Phone;
    private String Fax;
    private String username;
    private String password;

    public Customers(String CustomerID, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax, String username, String password) {
        this.CustomerID = CustomerID;
        this.CompanyName = CompanyName;
        this.ContactName = ContactName;
        this.ContactTitle = ContactTitle;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.Phone = Phone;
        this.Fax = Fax;
        this.username = username;
        this.password = password;
    }

    public Customers(String CustomerID, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax) {
        this.CustomerID = CustomerID;
        this.CompanyName = CompanyName;
        this.ContactName = ContactName;
        this.ContactTitle = ContactTitle;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.Phone = Phone;
        this.Fax = Fax;
    }

    public Customers() {
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public void setContactTitle(String ContactTitle) {
        this.ContactTitle = ContactTitle;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }
    
        
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getRegion() {
        return Region;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getCountry() {
        return Country;
    }

    public String getPhone() {
        return Phone;
    }

    public String getFax() {
        return Fax;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customers{" + "CustomerID=" + CustomerID + ", CompanyName=" + CompanyName + ", ContactName=" + ContactName + ", ContactTitle=" + ContactTitle + ", Address=" + Address + ", City=" + City + ", Region=" + Region + ", PostalCode=" + PostalCode + ", Country=" + Country + ", Phone=" + Phone + ", Fax=" + Fax + '}';
    }
    
    
}
