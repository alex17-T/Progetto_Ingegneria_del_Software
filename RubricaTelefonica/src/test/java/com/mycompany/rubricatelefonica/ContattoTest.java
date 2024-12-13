/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rubricatelefonica;

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
 *
 * @author Antonio
 */
public class ContattoTest {
    
    public static Contatto c;
    
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        StringProperty nome = new SimpleStringProperty("");
        StringProperty cognome = new SimpleStringProperty("");
        StringProperty numTel1 = new SimpleStringProperty("");
        StringProperty numTel2 = new SimpleStringProperty("");
        StringProperty numTel3 = new SimpleStringProperty("");
        StringProperty email1 = new SimpleStringProperty("");
        StringProperty email2 = new SimpleStringProperty("");
        StringProperty email3 = new SimpleStringProperty("");
        c = new Contatto(nome,cognome,numTel1,numTel2,numTel3,email1,email2,email3);
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
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contatto altroContatto = null;
        Contatto instance = null;
        int expResult = 0;
        int result = instance.compareTo(altroContatto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFotoprofilo method, of class Contatto.
     */
    @Test
    public void testGetFotoprofilo() {
        System.out.println("getFotoprofilo");
        Contatto instance = null;
        Image expResult = null;
        Image result = instance.getFotoprofilo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFotoprofilo method, of class Contatto.
     */
    @Test
    public void testSetFotoprofilo() {
        System.out.println("setFotoprofilo");
        String path = "";
        Contatto instance = null;
        instance.setFotoprofilo(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        c.setNome("prova");
        String expResult = "prova";
        String result = c.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "prova";
        c.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        if(assertEquals()){
            
        }
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Contatto instance = null;
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumTel1 method, of class Contatto.
     */
    @Test
    public void testGetNumTel1() {
        System.out.println("getNumTel1");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getNumTel1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumTel1 method, of class Contatto.
     */
    @Test
    public void testSetNumTel1() {
        System.out.println("setNumTel1");
        String numTel1 = "";
        Contatto instance = null;
        instance.setNumTel1(numTel1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumTel2 method, of class Contatto.
     */
    @Test
    public void testGetNumTel2() {
        System.out.println("getNumTel2");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getNumTel2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumTel2 method, of class Contatto.
     */
    @Test
    public void testSetNumTel2() {
        System.out.println("setNumTel2");
        String numTel2 = "";
        Contatto instance = null;
        instance.setNumTel2(numTel2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumTel3 method, of class Contatto.
     */
    @Test
    public void testGetNumTel3() {
        System.out.println("getNumTel3");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getNumTel3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumTel3 method, of class Contatto.
     */
    @Test
    public void testSetNumTel3() {
        System.out.println("setNumTel3");
        String numTel3 = "";
        Contatto instance = null;
        instance.setNumTel3(numTel3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail1 method, of class Contatto.
     */
    @Test
    public void testGetEmail1() {
        System.out.println("getEmail1");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getEmail1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail1 method, of class Contatto.
     */
    @Test
    public void testSetEmail1() {
        System.out.println("setEmail1");
        String email1 = "";
        Contatto instance = null;
        instance.setEmail1(email1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail2 method, of class Contatto.
     */
    @Test
    public void testGetEmail2() {
        System.out.println("getEmail2");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getEmail2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail2 method, of class Contatto.
     */
    @Test
    public void testSetEmail2() {
        System.out.println("setEmail2");
        String email2 = "";
        Contatto instance = null;
        instance.setEmail2(email2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail3 method, of class Contatto.
     */
    @Test
    public void testGetEmail3() {
        System.out.println("getEmail3");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getEmail3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail3 method, of class Contatto.
     */
    @Test
    public void testSetEmail3() {
        System.out.println("setEmail3");
        String email3 = "";
        Contatto instance = null;
        instance.setEmail3(email3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class Contatto.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPath method, of class Contatto.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String path = "";
        Contatto instance = null;
        instance.setPath(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelect method, of class Contatto.
     */
    @Test
    public void testGetSelect() {
        System.out.println("getSelect");
        Contatto instance = null;
        CheckBox expResult = null;
        CheckBox result = instance.getSelect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelect method, of class Contatto.
     */
    @Test
    public void testSetSelect() {
        System.out.println("setSelect");
        CheckBox s = null;
        Contatto instance = null;
        instance.setSelect(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
