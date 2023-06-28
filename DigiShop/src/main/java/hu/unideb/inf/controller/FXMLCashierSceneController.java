package hu.unideb.inf.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.unideb.inf.JPAproductDAO;
import hu.unideb.inf.ProductDAO;
import hu.unideb.inf.model.AddProducts;
import hu.unideb.inf.model.Sales;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author KIMBERLET EPELLE
 */
public class FXMLCashierSceneController implements Initializable {
    
     public void billheader(){
       receipt.setText("====================================================="+"\n"
               + "DIGISHOP"+"\n"
               + "========================================================="+"\n"+
                "Product Name               Price"+"\n");
        }
     public void billfooter(){
     
     
     }
    
    @FXML
    private TextArea receipt;
    
    @FXML
    private TextField pdname;

    @FXML
    private Spinner<Integer> counter;

    @FXML
    private TextField total;
    
    @FXML
    private TextField pdPrice;

    @FXML
    private TableView<AddProducts> purchasetable;

    @FXML
    private TableColumn<AddProducts, Integer> pid;

    @FXML
    private TableColumn<AddProducts, String> pname;

    @FXML
    private TableColumn<AddProducts, Integer> qdemand;

    
        @FXML
    private TextField pidtext;
    
    @FXML
    private TableColumn<AddProducts, Double> pricedemand;
double sum=0;
int N=0;
 ObservableList<AddProducts> data =FXCollections.observableArrayList();

    @FXML
    void addbtn(ActionEvent event) throws Exception{
        
        
try (ProductDAO aDAO= new JPAproductDAO()){
        List<AddProducts> aList =aDAO.getProducts();
           for (AddProducts prod: aList ){
               if(prod.getName().equalsIgnoreCase(pdname.getText())){
                  pdPrice.setText(String.valueOf(prod.getPrice()));
                int re=prod.getQuantity();
                   int a=counter.getValue();
                   double d=prod.getPrice()*a;
                 prod.setPrice(d);
                 prod.setQuantity(a);
                   
               pid.setCellValueFactory(new PropertyValueFactory<>("id"));
               pname.setCellValueFactory(new PropertyValueFactory<>("name"));
              pricedemand.setCellValueFactory(new PropertyValueFactory<>("price"));
              qdemand.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
               data.add(prod);
               purchasetable.getItems().add(prod);
               sum=sum+d;
               total.setText(String.valueOf(sum));
               receipt.setText(receipt.getText()+prod.getName()+"\t\t\t"
                       +String.valueOf(prod.getPrice())+"\n");
              
                   System.out.println(re);
           
                break;
               }
               
            }
           pdname.setText("");
           pidtext.setText("");
           pdPrice.setText("");
           
          
    }
    }

    @FXML
    void searchbtn(ActionEvent event) throws Exception {
    boolean found = false;
    try (ProductDAO aDAO= new JPAproductDAO()){
        List<AddProducts> aList =aDAO.getProducts();
        Long num;
        if(pidtext.getText().isEmpty()){
        num=null;
        }else{
        num=Long.parseLong(pidtext.getText());
        }
           for (AddProducts prod: aList ){
       if((prod.getId().equals(num))||(prod.getName().equalsIgnoreCase(pdname.getText()))==true){
                   JOptionPane.showMessageDialog(null, "Number of products available: "+prod.getQuantity());
                   pdPrice.setText(String.valueOf(prod.getPrice()));
                   N=prod.getQuantity();
                   pdname.setText(prod.getName());
                   pidtext.setText(prod.getId().toString());

SpinnerValueFactory<Integer> countervalue=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, N, 1);
this.counter.setValueFactory(countervalue);
SpinnerValueFactory.IntegerSpinnerValueFactory intFactory =
        (SpinnerValueFactory.IntegerSpinnerValueFactory) counter.getValueFactory();
int imin = intFactory.getMin(); // 0
int imax = intFactory.getMax(); // 10
int istep = intFactory.getAmountToStepBy();
    System.out.println(imax);
            found=true;
            break;
            }
    }
           
    }
    if(found==false){
    JOptionPane.showMessageDialog(null, "No product available");
    }
    }
    
    
    @FXML
    void printreceipt(ActionEvent event) throws Exception{
        Date cur=new Date();int sold=0;
        int input=  JOptionPane.showConfirmDialog(null, "Would you like to continue?");
      if(input==0){
        try (ProductDAO aDAO= new JPAproductDAO()) {
                List<AddProducts> aList =aDAO.getProducts();
                for (AddProducts prod: aList ){
                    for(AddProducts dd: data){
                     if(prod.getId().equals(dd.getId())) {
                            int k=prod.getQuantity()-dd.getQuantity();
                            prod.setQuantity(k) ;
                           sold=dd.getQuantity();
                           prod.getSale().setNumberSold(sold+prod.getSale().getNumberSold());
                           aDAO.updateProduct(prod);
                           
                     }
               }
                    } 
              
        }
        
receipt.setText(receipt.getText()+"========================="+"\n"+
        "Total:"+"\t\t\t"+total.getText()+"\n"+"========================="+"\n"+cur.toString());
         try {
             print(receipt.getText());
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FXMLCashierSceneController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
      else if(input==1){
      
      }
      else{
      
      }
    }
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       billheader();
        // TODO
    }    
    public static void print(String n) throws FileNotFoundException {
      
        String k= System.getProperty("user.home");
        PrintWriter pw =new PrintWriter(new File(k,"/Desktop/receipt.txt"));
        pw.println(n);
        pw.close();
      
        
    }

}