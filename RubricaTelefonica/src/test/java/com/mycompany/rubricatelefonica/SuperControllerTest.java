/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Giovanni
 */
public class SuperControllerTest {
    
    public SuperControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addElemento method, of class SuperController.
     */
    @Test
    public void testAddElemento() {
        System.out.println("addElemento");
        Contatto c = new Contatto(
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        "prova","prova","prova","prova","prova","prova","prova","prova"
);
        SuperController.addElemento(c);
        
        if(SuperController.lista.get(0) == null){
            fail("Lista non riempita");
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rimElement method, of class SuperController.
     */
    @Test
    public void testRimElement() {
        System.out.println("rimElement");
        Contatto c = new Contatto(
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        new SimpleStringProperty("prova"),
        "prova","prova","prova","prova","prova","prova","prova","prova"
);
        SuperController.addElemento(c);
        SuperController.rimElement(SuperController.lista);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if(SuperController.lista.isEmpty() == false)
            fail("La lista contiene ancora l'elemento inserito");
    }
    
}
