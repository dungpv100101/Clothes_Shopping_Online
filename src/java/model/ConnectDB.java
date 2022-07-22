package model;

import entity.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {

    public Connection conn = null;

    public ConnectDB(String URL, String userName, String password) {
        //URL: connection string: address, port, database of server
        try {
            //Call Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connection
            conn = DriverManager.getConnection(URL, userName, password);
            
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ConnectDB() {
        this("jdbc:sqlserver://localhost:1433;databaseName=SE1613", "sa", "123456");
    }
    
    public ResultSet getData(String sql) {
        ResultSet rs = null;
        
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            
            rs = state.executeQuery(sql);                     
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return rs;
    }
    
    public static void main(String[] args) {
        new ConnectDB();
    }
}
