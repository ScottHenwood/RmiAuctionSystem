///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package auctionsystem;
//
//import auctionsystem.settings.NetworkSettings;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLWarning;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Scott.Henwood
// */
//public class ItemTest {
//    
//    public ItemTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//
//    /**
//     * Test of setCategory method, of class Item.
//     */
//    @Test
//    public void testSetCategory() {
//        System.out.println("setCategory");
//        String cat = "";
//        Item instance = new Item();
//        instance.setCategory(cat);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getId method, of class Item.
//     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Item instance = new Item();
//        String expResult = "";
//        String result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getName method, of class Item.
//     */
//    @Test
//    public void testGetName() {
//        System.out.println("getName");
//        Item instance = new Item();
//        String expResult = "";
//        String result = instance.getName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCategory method, of class Item.
//     */
//    @Test
//    public void testGetCategory() {
//        System.out.println("getCategory");
//        Item instance = new Item();
//        String expResult = "";
//        String result = instance.getCategory();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of placeBid method, of class Item.
//     */
//    @Test
//    public void testPlaceBid() {
//        System.out.println("placeBid");
//        Bid bid = null;
//        Item instance = new Item();
//        boolean expResult = false;
//        boolean result = instance.placeBid(bid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Item.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Item instance = new Item();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getResult method, of class Item.
//     */
//    @Test
//    public void testGetResult() {
//        System.out.println("getResult");
//        Item instance = new Item();
//        String expResult = "";
//        String result = instance.getResult();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCurrentBidValue method, of class Item.
//     */
//    @Test
//    public void testGetCurrentBidValue() {
//        System.out.println("getCurrentBidValue");
//        Item instance = new Item();
//        float expResult = 0.0F;
//        float result = instance.getCurrentBidValue();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of readItemsFromDatabase method, of class Item.
//     */
//    @Test
//    public void testReadItemsFromDatabase() {
//        System.out.println("readItemsFromDatabase");
//        //HashMap<String, Item> expResult = null;
//        HashMap<String, Item> result = Item.readItemsFromDatabase();
//        for(String key : result.keySet())
//        {
//            System.out.println(result.get(key));
//        }
//        //assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
//    @Test
//    public void testDatabaseConnection()
//    {
//        try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            Connection conn = DriverManager.getConnection(
//                    NetworkSettings.getSettingsClass().getDBConectionString(), "scotthenwood", "access");
//            
//            Statement stmt = conn.createStatement();
//            ResultSet rset = stmt.executeQuery("Select * From Item_tab");
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemTest.class.getName()).log(Level.SEVERE, null, ex);
//            fail("There was an SQL error.");
//        }
//    }
//
//    /**
//     * Test of writeItemToDatabase method, of class Item.
//     */
//    @Test
//    public void testWriteItemToDatabase() throws Exception {
//        System.out.println("writeItemToDatabase");
//        Item item = new Item("11", "Big car", "Car");
//        SQLWarning epected = null;
//        assertEquals(Item.writeItemToDatabase(item), epected);
//        
//    }
//
//    /**
//     * Test of writeUpdateToDatabase method, of class Item.
//     */
//    @Test
//    public void testWriteUpdateToDatabase() {
//        try {
//            System.out.println("writeUpdateToDatabase");
//            Item item = new Item("11", "Small car", "Car");
//            SQLWarning epected = null;
//            Item.writeUpdateToDatabase(item);
//            // TODO review the generated test code and remove the default call to fail.
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemTest.class.getName()).log(Level.SEVERE, null, ex);
//            fail("exception thrown");
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(ItemTest.class.getName()).log(Level.SEVERE, null, ex);
//            fail("exception thrown");
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(ItemTest.class.getName()).log(Level.SEVERE, null, ex);
//            fail("exception thrown");
//        }
//    }
//    
//}
