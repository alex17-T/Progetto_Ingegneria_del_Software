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
    private Image fotoprofilo;

    
    public Image getFotoprofilo() {
        return fotoprofilo;
    }

    public void setFotoprofilo(Image fotoprofilo) {
        this.fotoprofilo = fotoprofilo;
    }

    public Contatto(StringProperty nome, StringProperty cognome, StringProperty numTel1, StringProperty numTel2, StringProperty numTel3, StringProperty email1, StringProperty email2, StringProperty email3) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTel1 = numTel1;
        this.numTel2 = numTel2;
        this.numTel3 = numTel3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
      //  this.fotoprofilo = new Image("C:\\Users\\alessandro\\Documents\\NetBeansProjects\\RubricaTelefonica\\Progetto_Ingegneria_del_Software\\RubricaTelefonica\\src\\main\\resources\\com\\mycompany\\rubricatelefonica");
    }

    public String getNome() {
        return nome.getValue();
    }

    public void setNome(String nome) {
        this.nome.setValue(nome);
    }

    public String getCognome() {
        return cognome.getValue();
    }

    public void setCognome(String cognome) {
        this.cognome.setValue(cognome);
    }

    public String getNumTel1() {
        return numTel1.getValue();
    }

    public void setNumTel1(String numTel1) {
        this.numTel1.setValue(numTel1);
    }

    public String getNumTel2() {
        return numTel2.getValue();
    }

    public void setNumTel2(String numTel2) {
        this.numTel2.setValue(numTel2);
    }

    public String getNumTel3() {
        return numTel3.getValue();
    }

    public void setNumTel3(String numTel3) {
        this.numTel3.setValue(numTel3);
    }

    public String getEmail1() {
        return email1.getValue();
    }

    public void setEmail1(String email1) {
        this.email1.setValue(email1);
    }

    public String getEmail2() {
        return email2.getValue();
    }

    public void setEmail2(String email2) {
        this.email2.setValue(email2);
    }

    public String getEmail3() {
        return email3.getValue();
    }

    public void setEmail3(String email3) {
        this.email3.setValue(email3);
    }
    
    
 
}
