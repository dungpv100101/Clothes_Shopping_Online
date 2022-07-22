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
public class Shippers {
    private int ShipperID;
    private String CompanyName;
    private String Phone;

    public Shippers() {
    }

    public Shippers(int ShipperID, String CompanyName, String Phone) {
        this.ShipperID = ShipperID;
        this.CompanyName = CompanyName;
        this.Phone = Phone;
    }

    public Shippers(String CompanyName, String Phone) {
        this.CompanyName = CompanyName;
        this.Phone = Phone;
    }

    public int getShipperID() {
        return ShipperID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setShipperID(int ShipperID) {
        this.ShipperID = ShipperID;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    
}
