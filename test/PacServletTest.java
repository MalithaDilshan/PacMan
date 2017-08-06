/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Malitha Dilshan
 */
public class PacServletTest {
    
    public PacServletTest() {
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
     * Test of init method, of class PacServlet.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        PacServlet instance = new PacServlet();
        instance.init();
        System.out.println(instance.isIntialize);
    }

    /**
     * Test of doPost method, of class PacServlet.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        PacServlet instance = new PacServlet();
        //int value = Integer.parseInt(request.getParameter("keypress"));
        
  

        //SassertEquals("text/html", response.getContentType());
        System.out.println(response);
//        instance.doPost(request, response);
       
    }

    /**
     * Test of doGet method, of class PacServlet.
     */
   /* @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        PacServlet instance = new PacServlet();
        instance.doGet(request, response);
       
    }*/

    /**
     * Test of destroy method, of class PacServlet.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        PacServlet instance = new PacServlet();
        instance.destroy();
        System.out.println("interrupt occor");
    }
    
}
