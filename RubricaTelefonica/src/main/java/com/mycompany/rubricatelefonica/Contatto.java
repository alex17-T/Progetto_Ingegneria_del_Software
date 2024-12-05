


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author Giovanni
 */
public class Contatto {

    /*private SimpleStringProperty name;
    private SimpleStringProperty surname;*/
    private String nome;
    private String cognome;
    private String numTelefono1;     
    private String numTelefono2;
    private String numTelefono3;

    private String email1;     
    private String email2;
    private String email3;
    
    private Image fotoProfilo;
    
    public Contatto(String nome, String cognome) {

        /*this.name = new SimpleStringProperty(nome);
        this.surname = new SimpleStringProperty(cognome);*/
        this.nome = nome;
        this.cognome = cognome;
        

    }

    public String getNome() {
        //return nome.get();
        return this.nome;
    }

    public void setNome(String nome) {
        //this.nome.set(nome);
        this.nome = nome;
    }

    public String getCognome() {
        //return cognome.get();
        return this.cognome;
    }

    
    public void setCognome(String cognome) {
        //this.cognome.set(cognome);
        this.cognome = cognome;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono1 = numTelefono;
    }
 
}
