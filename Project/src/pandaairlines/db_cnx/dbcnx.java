/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.db_cnx;

/**
 *
 * @author ky94
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbcnx {

    static public Connection conn = null;
    private static String url;
    private static String driver;
    private static String user;
    private static String password;

    static private void connecter() {
        url = "jdbc:mysql://localhost:3306/formationdatabase";
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            System.out.println("erreur driver");
            System.out.println(e.getMessage());
        }

        try {
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    static public void deconnecter() {
        try {
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void connect(){
        if(conn==null) connecter();
    }
    
}
