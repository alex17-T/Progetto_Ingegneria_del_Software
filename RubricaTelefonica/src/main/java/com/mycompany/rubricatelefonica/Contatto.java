/**
 * @file Contatto.java
 * @brief Questo file contiene gli attributi di un contatto e i suoi getter e setter.
 */

package com.mycompany.rubricatelefonica;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Giovanni
 */
public class Contatto implements Comparable<Contatto>{
  
    private StringProperty nome;
    private StringProperty cognome;
    private StringProperty numTel1;
    private StringProperty numTel2;
    private StringProperty numTel3;
    private StringProperty email1;
    private StringProperty email2;
    private StringProperty email3;
    private ImageView fotoprofilo;
    
    
    /**
     * 
     * @return 
     */
    @Override
    public int compareTo(Contatto altroContatto){
        if(this.getNome() == null && altroContatto.getNome() == null){
            return 0;
        }
        
        if(this.getNome() == null && altroContatto.getNome() != null){
            return 1;
        }
        
        if(this.getNome() != null && altroContatto.getNome() == null){
            return -1;
        }
        
        int comparazione = this.getNome().compareTo(altroContatto.getNome());
        
        if(comparazione == 0){
            if(this.getCognome() == null && altroContatto.getCognome() == null){
                return 0;
            }
        
            if(this.getCognome() == null && altroContatto.getCognome() != null){
                return 1;
            }
        
            if(this.getCognome() != null && altroContatto.getCognome() == null){
                return -1;
            }
            
            comparazione = this.getCognome().compareTo(altroContatto.getCognome());
        }
        
        return comparazione;
    }

 /**
 * Restituisce l'immagine di profilo della persona.
 *
 * @return l'immagine di profilo come oggetto Image
 */
    public ImageView getFotoprofilo() {
        return fotoprofilo;
    }
/**
 * Imposta l'immagine di profilo della persona.
 *
 * @param fotoprofilo la nuova immagine di profilo
 */
    public void setFotoprofilo(ImageView fotoprofilo) {
        this.fotoprofilo = fotoprofilo;
    }
    
    
    /**
 * Costruttore della classe.
 *
 * @param nome        il nome della persona
 * @param cognome     il cognome della persona
 * @param numTel1     il primo numero di telefono
 * @param numTel2     il secondo numero di telefono
 * @param numTel3     il terzo numero di telefono
 * @param email1      la prima email della persona
 * @param email2      la seconda email della persona
 * @param email3      la terza email della persona
 * @param fotoprofilo l'immagine di profilo della persona
 * @throws IllegalArgumentException se uno dei parametri obbligatori è null o vuoto
 */

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
/**
 * Restituisce il nome della persona.
 *
 * @return il nome della persona come StringProperty
 */
    public String getNome() {
        return nome.getValue();
    }
/**
 * Imposta il nome della persona.
 *
 * @param nome il nuovo nome della persona
 *
 */
    public void setNome(String nome) {
        this.nome.setValue(nome);
    }
/**
 * Restituisce il cognome della persona.
 *
 * @return il cognome della persona come StringProperty
 */
    public String getCognome() {
        return cognome.getValue();
    }

    /**
 * Imposta il cognome della persona.
 *
 * @param cognome il nuovo cognome della persona
 * @throws IllegalArgumentException se il cognome è null o vuoto
 */
    public void setCognome(String cognome) {
        this.cognome.setValue(cognome);
    }
/**
 * Restituisce il primo numero di telefono della persona.
 *
 * @return il primo numero di telefono come StringProperty
 */
    public String getNumTel1() {
        return numTel1.getValue();
    }
/**
 * Imposta il primo numero di telefono della persona.
 *
 * @param numTel1 il nuovo primo numero di telefono
 */
    public void setNumTel1(String numTel1) {
        this.numTel1.setValue(numTel1);
    }
/**
 * Restituisce il secondo numero di telefono della persona.
 *
 * @return il secondo numero di telefono come StringProperty
 */
    public String getNumTel2() {
        return numTel2.getValue();
    }
/**
 * Imposta il secondo numero di telefono della persona.
 *
 * @param numTel2 il nuovo secondo numero di telefono
 */
    public void setNumTel2(String numTel2) {
        this.numTel2.setValue(numTel2);
    }
/**
 * Restituisce il terzo numero di telefono della persona.
 *
 * @return il terzo numero di telefono come StringProperty
 */
    public String getNumTel3() {
        return numTel3.getValue();
    }
/**
 * Imposta il terzo numero di telefono della persona.
 *
 * @param numTel3 il nuovo terzo numero di telefono
 */
    public void setNumTel3(String numTel3) {
        this.numTel3.setValue(numTel3);
    }
/**
 * Restituisce la prima email della persona.
 *
 * @return la prima email come StringProperty
 */
    public String getEmail1() {
        return email1.getValue();
    }
/**
 * Imposta la prima email della persona.
 *
 * @param email1 la nuova prima email
 */
    public void setEmail1(String email1) {
        this.email1.setValue(email1);
    }
/**
 * Restituisce la seconda email della persona.
 *
 * @return la seconda email come StringProperty
 */
    public String getEmail2() {
        return email2.getValue();
    }
/**
 * Imposta la seconda email della persona.
 *
 * @param email2 la nuova seconda email
 */
    public void setEmail2(String email2) {
        this.email2.setValue(email2);
    }
/**
 * Restituisce la terza email della persona.
 *
 * @return la terza email come StringProperty
 */
    public String getEmail3() {
        return email3.getValue();
    }
/**
 * Imposta la terza email della persona.
 *
 * @param email3 la nuova terza email
 */
    public void setEmail3(String email3) {
        this.email3.setValue(email3);
    }
    
    
 
}
