/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KIMBERLET EPELLE
 */
public class AdminPageController implements Initializable {
    
    @FXML
    private BorderPane MainPane;

    @FXML
    private Label adminname;
    
  
    @FXML
    void dashview(ActionEvent event) throws IOException {

    }
  
    @FXML
    void goBack(ActionEvent event) throws IOException {
    System.out.println("You clicked me!");
    FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/LoginPage.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.setTitle("LoginPage");
    stage.show();
    
    }
  
    @FXML
    void modcashier(ActionEvent event) {
    System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("addcashier");
    MainPane.setCenter(view);
   
    }

    @FXML
    void modprod(ActionEvent event) {
    System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("addproduct");
    MainPane.setCenter(view);
    }

    @FXML
    void viewcashier(ActionEvent event) {
    System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("viewCashiers");
    MainPane.setCenter(view);
    }

    @FXML
    void viewprod(ActionEvent event) {
    
     System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("viewProducts");
    MainPane.setCenter(view);
    }
    String sendname;
     @FXML
    void viewprofile(ActionEvent event) throws IOException {
 FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/Profile.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       MainPane.setCenter(loader.load());
       hu.unideb.inf.controller.ProfileController pcc = loader.getController();
       pcc.sname(sendname);
    stage.setTitle("LoginPage");
    stage.show();
    }
    @FXML
    void modcategory(ActionEvent event) {
    System.out.println("You clicked me!");
    }
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
      //  adminname.setText();
        // TODO
    }    

         public void show(String nme){
    adminname.setText("Welcome, "+nme);
    sendname=nme;
    }
    
}

