/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.jpa.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author miolivc
 */
public class Application {
    
    public static void main(String[] args) {
        
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("jpa-example")
                .createEntityManager();
        
        User user = User.of("Michelle Oliveira", "miolivc", "miolivc@outlook.com", "miolivc");
        
        Address address = Address.of("Seven Street", 21, "The litle Frog", "Fallen Village");
        PublishingCompany company = PublishingCompany.of("Company of 7 street", address);
        
        Book book = Book.of(1234567890, "A book about a book", "A book about a book anywhere", "2a, 2017");
        company.getBooks().add(book);
        
        EntityTransaction transaction = entityManager.getTransaction();
        
        transaction.begin();
        entityManager.persist(user);
        entityManager.persist(book);
        entityManager.persist(address);
        entityManager.persist(company);
        transaction.commit();
        
    }
    
}
