


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

    private StringProperty nome;
    private StringProperty cognome;
    private String numTelefono1;     
    private String numTelefono2;
    private String numTelefono3;

    private String email1;     
    private String email2;
    private String email3;
    
    private Image fotoProfilo;
    
    public Contatto(String nome, String cognome) {

        this.nome = new SimpleStringProperty(nome);
        this.cognome = new SimpleStringProperty(cognome);
        

    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCognome() {
        return cognome.get();
    }

    
    public void setCognome(String cognome) {
        this.cognome.set(cognome);
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono1 = numTelefono;
    }
 
}
