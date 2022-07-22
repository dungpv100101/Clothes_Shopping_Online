/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DAOOrders extends ConnectDB {

    public int addOrders(Orders ord) {
        int n = 0;
        String sql = "Insert into Orders(CustomerID,EmployeeID,OrderDate,RequiredDate,ShippedDate,"
                + "ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ord.getCustomerID());
            pre.setInt(2, ord.getEmployeeID());
            pre.setString(3, ord.getOrderDate());
            pre.setString(4, ord.getRequireDate());
            pre.setString(5, ord.getShippedDate());
            pre.setInt(6, ord.getShipVia());
            pre.setDouble(7, ord.getFreight());
            pre.setString(8, ord.getShipName());
            pre.setString(9, ord.getShipAddress());
            pre.setString(10, ord.getShipCity());
            pre.setString(11, ord.getShipRegion());
            pre.setString(12, ord.getShipPostalCode());
            pre.setString(13, ord.getShipCountry());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateOrders(Orders ord, int oid) {
        int n = 0;
        String sql = "Update Orders set CustomerID=?,EmployeeID=?,OrderDate=?,"
                + "RequiredDate=?,ShippedDate=?, ShipVia=?,Freight=?,ShipName=?,"
                + "ShipAddress=?,ShipCity=?,ShipRegion=?,ShipPostalCode=?,ShipCountry=?"
                + " where OrderID=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ord.getCustomerID());
            pre.setInt(2, ord.getEmployeeID());
            pre.setString(3, ord.getOrderDate());
            pre.setString(4, ord.getRequireDate());
            pre.setString(5, ord.getShippedDate());
            pre.setInt(6, ord.getShipVia());
            pre.setDouble(7, ord.getFreight());
            pre.setString(8, ord.getShipName());
            pre.setString(9, ord.getShipAddress());
            pre.setString(10, ord.getShipCity());
            pre.setString(11, ord.getShipRegion());
            pre.setString(12, ord.getShipPostalCode());
            pre.setString(13, ord.getShipCountry());
            pre.setInt(14, oid);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteByID(int OrderID) {
        int n = 0;
        String sql = "delete from Orders where OrderID=" + OrderID;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<Orders> listAllOrders() {
        Vector<Orders> vector = new Vector<>();
        String sql = "select * from Orders";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String CustomerID = rs.getString(2);
                int EmployeeID = rs.getInt(3);
                String OrderDate = rs.getString(4);
                String RequireDate = rs.getString(5);
                String ShippedDate = rs.getString(6);
                int ShipVia = rs.getInt(7);
                double Freight = rs.getDouble(8);
                String ShipName = rs.getString(9);
                String ShipAddress = rs.getString(10);
                String ShipCity = rs.getString(11);
                String ShipRegion = rs.getString(12);
                String ShipPostalCode = rs.getString(13);
                String ShipCountry = rs.getString(14);
                String status = rs.getString(15);
                
                vector.add(new Orders(OrderID, CustomerID, EmployeeID, OrderDate, RequireDate, ShippedDate,
                        ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion,
                        ShipPostalCode, ShipCountry, status));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Vector<Orders> listAllOrders(String sql) {
        Vector<Orders> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String CustomerID = rs.getString(2);
                int EmployeeID = rs.getInt(3);
                String OrderDate = rs.getString(4);
                String RequireDate = rs.getString(5);
                String ShippedDate = rs.getString(6);
                int ShipVia = rs.getInt(7);
                double Freight = rs.getDouble(8);
                String ShipName = rs.getString(9);
                String ShipAddress = rs.getString(10);
                String ShipCity = rs.getString(11);
                String ShipRegion = rs.getString(12);
                String ShipPostalCode = rs.getString(13);
                String ShipCountry = rs.getString(14);
                String status = rs.getString(15);
                
                vector.add(new Orders(OrderID, CustomerID, EmployeeID, OrderDate, RequireDate, ShippedDate,
                        ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion,
                        ShipPostalCode, ShipCountry, status));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Orders> searchOrderByCustomerID(String CustomerID) {
        Vector<Orders> vector = new Vector<>();
        String sql = "select * from Orders where CustomerID='" + CustomerID + "'";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String ID = rs.getString(2);
                int EmployeeID = rs.getInt(3);
                String OrderDate = rs.getString(4);
                String RequireDate = rs.getString(5);
                String ShippedDate = rs.getString(6);
                int ShipVia = rs.getInt(7);
                double Freight = rs.getDouble(8);
                String ShipName = rs.getString(9);
                String ShipAddress = rs.getString(10);
                String ShipCity = rs.getString(11);
                String ShipRegion = rs.getString(12);
                String ShipPostalCode = rs.getString(13);
                String ShipCountry = rs.getString(14);

                vector.add(new Orders(OrderID, ID, EmployeeID, OrderDate, RequireDate, ShippedDate,
                        ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion,
                        ShipPostalCode, ShipCountry));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public Orders searchOrderByOrderID(String OrderID1) {
        Vector<Orders> vector = new Vector<>();
        String sql = "select * from Orders where OrderID='" + OrderID1 + "'";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String ID = rs.getString(2);
                int EmployeeID = rs.getInt(3);
                String OrderDate = rs.getString(4);
                String RequireDate = rs.getString(5);
                String ShippedDate = rs.getString(6);
                int ShipVia = rs.getInt(7);
                double Freight = rs.getDouble(8);
                String ShipName = rs.getString(9);
                String ShipAddress = rs.getString(10);
                String ShipCity = rs.getString(11);
                String ShipRegion = rs.getString(12);
                String ShipPostalCode = rs.getString(13);
                String ShipCountry = rs.getString(14);
                String status = rs.getString(15);
                
                return new Orders(OrderID, ID, EmployeeID, OrderDate, RequireDate, ShippedDate,
                        ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion,
                        ShipPostalCode, ShipCountry, status);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int updateOrdersStatus(String id, String status) {
        int n = 0;
        String sql = "update Orders set status = ? where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, status);
            pre.setString(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public static void main(String[] args) {
        DAOOrders dao = new DAOOrders();

        Vector<Orders> vec = dao.searchOrderByCustomerID("VINET");

        for (Orders pro : vec) {
            System.out.println(pro);
        }
    }

}
