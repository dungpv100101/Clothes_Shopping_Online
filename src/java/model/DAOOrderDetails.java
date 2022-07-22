/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OrderDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DAOOrderDetails extends ConnectDB {

    public int addOrderDetails(OrderDetails od) {
        int n = 0;
        String sql = "insert into [Order Details] (OrderID,ProductID,UnitPrice,Quantity,Discount) values"
                + "(?,?,?,?,?) ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, od.getOrderID());
            pre.setInt(2, od.getProductID());
            pre.setDouble(3, od.getUnitPrice());
            pre.setInt(4, od.getQuantity());
            pre.setDouble(5, od.getDiscount());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateOrderDetails(OrderDetails od, int oid, int pid) {
        int n = 0;
        String sql = "update [Order Details] set OrderID=?,ProductID=?,UnitPrice=?,Quantity=?,Discount=?"
                + " where (OrderID=? and ProductID=?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, od.getOrderID());
            pre.setInt(2, od.getProductID());
            pre.setDouble(3, od.getUnitPrice());
            pre.setInt(4, od.getQuantity());
            pre.setDouble(5, od.getDiscount());
            pre.setInt(6, oid);
            pre.setInt(7, pid);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteByID(int OrderID) {
        int n = 0;
        String sql = "delete from [Order Details] where OrderID=" + OrderID;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<OrderDetails> listAllOrderDetails() {
        Vector<OrderDetails> vec = new Vector<>();
        String sql = "select * from [Order Details]";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                int ProductID = rs.getInt(2);
                double UnitPrice = rs.getDouble(3);
                int Quantity = rs.getInt(4);
                double Discount = rs.getDouble(5);
                vec.add(new OrderDetails(OrderID, ProductID, UnitPrice, Quantity, Discount));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vec;
    }
    
    public Vector<OrderDetails> listAllOrderDetails(String sql) {
        Vector<OrderDetails> vec = new Vector<>();

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                int ProductID = rs.getInt(2);
                double UnitPrice = rs.getDouble(3);
                int Quantity = rs.getInt(4);
                double Discount = rs.getDouble(5);
                vec.add(new OrderDetails(OrderID, ProductID, UnitPrice, Quantity, Discount));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vec;
    }

    public void displayOrderDetails() {
        String sql = "select \n"
                + "	 * \n"
                + "from Customers\n"
                + "join Orders on Customers.CustomerID = Orders.CustomerID\n"
                + "join [Order Details] on [Order Details].OrderID = Orders.OrderID\n"
                + "join Products on [Order Details].ProductID = Products.ProductID\n"
                + "join Employees on Orders.EmployeeID = Employees.EmployeeID";

        ResultSet rs = getData(sql);

        //System.out.printf("CustomerID /t/t CompanyName /t/t ContactName /t/t ContactTitle /t/t Address /t/t City /t/t Region /t/t PostalCode /t/t Country /t/t Phone /t/t Fax /t/t OrderID /t/t CustomerID /t/t EmployeeID /t/t OrderDate /t/t RequiredDate /t/t ShippedDate /t/t ShipVia /t/t Freight /t/t ShipName /t/t ShipAddress /t/t ShipCity /t/t ShipRegion /t/t ShipPostalCode	ShipCountry /t/t OrderID /t/t ProductID /t/t UnitPrice /t/t Quantity /t/t Discount /t/t ProductID /t/t ProductName /t/t SupplierID /t/t CategoryID /t/t QuantityPerUnit /t/t UnitPrice /t/t UnitsInStock /t/t UnitsOnOrder /t/t ReorderLevel /t/t Discontinued /t/t EmployeeID /t/t LastName /t/t FirstName /t/t Title /t/t TitleOfCourtesy /t/t BirthDate /t/t HireDate /t/t Address /t/t City	Region /t/t PostalCode /t/t Country /t/t HomePhone /t/t Extension /t/t Photo /t/t Notes /t/t ReportsTo /t/t PhotoPath");
        try {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colNumber = rsMeta.getColumnCount();

            for (int i = 1; i <= colNumber; i++) {
                System.out.printf("%-20s", rsMeta.getColumnName(i));
            }
            System.out.println("");
            
            while (rs.next()) {
                for (int i = 1; i <= colNumber; i++) {
                    System.out.printf("%-20.10s", rs.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAOOrderDetails dao = new DAOOrderDetails();

//        Vector<OrderDetails> vec = dao.listAllOrderDetails();
//        
//        for (OrderDetails emp : vec) {
//            System.out.println(emp);
//        }
        dao.displayOrderDetails();
    }
}
