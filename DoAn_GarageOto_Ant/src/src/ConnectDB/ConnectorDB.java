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

/**
 *
 * @author WINDOWS 10
 */
public class ConnectorDB {
    private static final String username = "root";
    private static final String password = "duc2112002";
    private static final String dataConn = "jdbc:mysql://localhost:3306/database_garage_oto";
    private static Connection sqlConn = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    public static ResultSet executeQueryConnectorDB(String query){
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
    public static void executeUpdateQueryConnectorDB(String query){
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
}
