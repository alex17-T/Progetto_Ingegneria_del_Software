
package com.mycompany.rubricatelefonica;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
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
public class Contatto implements Comparable<Contatto>, Serializable{
    /**
 * @brief Percorso dell'icona di default associata  alla foto del contatto.
 */
    public static String creatoreFoto = "/com/mycompany/rubricatelefonica/iconaSecondary.jpg";
  /**
 * @brief Nome del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty nome;
    /**
 * @brief Cognome del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty cognome;
    /**
 * @brief Primo numero di telefono del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty numTel1;
    /**
 * @brief Secondo numero di telefono del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty numTel2;
    /**
 * @brief Terzo numero di telefono del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty numTel3;
    /**
 * @brief Prima email del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty email1;
    /**
 * @brief Seconda email del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty email2;
    /**
 * @brief Terza email del contatto come proprietà reattiva.
 * 
 * Non viene serializzato per ragioni di gestione dati in runtime.
 */
    private transient StringProperty email3;
    /**
 * @brief Foto del profilo del contatto.
 * 
 * Non viene serializzata per motivi di memoria e runtime.
 */
    private transient Image fotoprofilo;//Non viene serializzato
    /**
 * @brief Percorso della foto di profilo.
 */
    private String path;
    /**
 * @brief Nome del contatto come stringa semplice.
 */
    private String nomeString;
      /**
 * @brief Cognome del contatto come stringa semplice.
 */
    private String cognomeString;
      /**
 * @brief primo numero di telefono del contatto come stringa semplice.
 */
    private String numTel1String;
        /**
 * @brief secondo numero di telefono del contatto come stringa semplice.
 */
    private String numTel2String;
        /**
 * @brief terzo numero di telefono del contatto come stringa semplice.
 */
    private String numTel3String;
         /**
 * @brief prima email del contatto come stringa semplice.
 */
    private String email1String;
          /**
 * @brief seconda email del contatto come stringa semplice.
 */
    private String email2String;
          /**
 * @brief terza email del contatto come stringa semplice.
 */
    private String email3String;
    /**
 * @brief Checkbox per selezionare il contatto.
 * 
 * Non viene serializzata per motivi di gestione dell'interfaccia grafica.
 */
    private transient CheckBox select;
    
    
    
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
    public Image getFotoprofilo() {
        return fotoprofilo;
    }
/**
 * Imposta l'immagine di profilo della persona.
 *
 * @param fotoprofilo la nuova immagine di profilo
 */
    public void setFotoprofilo(String path) {
        this.fotoprofilo = new Image(path);
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
        this.select = new CheckBox();
        this.path = getClass().getResource("/com/mycompany/rubricatelefonica/iconaSecondary.jpg").toString();
        this.fotoprofilo = new Image(path);
      //  this.fotoprofilo = new Image("C:\\Users\\alessandro\\Documents\\NetBeansProjects\\RubricaTelefonica\\Progetto_Ingegneria_del_Software\\RubricaTelefonica\\src\\main\\resources\\com\\mycompany\\rubricatelefonica");
        this.nomeString = nome.get();
        this.cognomeString = cognome.get();
        this.numTel1String = numTel1.get();
        this.numTel2String = numTel2.get();
        this.numTel3String = numTel3.get();
        this.email1String = email1.get();
        this.email2String = email2.get();
        this.email3String = email3.get();
    }

    public Contatto(StringProperty nome, StringProperty cognome, StringProperty numTel1, StringProperty numTel2, StringProperty numTel3, StringProperty email1, StringProperty email2, StringProperty email3, String nomeString, String cognomeString, String numTel1String, String numTel2String, String numTel3String, String email1String, String email2String, String email3String) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTel1 = numTel1;
        this.numTel2 = numTel2;
        this.numTel3 = numTel3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.nomeString = nomeString;
        this.cognomeString = cognomeString;
        this.numTel1String = numTel1String;
        this.numTel2String = numTel2String;
        this.numTel3String = numTel3String;
        this.email1String = email1String;
        this.email2String = email2String;
        this.email3String = email3String;
        
    }
    
    
    
/**
 * Restituisce il nome della persona come String.
 *
 * @return il nome della persona come String
 */
    public String getNome() {
        return nomeString;
    }
/**
 * Imposta il nome della persona.
 *
 * @param nome il nuovo nome della persona
 *
 */
    public void setNome(String nome) {
        this.nomeString = nome;
        this.nome.set(nomeString);
    }
/**
 * Restituisce il cognome della persona come String.
 *
 * @return il cognome della persona come StringProperty
 */
    public String getCognome() {
        return cognomeString;
    }

    /**
 * Imposta il cognome della persona.
 *
 * @param cognome il nuovo cognome della persona
 * @throws IllegalArgumentException se il cognome è null o vuoto
 */
    public void setCognome(String cognome) {
        this.cognomeString = cognome;
        this.cognome.set(cognomeString);
    }
/**
 * Restituisce il primo numero di telefono della persona come String.
 *
 * @return il primo numero di telefono come StringProperty
 */
    public String getNumTel1() {
        return numTel1String;
    }
/**
 * Imposta il primo numero di telefono della persona.
 *
 * @param numTel1 il nuovo primo numero di telefono
 */
    public void setNumTel1(String numTel1) {
        this.numTel1String = numTel1;
        this.numTel1.set(numTel1String);
    }
/**
 * Restituisce il secondo numero di telefono della persona come String.
 *
 * @return il secondo numero di telefono come StringProperty
 */
    public String getNumTel2() {
        return numTel2String;
    }
/**
 * Imposta il secondo numero di telefono della persona.
 *
 * @param numTel2 il nuovo secondo numero di telefono
 */
    public void setNumTel2(String numTel2) {
        this.numTel2String = numTel2;
        this.numTel2.set(numTel2String);
    }
/**
 * Restituisce il terzo numero di telefono della persona come String.
 *
 * @return il terzo numero di telefono come StringProperty
 */
    public String getNumTel3() {
        return numTel3String;
    }
/**
 * Imposta il terzo numero di telefono della persona.
 *
 * @param numTel3 il nuovo terzo numero di telefono
 */
    public void setNumTel3(String numTel3) {
        this.numTel3String = numTel3;
        this.numTel3.set(numTel3String);
    }
/**
 * Restituisce la prima email della persona come String.
 *
 * @return la prima email come StringProperty
 */
    public String getEmail1() {
        return email1String;
    }
/**
 * Imposta la prima email della persona.
 *
 * @param email1 la nuova prima email
 */
    public void setEmail1(String email1) {
        this.email1String = email1;
        this.email1.set(email1String);
    }
/**
 * Restituisce la seconda email della persona come String.
 *
 * @return la seconda email come StringProperty
 */
    public String getEmail2() {
        return email2String;
    }
/**
 * Imposta la seconda email della persona.
 *
 * @param email2 la nuova seconda email
 */
    public void setEmail2(String email2) {
        this.email2String = email2;
        this.email2.set(email2String);
    }
/**
 * Restituisce la terza email della persona come String.
 *
 * @return la terza email come StringProperty
 */
    public String getEmail3() {
        return email3String;
    }
/**
 * Imposta la terza email della persona.
 *
 * @param email3 la nuova terza email
 */
    public void setEmail3(String email3) {
        this.email3String = email3;
        this.email3.set(email3String);
    }

    /**
 * restituisce il path della foto profilo come String.
 *
 * @return Il path della foto profilo come String
 */
    public String getPath() {
        return path;
    }

    /**
 * Imposta il path della foto profilo.
 *
 * @param path il nuovo path della foto profilo
 */
    public void setPath(String path) {
        this.path = path;
        this.fotoprofilo = new Image(path);
    }
    
    /**
     * Ritorna il checkbox del contatto.
     * 
     * @return Il checkbox del contatto.
     */
    public  CheckBox getSelect(){
        return this.select;
    }
    
    /**
     * Modifica lo stato del checkbox con quello in input.
     * 
     * @param s Il valore da settare nel checkbox del contatto.
     */
    public void setSelect(CheckBox s){
    this.select=s;
    }
            
}
