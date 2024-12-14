/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import java.awt.image.BufferedImage;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @file ContattoTest.java
 * @brief Questa classe contiene i test dei metodi della classe contatto
 *
 * @author Antonio
 */
public class ContattoTest {
    
    static Contatto c = new Contatto(
                new SimpleStringProperty(""),new SimpleStringProperty(""), new SimpleStringProperty(""),
                new SimpleStringProperty(""), new SimpleStringProperty(""), new SimpleStringProperty(""),
                new SimpleStringProperty(""), new SimpleStringProperty(""), "", "", "", "", "", "", "", ""
        );

    public ContattoTest() {
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
     * @brief Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        int risultati;
        
        Contatto c1 = new Contatto(
                new SimpleStringProperty(""),new SimpleStringProperty(""), new SimpleStringProperty(""),
                new SimpleStringProperty(""), new SimpleStringProperty(""), new SimpleStringProperty(""),
                new SimpleStringProperty(""), new SimpleStringProperty(""), "", "", "", "", "", "", "", ""
        );
        
        c.setNome("nomeUguale");
        c1.setNome("nomeUguale");
        
        risultati = c.compareTo(c1);
        
        if(risultati != 0)
            fail("il caso in cui c è uguale a c1 non funziona");
        
        c.setNome("123");
        c1.setNome("12345");
        
        risultati = c.compareTo(c1);
        
        if(risultati > 0)
            fail("Il caso in cui c è minore di c1 non funziona");
        
        c.setNome("12345");
        c1.setNome("123");
        
        risultati = c.compareTo(c1);
        
        if(risultati < 0)
            fail("Il caso in cui c è minore di c1 non funziona");
    }

    /**
     * @brief Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        c.setNome("prova");
        String expResult = "prova";
        String result = c.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * @brief Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String stringa = "prova";
        c.setNome(stringa);
        String StringExpected = c.getNome();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }

    /**
     * @brief Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        c.setCognome("prova");
        String expResult = "prova";
        String result = c.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * @brief Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        c.setCognome("prova");
        String cognome = "prova";
        assertEquals(c.getCognome(), cognome);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * @brief Test of getNumTel1 method, of class Contatto.
     */
    @Test
    public void testGetNumTel1() {
        System.out.println("getNumTel1");
        c.setNumTel1("prova");
        String expResult = "prova";
        String result = c.getNumTel1();
        assertEquals(expResult, result);
    }

    /**
     * @brief Test of setNumTel1 method, of class Contatto.
     */
    @Test
    public void testSetNumTel1() {
        System.out.println("setNumTel1");
        String stringa = "prova";
        c.setNumTel1(stringa);
        String StringExpected = c.getNumTel1();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }

    /**
     * @brief Test of getNumTel2 method, of class Contatto.
     */
    @Test
    public void testGetNumTel2() {
        System.out.println("getNumTel2");
        c.setNumTel2("prova");
        String expResult = "prova";
        String result = c.getNumTel2();
        assertEquals(expResult, result);
    }

    /**
     * @brief Test of setNumTel2 method, of class Contatto.
     */
    @Test
    public void testSetNumTel2() {
        System.out.println("setNumTel2");
        String stringa = "prova";
        c.setNumTel2(stringa);
        String StringExpected = c.getNumTel2();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }

    /**
     * @brief Test of getNumTel3 method, of class Contatto.
     */
    @Test
    public void testGetNumTel3() {
        System.out.println("getNumTel3");
        c.setNumTel3("prova");
        String expResult = "prova";
        String result = c.getNumTel3();
        assertEquals(expResult, result);
    }

    /**
     * @brief Test of setNumTel3 method, of class Contatto.
     */
    @Test
    public void testSetNumTel3() {
        System.out.println("setNumTel3");
        String stringa = "prova";
        c.setNumTel3(stringa);
        String StringExpected = c.getNumTel3();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }

    /**
     * @brief Test of getEmail1 method, of class Contatto.
     */
    @Test
    public void testGetEmail1() {
        System.out.println("getEmail1");
        c.setEmail1("prova");
        String expResult = "prova";
        String result = c.getEmail1();
        assertEquals(expResult, result);
    }

    /**
     * @brief Test of setEmail1 method, of class Contatto.
     */
    @Test
    public void testSetEmail1() {
        System.out.println("setEmail1");
        String stringa = "prova";
        c.setEmail1(stringa);
        String StringExpected = c.getEmail1();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }

    /**
     * @brief Test of getEmail2 method, of class Contatto.
     */
    @Test
    public void testGetEmail2() {
        System.out.println("getEmail2");
        c.setEmail1("prova");
        String expResult = "prova";
        String result = c.getEmail1();
        assertEquals(expResult, result);
    }

    /**
     * @brief Test of setEmail2 method, of class Contatto.
     */
    @Test
    public void testSetEmail2() {
        System.out.println("setEmail2");
        String stringa = "prova";
        c.setEmail2(stringa);
        String StringExpected = c.getEmail2();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }

    /**
     * @brief Test of getEmail3 method, of class Contatto.
     */
    @Test
    public void testGetEmail3() {
        System.out.println("getEmail3");
        c.setEmail1("prova");
        String expResult = "prova";
        String result = c.getEmail1();
        assertEquals(expResult, result);
    }

    /**
     * @brief Test of setEmail3 method, of class Contatto.
     */
    @Test
    public void testSetEmail3() {
        System.out.println("setEmail3");
        String stringa = "prova";
        c.setEmail3(stringa);
        String StringExpected = c.getEmail3();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(StringExpected, stringa);
    }
    
}
