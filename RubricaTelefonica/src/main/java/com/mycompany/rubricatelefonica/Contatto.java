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
    private StringProperty numTel1;
    private StringProperty numTel2;
    private StringProperty numTel3;
    private StringProperty email1;
    private StringProperty email2;
    private StringProperty email3;

    public Contatto(StringProperty nome, StringProperty cognome, StringProperty numTel1, StringProperty numTel2, StringProperty numTel3, StringProperty email1, StringProperty email2, StringProperty email3) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTel1 = numTel1;
        this.numTel2 = numTel2;
        this.numTel3 = numTel3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
    }

    public String getNome() {
        return nome.getValue();
    }

    public void setNome(StringProperty nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome.getValue();
    }

    public void setCognome(StringProperty cognome) {
        this.cognome = cognome;
    }

    public String getNumTel1() {
        return numTel1.getValue();
    }

    public void setNumTel1(StringProperty numTel1) {
        this.numTel1 = numTel1;
    }

    public String getNumTel2() {
        return numTel2.getValue();
    }

    public void setNumTel2(StringProperty numTel2) {
        this.numTel2 = numTel2;
    }

    public String getNumTel3() {
        return numTel3.getValue();
    }

    public void setNumTel3(StringProperty numTel3) {
        this.numTel3 = numTel3;
    }

    public String getEmail1() {
        return email1.getValue();
    }

    public void setEmail1(StringProperty email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2.getValue();
    }

    public void setEmail2(StringProperty email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3.getValue();
    }

    public void setEmail3(StringProperty email3) {
        this.email3 = email3;
    }
    
    
 
}
