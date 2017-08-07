/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.example;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author miolivc
 */
@Entity
@Table
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(length = 50)
    private String street;
    private int number;
    
    @Column(length = 50)
    private String neighborhood;
    
    @Column(length = 50, nullable = false)
    private String city;

    public Address() {
    }

    private Address(String street, int number, String neighborhood, String city) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public static Address of(String street, int number, String neighborhood, String city) {
        return new Address(street, number, neighborhood, city);
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
}
