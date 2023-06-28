/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.JPAproductDAO;
import hu.unideb.inf.ProductDAO;
import hu.unideb.inf.model.AddProducts;
import hu.unideb.inf.model.Sales;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amirs
 */
public class CashierdashboardController implements Initializable {

    @FXML
    private TextField username;
    
    @FXML
    private Button Products;
   
    @FXML
    private BarChart<String, Number> Chart;
      @FXML
    private BorderPane MainPane;
@FXML
    private Label cashname;
    @FXML
    private Pane dash;
    
       @FXML
    private Text fseller;

    @FXML
    private Text sseller;

    @FXML
    private Text tseller;

 String sendname;
    public void show(String nme){
    cashname.setText("Welcome, "+nme);
    sendname=nme;
  }
    
       @FXML
    void Dashboard(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        
    FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/Cashierdashboard.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(loader.load());
    hu.unideb.inf.controller.CashierdashboardController cashcontrol =loader.getController();
                    cashcontrol.show(sendname);
    stage.setScene(scene);
    stage.setTitle("Dashboard");
    stage.show();
    }
      @FXML
    void checkout(ActionEvent event) {
System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("FXMLCashierScene");
    MainPane.setCenter(view);
    }

    @FXML
    void exitbtn(ActionEvent event) throws IOException {
System.out.println("You clicked me!");
    FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/LoginPage.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.setTitle("LoginPage");
    stage.show();
    }
    
     @FXML
    void viewproducts(ActionEvent event) {
 System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("viewProducts");
    MainPane.setCenter(view);
    }

    @FXML
    void viewprofile(ActionEvent event) throws IOException {
 System.out.println("You clicked me!");
    FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/Profile.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       MainPane.setCenter(loader.load());
       hu.unideb.inf.controller.ProfileController pcc = loader.getController();
       pcc.sname(sendname);
    stage.setTitle("Profile page");
    stage.show();
    }
    @FXML 
    void handleButtonAction(ActionEvent event) throws IOException{
     System.out.println("You clicked me!");
   System.out.println("You clicked me!");
    FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/Cashierproductspage.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       MainPane.setCenter(loader.load());
       stage.show();
    }
        @FXML
    void contact(ActionEvent event) {
System.out.println("You clicked me!");
    FXMLloader object =new FXMLloader();
    Pane view = object.getPage("contactus");
    MainPane.setCenter(view);
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb  */
   @Override
    public void initialize(URL url, ResourceBundle rb)  {
    ProductDAO aDAO= new JPAproductDAO();
    List<AddProducts> kList =aDAO.getProducts();
    List<Integer> pList =new ArrayList<>();
    XYChart.Series<String, Number> Series = new XYChart.Series<>();
   
    for(AddProducts prod: kList){
        Series.setName("quantity available");
        Series.getData().add(new XYChart.Data<>(prod.getName(),prod.getSale().getNumberSold()));
    pList.add(prod.getSale().getNumberSold());
    }  
    Collections.sort(pList,Collections.reverseOrder());
       System.out.println(pList);
    Chart.getData().addAll(Series);
    for(AddProducts prod: kList){
        if(prod.getSale().getNumberSold().equals(pList.get(0))){
          fseller.setText("1. "+prod.getName());
        }
        else if(prod.getSale().getNumberSold().equals(pList.get(1))){
          sseller.setText("2. "+prod.getName());
        }
        else if(prod.getSale().getNumberSold().equals(pList.get(2))){
          tseller.setText("3. "+prod.getName());}
    }
    }  
}

 
