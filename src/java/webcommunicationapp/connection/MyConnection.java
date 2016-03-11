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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import webcommunicationapp.model.Publicacion;

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
            System.out.println("Successful Connection\n\n");
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

    public Session login(String ussername, String password) {
        Session session = new Session();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement
                    .executeQuery(String.format("SELECT login_successful('%s','%s');", ussername, password));
            if (result.next() && result.getString(1).equals(TRUE)) {
                session.setLoginValue("true");
                session.setUssername(ussername);
            } else {
                session.setLoginValue("false");
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return session;
    }

    public void registerUser(String name, String lastName, String email, String usserName, String password) {
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery(String.format("SELECT register_user('%s','%s','%s','%s','%s');",
                    name, lastName, email, usserName, password));
            System.out.println("Register Successful");
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Register Failed");
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void guardarAviso(String titulo,String aviso){
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery(String.format("INSERT INTO avisos (titulo,aviso) VALUES ('%s','%s');",
                                                  titulo, aviso));
            System.out.println("Successful");
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Failed");
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Publicacion> obtenerAvisos() {
        List<Publicacion> res=new ArrayList<Publicacion>();
         try
          {
         Statement st = connection.createStatement();
         ResultSet resultado = st.executeQuery(String.format("SELECT titulo,aviso FROM avisos"));
         
         while (resultado.next())
         {
             Publicacion p=new Publicacion();
             p.setTitulo(resultado.getString(1));
             p.setAviso(resultado.getString(2));
             res.add(0,p);
             
         }
        }
        catch (SQLException exc)
        {
                System.out.println("Error:"+exc.getMessage());
        } 
         return res;
    }
    
}
