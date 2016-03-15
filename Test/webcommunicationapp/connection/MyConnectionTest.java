/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunicationapp.connection;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webcommunicationapp.model.Publicacion;

/**
 *
 * @author Guido Cruz
 */
public class MyConnectionTest {
    
    public MyConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class MyConnection.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MyConnection expResult = null;
        MyConnection result = MyConnection.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class MyConnection.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String ussername = "";
        String password = "";
        MyConnection instance = new MyConnection();
        Session expResult = null;
        Session result = instance.login(ussername, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class MyConnection.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String name = "";
        String lastName = "";
        String email = "";
        String usserName = "";
        String password = "";
        MyConnection instance = new MyConnection();
        instance.registerUser(name, lastName, email, usserName, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarAviso method, of class MyConnection.
     */
    @Test
    public void testGuardarAviso() {
        System.out.println("guardarAviso");
        String titulo = "";
        String aviso = "";
        MyConnection instance = new MyConnection();
        instance.guardarAviso(titulo, aviso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarComentario method, of class MyConnection.
     */
    @Test
    public void testGuardarComentario() {
        System.out.println("guardarComentario");
        String comentario = "";
        MyConnection instance = new MyConnection();
        instance.guardarComentario(comentario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAvisos method, of class MyConnection.
     */
    @Test
    public void testObtenerAvisos() {
        System.out.println("obtenerAvisos");
        MyConnection instance = new MyConnection();
        List<Publicacion> expResult = null;
        List<Publicacion> result = instance.obtenerAvisos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
