/**
 * @file Contatto.java
 * @brief Questo file contiene gli attributi di un contatto e i suoi getter e setter.
 * 
 * La classe `Contatto` rappresenta un contatto nella rubrica, 
 * includendo attributi come nome, cognome, numeri di telefono, email e immagine di profilo.
 * Ogni contatto ha una serie di getter e setter per gestire questi attributi.
 */

package com.mycompany.rubricatelefonica;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @brief Rappresenta un contatto nella rubrica telefonica.
 * 
 * Questa classe contiene le informazioni di un contatto, tra cui nome, cognome,
 * numeri di telefono, email e immagine di profilo. I contatti sono comparabili
 * in base al nome e al cognome, e le informazioni sono memorizzate come `StringProperty`
 * per la compatibilità con JavaFX.
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
     * @brief Compara i contatti prima per nome e, in caso di pareggio, per cognome.
     * 
     * Questo metodo compara i contatti secondo questa logica:
     *    -se il nome è null il relativo contatto viene per primo;
     *    -poi i contatti sono ordinati in ordine lessicografico per nome;
     *    -eventuali pareggi per il nome sono risolti applicando la stessa logica per il cognome.
     * 
     * @invariant I due contatti comparati non hanno sia nome che cognome uguali.
     * 
     * @param[in] altroContatto il contatto con cui comparare quello che ha chiamato questo metodo.
     * @return 0 se i due contatti sono in pareggio nell'ordine lessicografico,
     *         un intero negativo se il contatto chiamante viene prima del contatto parametro,
     *         un intero positivo se il contatto chiamante viene prima del contatto parametro.
     */
    @Override
    public int compareTo(Contatto altroContatto){
        String nome1 = nome.getValue();
        String nome2 = altroContatto.nome.getValue();
        
        if(nome1 == null && nome2 == null){
            return 0;
        }
        
        if(nome1 == null && nome2 != null){
            return -1;
        }
        
        if(nome1 != null && nome2 == null){
            return 1;
        }
        
        int comparazione = nome1.compareTo(nome2);
        
        if(comparazione == 0){
            String cognome1 = cognome.getValue();
            String cognome2 = altroContatto.cognome.getValue();
            
            if(cognome1 == null && cognome2 == null){
                return 0;
            }
        
            if(cognome1 == null && cognome2 != null){
                return -1;
            }
        
            if(cognome1 != null && cognome2 == null){
                return 1;
            }
            
            comparazione = cognome1.compareTo(cognome2);
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
