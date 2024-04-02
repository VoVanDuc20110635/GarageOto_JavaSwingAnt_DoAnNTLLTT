/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS 10
 */
public class ConnectorDB {
    String username = "root";
    String password = "duc2112002";
    String dataConn = "jdbc:mysql://localhost:3306/database_garage_oto";
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public ResultSet executeQueryConnectorDB(String query){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        }
        catch(Exception ex){
            throw new Error("Loi execute query: " + ex.getMessage());
        }
    }
    public void executeUpdateQueryConnectorDB(String query){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn, username, password);
            pst = sqlConn.prepareStatement(query);
            pst.executeUpdate();
            
        }
        catch(Exception ex){
            throw new Error("Loi update: " + ex.getMessage());
        }
    }
    public void closeConnection(){
        try {
            sqlConn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
