/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.simple.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class PlayersTest {
    
    public PlayersTest() {
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
     * Test of getCordinates method, of class Players.
     */
    @Test
    public void testGetCordinates() {
        System.out.println("getCordinates");
        int score = 0;
        int x = 0;
        int y = 0;
        Players instance = new Players("P1", x, y);
        JSONArray result_expected = new JSONArray();
        result_expected.add("P1");
        result_expected.add(0);
        result_expected.add(0);
        result_expected.add(0);
        JSONArray result = instance.getCordinates(score, x, y);
        JSONArray expected = new JSONArray();
        expected.add(result_expected);
        assertEquals(expected, result);
        
    }

    /**
     * Test of keyStrock method, of class Players.
     */
    @Test
    public void testKeyStrock() {
        System.out.println("keyStrock");
        int key = 39;
        int width = 44;
        int height = 44;
        Players instance = new Players("P1", 0, 0);
        instance.keyStrock(key, width, height);
        
        int expected =1;
        int result =instance.x;
        assertEquals(expected, result);
    }
    
   
    /**
     * Test of getmarks method, of class Players.
     */
    @Test
    public void testGetmarks() {
        System.out.println("getmarks");
        Players instance = new Players("P1", 0, 0);
        int expResult = instance.playerMarks;
        System.out.println(expResult);
    }
    
}
