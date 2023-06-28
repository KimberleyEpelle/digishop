/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author KIMBERLET EPELLE
 */
@Entity
@Table(name="Employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
   
     @Column(nullable = false)
    private String surname;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(nullable = false)
    private String address;
   
    @Column(nullable = false)
    private String email;
   
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String status;
    
    
    private String dob;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date employmentDate;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RankType position;
    
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public RankType getPosition() {
        return position;
    }

    public void setPosition(RankType position) {
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public enum RankType{
   Admin, Cashier;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surname=" + surname 
                + ", gender=" + gender + ", address=" 
                + address + ", email=" + email + ", city=" 
                + city + ", status=" + status + ", dob=" 
                + dob + ", employmentDate=" 
                + employmentDate + ", position=" + position + '}';
    }

    
    
}
