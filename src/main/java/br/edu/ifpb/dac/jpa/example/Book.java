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
import javax.persistence.TableGenerator;

/**
 *
 * @author miolivc
 */

@Entity
@Table
@TableGenerator(name = "book_seq",
        table = "jpa_sequences", 
        pkColumnValue = "book_seq")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "book_seq")
    private int id;
    
    @Column(length = 13, unique = true, nullable = false)
    private int ISBN;
    
    @Column(length = 50, nullable = false)
    private String title;
    
    @Column(length = 150, nullable = false)
    private String brief;
    
    @Column(length = 30, nullable = false)
    private String edition;

    public Book() {
    }

    private Book(int ISBN, String title, String brief, String edition) {
        this.ISBN = ISBN;
        this.title = title;
        this.brief = brief;
        this.edition = edition;
    }
    
    public static Book of(int ISBN, String title, String brief, String edition) {
        return new Book(ISBN, title, brief, edition);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
    
}
