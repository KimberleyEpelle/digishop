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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author KIMBERLET EPELLE
 */
public class ViewProductsController implements Initializable {
    
    
    @FXML
    private TableView<AddProducts> prodview;

    @FXML
    private TableColumn<AddProducts, Integer> pid;

    @FXML
    private TableColumn<AddProducts, String> pname;

    @FXML
    private TableColumn<AddProducts, String> pdescription;

    @FXML
    private TableColumn<AddProducts, Double> pPrice;

    @FXML
    private TableColumn<AddProducts, Integer> pquantity;
/*
    @FXML
    private TableColumn<AddProducts, String> pcategory;*/

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProductDAO aDAO= new JPAproductDAO();
         ObservableList<AddProducts> data =FXCollections.observableArrayList();
         List<AddProducts> aList =aDAO.getProducts();
           for (AddProducts prod: aList ){
               data.add(prod);
              pid.setCellValueFactory(new PropertyValueFactory<>("id"));
                pname.setCellValueFactory(new PropertyValueFactory<>("name"));
                pPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
                pquantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
               pdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
             prodview.setItems(data);
           }
    }    
    
}
