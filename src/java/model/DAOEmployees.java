/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Employees;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DAOEmployees extends ConnectDB {

    public int addEmployees(Employees emp) {
        int n = 0;
        String sql = "insert into Employees(LastName,FirstName,Title,TitleOfCourtesy,BirthDate,HireDate,"
                + "Address,City,Region,PostalCode,Country,HomePhone,Extension,Notes,ReportsTo,PhotoPath)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirstName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getBirthDate());
            pre.setString(6, emp.getHireDate());
            pre.setString(7, emp.getAddress());
            pre.setString(8, emp.getCity());
            pre.setString(9, emp.getRegion());
            pre.setString(10, emp.getPostalCode());
            pre.setString(11, emp.getCountry());
            pre.setString(12, emp.getHomePhone());
            pre.setString(13, emp.getExtension());
            pre.setString(14, emp.getNotes());
            pre.setInt(15, emp.getReportsTo());
            pre.setString(16, emp.getPhotoPath());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateEmployees(Employees emp) {
        int n = 0;
        String sql = "update Employees set LastName=?,FirstName=?,Title=?,"
                + "TitleOfCourtesy=?,BirthDate=?,HireDate=?,"
                + "Address=?,City=?,Region=?,PostalCode=?,Country=?,HomePhone=?,"
                + "Extension=?,Notes=?,ReportsTo=?,PhotoPath=?"
                + " where EmployeeID=? ";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirstName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getBirthDate());
            pre.setString(6, emp.getHireDate());
            pre.setString(7, emp.getAddress());
            pre.setString(8, emp.getCity());
            pre.setString(9, emp.getRegion());
            pre.setString(10, emp.getPostalCode());
            pre.setString(11, emp.getCountry());
            pre.setString(12, emp.getHomePhone());
            pre.setString(13, emp.getExtension());
            pre.setString(14, emp.getNotes());
            pre.setInt(15, emp.getReportsTo());
            pre.setString(16, emp.getPhotoPath());
            pre.setInt(17, emp.getEmployeeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deleteByID(int EmployeeID) {
        int n = 0;
        String sql = "delete from Employees where EmployeeID=" + EmployeeID;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<Employees> listAllEmployees() {
        Vector<Employees> vector = new Vector<>();
        String sql = "select * from Employees";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int EmployeeID = rs.getInt(1);
                String LastName = rs.getString(2);
                String FirstName = rs.getString(3);
                String Title = rs.getString(4);
                String TitleOfCourtesy = rs.getString(5);
                String BirthDate = rs.getString(6);
                String HireDate = rs.getString(7);
                String Address = rs.getString(8);
                String City = rs.getString(9);
                String Region = rs.getString(10);
                String PostalCode = rs.getString(11);
                String Country = rs.getString(12);
                String HomePhone = rs.getString(13);
                String Extension = rs.getString(14);
                String Photo = rs.getString(15);
                String Notes = rs.getString(16);
                int ReportsTo = rs.getInt(17);
                String PhotoPath = rs.getString(18);

                vector.add(new Employees(EmployeeID, LastName, FirstName, Title, TitleOfCourtesy,
                        BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone,
                        Extension, Photo, Notes, ReportsTo, PhotoPath));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
    public boolean checkLogin(String username, String password) {
        String sql = "select * from Employees where username='" + username + "' and password='" +password+ "'";

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

    public static void main(String[] args) {
        DAOEmployees dao = new DAOEmployees();

        Vector<Employees> vec = dao.listAllEmployees();

        for (Employees emp : vec) {
            System.out.println(emp);
        }
    }
}
