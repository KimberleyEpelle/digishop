/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.JpaUserDAO;
import hu.unideb.inf.UserDAO;
import hu.unideb.inf.model.Login_User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KIMBERLET EPELLE
 */
public class ProfileController implements Initializable {
    
    
   @FXML
    private TextField idtext;

    @FXML
    private TextField city;

    @FXML
    private TextField gender;

    @FXML
    private TextField date;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField pwd;

    @FXML
    private TextField username;

    @FXML
    void exit(ActionEvent event) {

    }
   int k;

    @FXML
    void save(ActionEvent event)throws Exception {
      UserDAO aDAO= new JpaUserDAO(); 
          List<Login_User> aList =aDAO.getUser();
           boolean found = false;
           for (Login_User user: aList ){
            if(k==user.getId()){
                System.out.println(user.getEmployee().getId());
            user.setName(username.getText());
            user.setPassword(pwd.getText());
            aDAO.updateUser(user);
            if(user.getPassword().equalsIgnoreCase("admin")){
             FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/admin2.fxml"));
                    
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                    hu.unideb.inf.controller.AdminPageController admincontrol =loader.getController();
                    admincontrol.show(username.getText());
                    stage.setScene(scene);
                    stage.setTitle("Admin Page");
                    stage.show();
                    found =true;
                    break;
                    }
                   
           else  if(user.getEmployee().getPosition().toString().equalsIgnoreCase("admin")){
                   JOptionPane.showMessageDialog(null,"Login Successful");
                   FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/admin2.fxml"));
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(loader.load());
                    hu.unideb.inf.controller.AdminPageController admincontrol =loader.getController();
                    admincontrol.show(username.getText());
                    stage.setScene(scene);
                    stage.setTitle("Admin Page");
                    stage.show();}else{
           FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/fxml/Cashierdashboard.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                    hu.unideb.inf.controller.CashierdashboardController cashcontrol =loader.getController();
                    cashcontrol.show(username.getText());
                    stage.setScene(scene);
                    stage.setTitle("Cashier Page");
                    stage.show();
            }
                    
            
            }
            
      }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
       
        // TODO
    }    
    public void sname(String nme){
    username.setText(nme);
    UserDAO aDAO= new JpaUserDAO();
       List<Login_User> aList =aDAO.getUser();
           boolean found = false;
            for (Login_User user: aList ){
            if(username.getText().equalsIgnoreCase(user.getName())){
            pwd.setText(user.getPassword());
            idtext.setText(Long.toString(user.getEmployee().getId()));
            city.setText(user.getEmployee().getCity());
            gender.setText(user.getEmployee().getGender());
            date.setText(user.getEmployee().getEmploymentDate().toString());
            email.setText(user.getEmployee().getEmail());
            name.setText(user.getEmployee().getSurname()+" "+user.getEmployee().getName());
            k=user.getId();
            }
            }
    }
}
