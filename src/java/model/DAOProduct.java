/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
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
public class DAOProduct extends ConnectDB { // Database Access Object 

    public int addProduct(Product pro) {
        int n = 0;
        String preSql = "insert into Products(ProductName,SupplierID,CategoryID,QuantityPerUnit,UnitPrice,UnitsInStock,UnitsOnOrder,ReorderLevel,Discontinued)"
                + " values(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(preSql);

            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitOnOrder());
            pre.setInt(8, pro.getReordeerLevel());
            pre.setInt(9, pro.getDiscontinued());

            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateProduct(Product pro) {
        int n = 0;
        String preSql = "update Products set ProductName=?,SupplierID=?,CategoryID=?,QuantityPerUnit=?,UnitPrice=?,UnitsInStock=?,UnitsOnOrder=?,ReorderLevel=?,Discontinued=? where ProductID=?";

        try {
            PreparedStatement pre = conn.prepareStatement(preSql);

            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitOnOrder());
            pre.setInt(8, pro.getReordeerLevel());
            pre.setInt(9, pro.getDiscontinued());
            pre.setInt(10, pro.getProductID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteProduct(int ProductID) {
        int n = 0;
        String sql = "delete from [Order Details] where ProductID = "+ProductID+"\n"
                + "delete from Products where ProductID = "+ProductID+"";

        try {
            Statement state = conn.createStatement();

            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public void listAllProduct() {
        String sql = "select * from Products";

        try {
            ResultSet rs = getData(sql);

            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString(2);
                int SupplierID = rs.getInt(3);
                int CategoryID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                double UnitPrice = rs.getDouble(6);
                int UnitsInStock = rs.getInt(7);
                int UnitOnOrder = rs.getInt(8);
                int ReordeerLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);

                Product pro = new Product(ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitOnOrder, ReordeerLevel, Discontinued);
                System.out.println(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vector<Product> listAllProduct(String sql) {
        Vector<Product> vector = new Vector<Product>();
        try {
            ResultSet rs = getData(sql);

            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString(2);
                int SupplierID = rs.getInt(3);
                int CategoryID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                double UnitPrice = rs.getDouble(6);
                int UnitsInStock = rs.getInt(7);
                int UnitOnOrder = rs.getInt(8);
                int ReordeerLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);

                Product pro = new Product(ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitOnOrder, ReordeerLevel, Discontinued);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public Vector<Product> searchByPrice(double from, double to) {
        Vector<Product> vector = new Vector<Product>();
        String sql = "select * from Products where UnitPrice between " + from + " and " + to;
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString(2);
                int SupplierID = rs.getInt(3);
                int CategoryID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                double UnitPrice = rs.getDouble(6);
                int UnitsInStock = rs.getInt(7);
                int UnitOnOrder = rs.getInt(8);
                int ReordeerLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);

                Product pro = new Product(ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitOnOrder, ReordeerLevel, Discontinued);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public Vector<Product> searchProductByName(String ProductName) {
        Vector<Product> vector = new Vector<>();

        String sql = "select * from Products where ProductName='" + ProductName + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String Name = rs.getString(2);
                int SupplierID = rs.getInt(3);
                int CategoryID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                double UnitPrice = rs.getDouble(6);
                int UnitsInStock = rs.getInt(7);
                int UnitOnOrder = rs.getInt(8);
                int ReordeerLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);

                Product pro = new Product(ProductID, Name, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitOnOrder, ReordeerLevel, Discontinued);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public Product searchProductByID(String productID) {
        String sql = "select * from Products where ProductID='" + productID + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String Name = rs.getString(2);
                int SupplierID = rs.getInt(3);
                int CategoryID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                double UnitPrice = rs.getDouble(6);
                int UnitsInStock = rs.getInt(7);
                int UnitOnOrder = rs.getInt(8);
                int ReordeerLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);

                Product pro = new Product(ProductID, Name, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitOnOrder, ReordeerLevel, Discontinued);
                return pro;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String getProductName(String productID) {
        String sql = "select ProductName from Products where ProductID='" + productID + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                String Name = rs.getString(1);

                return Name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();

        Vector<Product> vec = dao.searchProductByName("Keo Cay");

        for (Product pro : vec) {
            System.out.println(pro);
        }
    }
}
