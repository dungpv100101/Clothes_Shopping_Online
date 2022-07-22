/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dung
 */
public class DAOCategories extends ConnectDB {

    public int addCategory(Categories cate) {
        int n = 0;

        String preSql = "insert into Categories(CategoryName,Description)"
                + " values(?,?)";

        try {
            PreparedStatement pre = conn.prepareCall(preSql);

            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());

            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateCategory(Categories cate) {
        int n = 0;
//        String sql = "update Categories set "
//                + "CategoryName='" + cate.getCategoryName() + "',"
//                + "Description='" + cate.getDescription() + "',"
//                + "Picture='" + cate.getPicture() + "'"
//                + " where CategoryID=" + cate.getCategoryID();

        String preSql = "update Categories set CategoryName=?,Description=? where CategoryID=?";

        try {
            PreparedStatement pre = conn.prepareCall(preSql);

            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());
            pre.setInt(3, cate.getCategoryID());

            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int deleteByID(int CategoryID) {
        int n = 0;
        String sql = "delete from Categories where CategoryID=" + CategoryID;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<Categories> listAllCategories(String sql) {
        Vector<Categories> vector = new Vector<>();
        try {
            ResultSet rs = getData(sql);

            while (rs.next()) {
                int CategoryID = Integer.parseInt(rs.getString(1));
                String CategoryName = rs.getString(2);
                String Description = rs.getString(3);
                String Picture = rs.getString(4);
                
                vector.add(new Categories(CategoryID, CategoryName, Description, Picture));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOCategories dao = new DAOCategories();

        int n = dao.updateCategory(new Categories(9, "Huy", "Dang Hoc", "1"));
    }
}
