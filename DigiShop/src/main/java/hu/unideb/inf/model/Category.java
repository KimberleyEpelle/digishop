/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author KIMBERLET EPELLE
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "cat_name",nullable=false,unique = true)
    private String catName;

    @OneToMany
 @JoinColumn(name = "category_id")
 private Set<AddProducts> products = new HashSet<>();

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    public Set<AddProducts> getProducts() {
        return products;
    }

    public void setProducts(Set<AddProducts> products) {
        this.products = products;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "category{" + "id=" + id + ", catName=" + catName + ", products=" + products + '}';
    }
    
    
}
