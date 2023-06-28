/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.MainApp;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author KIMBERLET EPELLE
 */
class FXMLloader {
    private Pane view;
    
public Pane getPage(String fileName){
    try {
        URL fileURL =MainApp.class.getResource("/fxml/"+ fileName+".fxml");
        if(fileURL ==null){
            throw new java.io.FileNotFoundException("FXML file can't be found");
    
        }
        view=new FXMLLoader().load(fileURL);
      
    }
    catch(Exception e){
        System.out.println("No page "+fileName +" please check FXMLloader.");
    }
return view;
}
     
}

