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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author KIMBERLET EPELLE
 */
public class ContactController implements Initializable{
    
    @FXML
    private TextField enquiryName;

    @FXML
    private TextField enquiryEmail;

    @FXML
    private TextArea enquiryMessage;

    @FXML
    void handleEnquirySubmit(ActionEvent event) {

    }
     /**
     * Initializes the controller class.
     * @param url
     * @param rb  */
   @Override
    public void initialize(URL url, ResourceBundle rb)  {
    
    }
    
}
