/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author KIMBERLET EPELLE
 */
@Entity
@Table(name = "sales")
public class Sales implements  Serializable {

    @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
@Column(name = "amount_sold")
    private Integer numberSold;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private AddProducts products;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(Integer numberSold) {
        this.numberSold = numberSold;
    }

    public AddProducts getProducts() {
        return products;
    }

    public void setProducts(AddProducts products) {
        this.products = products;
    }

    public Sales() {
    }

    @Override
    public String toString() {
        return "Sales{" + "id=" + id + ", numberSold=" + numberSold + ", products=" + products + '}';
    }

    
    
    
}
