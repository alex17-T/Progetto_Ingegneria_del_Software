package com.mycompany.rubricatelefonica;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author Giovanni
 */
public class Contatto {

    private String nome;
    private String cognome;
    private String numTelefono1;     
    private String numTelefono2;
    private String numTelefono3;

    private String email1;     
    private String email2;
    private String email3;
    
    private Image fotoProfilo;
    
    public Contatto(String nome, String cognome, String numTelefono1, String numTelefono2, String numTelefono3, String email1, String email2, String email3) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTelefono1 = numTelefono1;
        this.numTelefono2 = numTelefono2;
        this.numTelefono3 = numTelefono3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
    }

    public String getNumTelefono1() {
        return numTelefono1;
    }

    public void setNumTelefono1(String numTelefono1) {
        this.numTelefono1 = numTelefono1;
    }

    public String getNumTelefono2() {
        return numTelefono2;
    }

    public void setNumTelefono2(String numTelefono2) {
        this.numTelefono2 = numTelefono2;
    }

    public String getNumTelefono3() {
        return numTelefono3;
    }

    public void setNumTelefono3(String numTelefono3) {
        this.numTelefono3 = numTelefono3;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }
    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono1 = numTelefono;
    }
 
}
