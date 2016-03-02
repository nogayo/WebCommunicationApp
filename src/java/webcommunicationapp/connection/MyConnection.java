/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunicationapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guido Cruz
 */
public class MyConnection {

    private static final MyConnection instance = new MyConnection();

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String CONNECT_STRING = "jdbc:postgresql://localhost:5432/WebCommunicationApp";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String TRUE = "t";

    protected Connection connection;

    protected MyConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECT_STRING, USER, PASSWORD);
            System.out.println("Succefully Connection\n\n");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in  Connection\n\n");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static MyConnection getInstance() {
        return instance;
    }

    public boolean login(String ussername, String password) {
        boolean succefully = false;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement
                    .executeQuery(String.format("SELECT verify_login('%s','%s')", ussername, password));
            if (result.next() && result.getString(1).equals(TRUE)) {
                succefully = true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return succefully;
    }
}
