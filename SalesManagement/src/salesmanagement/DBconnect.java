/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmanagement;

import java.sql.*;

public class DBconnect {
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/salesmanagement", "root", "");
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
