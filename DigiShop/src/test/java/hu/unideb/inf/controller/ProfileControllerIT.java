/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class ProfileControllerIT {
    
    public ProfileControllerIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of exit method, of class ProfileController.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        ActionEvent event =null ;
        ProfileController instance = new ProfileController();
        instance.exit(event);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class ProfileController.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        ActionEvent event = null;
        ProfileController instance = new ProfileController();
        instance.save(event);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class ProfileController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        ProfileController instance = new ProfileController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sname method, of class ProfileController.
     */
    @Test
    public void testSname() {
        System.out.println("sname");
        String nme = "";
        
        ProfileController instance = new ProfileController();
        instance.sname(nme);
     
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
