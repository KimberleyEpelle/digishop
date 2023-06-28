/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class adminMainController implements Initializable {
       @FXML
    private BorderPane MainPane;
       
    @FXML
    void modCashiers(ActionEvent event) {
System.out.println("You clicked me!");
        FXMLloader object =new FXMLloader();
        Pane view = object.getPage("addcashier");
        MainPane.setCenter(view);
    }

    @FXML
    void modprod(ActionEvent event) {
    System.out.println("You clicked me!");
    }

    @FXML
    void viewCashiers(ActionEvent event) {
    System.out.println("You clicked me!");
    }

    @FXML
    void viewprod(ActionEvent event) {
System.out.println("You clicked me!");
    }
    
        @FXML
    void tt(ActionEvent event) {
System.out.println("You clicked me!");
    }
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
}
