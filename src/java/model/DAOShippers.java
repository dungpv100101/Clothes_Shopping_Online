/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Shippers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DAOShippers extends ConnectDB {

    public int addShippers(Shippers shp) {
        int n = 0;
        String sql = "insert into Shippers(CompanyName,Phone) values (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, shp.getCompanyName());
            pre.setString(2, shp.getPhone());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateShippers(Shippers shp) {
        int n = 0;
        String sql = "update Shippers set CompanyName=?,Phone=? where ShipperID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, shp.getCompanyName());
            pre.setString(2, shp.getPhone());
            pre.setInt(3, shp.getShipperID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int deletebyID(int ShipperID) {
        int n = 0;
        String sql = "delete from Shippers where ShipperID=" + ShipperID;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Shippers> listAllShippers() {
        Vector<Shippers> vector = new Vector<>();
        String sql = "select * from Shippers";
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int ShipperID = rs.getInt(1);
                String CompanyName = rs.getString(2);
                String Phone = rs.getString(3);

                vector.add(new Shippers(ShipperID, CompanyName, Phone));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOShippers dao = new DAOShippers();

    }
}
