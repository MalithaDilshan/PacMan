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
public class PlayGroundTest {
    
    public PlayGroundTest() {
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
     * Test of addNewPlayer method, of class PlayGround.
     */
    @Test
    public void testAddNewPlayer() {
        System.out.println("addNewPlayer");
        int id = 0;
        
        int width=44;
        int height=44;
        Players player = new Players("P1",0 , 0);
        PlayGround instance = new PlayGround(width, height);
        instance.addNewPlayer(id, player);
        
        int expected_result=1;
        int result = instance.numberOfPlayers;
        assertEquals(expected_result, result);
       
    }

    /**
     * Test of playerMosion method, of class PlayGround.
     */
    @Test
    public void testPlayerMosion() {
        System.out.println("playerMosion");
        int key_value = 39;
        int width=44;
        int height=44;
        Players current_player = new Players("P1",0,0);
        PlayGround instance = new PlayGround(width,height);
        instance.playerMosion(key_value, current_player);
        System.out.println(instance.isCollide);
       
    }

    /**
     * Test of eatDots method, of class PlayGround.
     */
    @Test
    public void testEatDots() {
        System.out.println("eatDots");
        Players current = new Players("P1", 0, 0);
        
        int width=44;
        int height=44;
        PlayGround instance = new PlayGround(width,height);
        instance.eatDots(current);
        System.out.println(instance.isAte);
        
    }

    /**
     * Test of getDotCordinates method, of class PlayGround.
     */
    @Test
    public void testGetDotCordinates() {
        System.out.println("getDotCordinates");
        int width=44;
        int height=44;
        PlayGround instance = new PlayGround(width, height);
        JSONArray expResult = new JSONArray();
        expResult=instance.getDotCordinates();
        System.out.println(expResult);
    
    }
    
}
