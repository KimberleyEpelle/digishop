/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.EmployeeDAO;
import hu.unideb.inf.JpaEmployeeDAO;
import hu.unideb.inf.model.Employee;
import hu.unideb.inf.model.Employee.RankType;
import hu.unideb.inf.model.Login_User;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;
import org.h2.engine.User;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author KIMBERLET EPELLE
 */
public class AddEmployeeController implements Initializable  {
    ObservableList klist= FXCollections.observableArrayList();
    ObservableList statusList= FXCollections.observableArrayList();
    private void loadData(){
    klist.removeAll(klist);
    RankType a=RankType.Admin;
    RankType b=RankType.Cashier;
    String c= "Single";
    String d= "Married";
    String e= "Complicated";
    klist.addAll(a,b);
    statusList.addAll(c,d,e);
    mstatus.getItems().addAll(statusList);
    rank.getItems().addAll(klist);
    }
    
      @FXML
    private TextField name;

    @FXML
    private TextField addr;

    @FXML
    private TextField city;

    @FXML
    private TextField tel;

    @FXML
    private TextField mail;

    @FXML
    private DatePicker dob;

    @FXML
    private ComboBox<String> mstatus;

    @FXML
    private RadioButton m;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton f;

    @FXML
    private RadioButton o;

    @FXML
    private ComboBox<RankType> rank;

    @FXML
    private TextField sname;
    
    
    @FXML
    void save(ActionEvent event) throws Exception {
        Date current =new Date();
        Employee red=new Employee();
        red.setName(name.getText());
        red.setSurname(sname.getText());
        red.setCity(city.getText());
        red.setAddress(addr.getText());
        red.setEmploymentDate(current);
        if(f.isSelected()){
        red.setGender(f.getText());
        }else 
        if(m.isSelected()){
        red.setGender(m.getText());
        }
        else{red.setGender(o.getText());
        }
        red.setEmail(mail.getText());
        red.setPosition(rank.getValue());
        
        
        red.setDob(dob.getValue().toString());
        red.setStatus(mstatus.getValue());
        
        try (EmployeeDAO aDAO= new JpaEmployeeDAO()){
         aDAO.saveEmployee(red);
         String u1;
         String u2;
            u1 = name.getText().substring(0, 3);
           u2= sname.getText().substring(0, 2);
             Login_User dew =new Login_User();
             dew.setName(u1+u2);
             dew.setPassword(rank.getValue().toString());
             dew.setEmployee(red);
                 JFrame frame = new JFrame("frame");

             
        
             try {
 ((JpaEmployeeDAO)aDAO).saveUser(dew);
 JOptionPane.showMessageDialog(frame,"employee has  been created ");
}
catch(Exception e) {
  JOptionPane.showMessageDialog(frame,e+"employees has not been created cauz");
}
             System.out.println(u1+u2+"---------------------------------------------------------------------------------------------------");
         }
        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        // TODO
    } 
    
}


