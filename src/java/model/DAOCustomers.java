/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnectDB;

/**
 *
 * @author Dung
 */
public class DAOCustomers extends ConnectDB {

    public int addCostumer(Customers cus) {
        int n = 0;
        String preSql = "insert into Customers(CustomerID,CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax,username,password)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(preSql);

            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getContactName());
            pre.setString(4, cus.getContactTitle());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getRegion());
            pre.setString(8, cus.getPostalCode());
            pre.setString(9, cus.getCountry());
            pre.setString(10, cus.getPhone());
            pre.setString(11, cus.getFax());
            pre.setString(12, cus.getUsername());
            pre.setString(13, cus.getPassword());

            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateCostumer(Customers cus) {
        int n = 0;
        String preSql = "update Customers set CustomerID=?,CompanyName=?,ContactName=?,ContactTitle=?,Address=?,City=?,Region=?,PostalCode=?,Country=?,Phone=?,Fax=? where CustomerID=?";

        try {
            PreparedStatement pre = conn.prepareStatement(preSql);

            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getContactName());
            pre.setString(4, cus.getContactTitle());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getRegion());
            pre.setString(8, cus.getPostalCode());
            pre.setString(9, cus.getCountry());
            pre.setString(10, cus.getPhone());
            pre.setString(11, cus.getFax());
            pre.setString(12, cus.getCustomerID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteByID(String CustomerID) {
        int n = 0;
        String sql = "delete from [Order Details] where OrderID in (\n"
                + "	select OrderID from Orders where CustomerID = '"+CustomerID+"'\n"
                + ")\n"
                + "delete from Orders where CustomerID = '"+CustomerID+"'\n"
                + "delete from Customers where CustomerID = '"+CustomerID+"'";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<Customers> listAllCustomers() {
        Vector vector = new Vector<>();

        String sql = "select * from Customers";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                String CustomerID = rs.getString(1);
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

                vector.add(new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Customers> listAllCustomers(String sql) {
        Vector vector = new Vector<>();

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                String CustomerID = rs.getString(1);
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
                String username = rs.getString(12);
                String password = rs.getString(13);

                vector.add(new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, username, password));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public boolean checkLogin(String username, String password) {
        String sql = "select * from Customers where username='" + username + "' and password='" + password + "'";

        try {
            Statement state = conn.createStatement();

            if (state.executeQuery(sql).next()) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Customers getCustomerByUserName(String userName) {
        String sql = "select * from Customers where username = '" + userName + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                String CustomerID = rs.getString(1);
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

                return new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Customers getCustomerByID(String id) {
        String sql = "select * from Customers where CustomerID = '" + id + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                String CustomerID = rs.getString(1);
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
                String username = rs.getString(12);
                String password = rs.getString(13);

                return new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean checkCustomerExist(String username, String customerID) {
        String sql = "select * from Customers where username = '" + username + "' or CustomerID='" + customerID + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public String getCustomerName(String id) {
        String sql = "select * from Customers where [CustomerID] = '" + id + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                String CustomerID = rs.getString(1);
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

                return CompanyName;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        DAOCustomers dao = new DAOCustomers();

        Vector<Customers> vec = dao.listAllCustomers();

        for (Customers cus : vec) {
            System.out.println(cus);
        }
    }
}
