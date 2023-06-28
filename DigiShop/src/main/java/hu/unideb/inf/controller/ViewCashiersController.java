/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.EmployeeDAO;
import hu.unideb.inf.JPAproductDAO;
import hu.unideb.inf.JpaEmployeeDAO;
import hu.unideb.inf.ProductDAO;
import hu.unideb.inf.model.AddProducts;
import hu.unideb.inf.model.Employee;
import java.net.URL;
import java.util.Date;
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
public class ViewCashiersController implements Initializable {

    @FXML
    private TableView<Employee> cashview;

    @FXML
    private TableColumn<Employee, Long> empid;

    @FXML
    private TableColumn<Employee, String> empname;

    @FXML
    private TableColumn<Employee, String> empsname;

    @FXML
    private TableColumn<Employee, Employee.RankType> emprank;

    @FXML
    private TableColumn<Employee, String> empgender;

    @FXML
    private TableColumn<Employee, String> empcity;
    @FXML
    private TableColumn<Employee, Date> empdate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EmployeeDAO aDAO= new JpaEmployeeDAO();
         ObservableList<Employee> data =FXCollections.observableArrayList();
         List<Employee> aList =aDAO.getEmployee();
         
           for (Employee emp: aList ){
               data.add(emp);
           empid.setCellValueFactory(new PropertyValueFactory<>("id"));
           empname.setCellValueFactory(new PropertyValueFactory<>("name"));
           empsname.setCellValueFactory(new PropertyValueFactory<>("surname"));
           empcity.setCellValueFactory(new PropertyValueFactory<>("city"));
           empgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
           emprank.setCellValueFactory(new PropertyValueFactory<>("position"));
           empdate.setCellValueFactory(new PropertyValueFactory<>("employmentDate"));
         cashview.setItems(data);
           }
        
        // TODO
    }    
    
}
