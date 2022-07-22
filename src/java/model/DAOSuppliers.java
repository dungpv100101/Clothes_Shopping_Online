/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Suppliers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DAOSuppliers extends ConnectDB {

    public int addSuppliers(Suppliers sp) {
        int n = 0;
        String sql = "insert into Suppliers(CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax,HomePage)"
                + " values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, sp.getCompanyName());
            pre.setString(2, sp.getContactName());
            pre.setString(3, sp.getContactTitle());
            pre.setString(4, sp.getAddress());
            pre.setString(5, sp.getCity());
            pre.setString(6, sp.getRegion());
            pre.setString(7, sp.getPostalCode());
            pre.setString(8, sp.getCountry());
            pre.setString(9, sp.getPhone());
            pre.setString(10, sp.getFax());
            pre.setString(11, sp.getHomePage());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateSuppliers(Suppliers sp) {
        int n = 0;
        String sql = "update Suppliers set CompanyName=?,ContactName=?,"
                + "ContactTitle=?,Address=?,City=?,Region=?,PostalCode=?,"
                + "Country=?,Phone=?,Fax=?,HomePage=? where SupplierID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, sp.getCompanyName());
            pre.setString(2, sp.getContactName());
            pre.setString(3, sp.getContactTitle());
            pre.setString(4, sp.getAddress());
            pre.setString(5, sp.getCity());
            pre.setString(6, sp.getRegion());
            pre.setString(7, sp.getPostalCode());
            pre.setString(8, sp.getCountry());
            pre.setString(9, sp.getPhone());
            pre.setString(10, sp.getFax());
            pre.setString(11, sp.getHomePage());
            pre.setInt(12, sp.getSupplierID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deletebyID(int SupplierID) {
        int n = 0;
        String sql = "delete from Suppliers where SupplierID=" + SupplierID;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Suppliers> listAllSuppliers() {
        Vector<Suppliers> vector = new Vector<>();
        String sql = "select * from Suppliers";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int SupplierID = rs.getInt(1);
                String CompanyName = rs.getString(2);
                String ContactName = rs.getString(3);
                String ContactTitle = rs.getString(4);
                String Address = rs.getString(5);
                String City = rs.getString(6);
                String Region = rs.getString(7);
                String PostalCode = rs.getString(8);
                String Country = rs.getString(9);
                String Phone = rs.getString(10);
                String Fax = rs.getString(11);
                String HomePage = rs.getString(11);

                vector.add(new Suppliers(SupplierID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, HomePage));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOSuppliers dao = new DAOSuppliers();

    }
}
