
package com.mycompany.rubricatelefonica;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

/**
 * @file SecondaryController.java
 * @brief Controller della schermata secondaria, utile per creare un nuovo contatto.
 * 
 * @author Giovanni
 */

public class SecondaryController {
    
/**
 * @brief Identificativo della vertical Box contenente le caselle di testo di nome e cognome
 */
    @FXML
    private VBox datiObbligatori;
    
/**
 * @brief Identificativo della casella di testo del nome
 */
    
    @FXML
    private TextField nomeField;
    
    /**
 * @brief Identificativo della casella di testo del cognome
 */
    
    @FXML
    private TextField cognomeField;
    
    /**
 * @brief Identificativo della casella di testo del primo numero di telefono
 */
    
    @FXML
    private TextField t1Field;
    
    /**
 * @brief Identificativo della casella del secondo numero di telefono
 */
    
    @FXML
    private TextField t2Field;
    
    /**
 * @brief Identificativo della casella del terzo numero di telefono
 */
    
    @FXML
    private TextField t3Field;
    
    /**
 * @brief Identificativo della casella della prima email
 */
    
    @FXML
    private TextField m1Field;
    
    /**
 * @brief Identificativo della casella della seconda email
 */
    
    @FXML
    private TextField m2Field;
    
    /**
 * @brief Identificativo della casella della terza email
 */
    
    @FXML
    private TextField m3Field;
    
    /**
 * @brief Identificativo della immagine visualizzata sulla schermata
 */
    
    @FXML
    private ImageView immagine;
    
    /**
 * @brief Identificativo del bottone "Cambia foto"
 */
    
    @FXML
    private Button fotoButton;
    
    /**
 * @brief Identificativo del bottone "Esci"
 */
    
    @FXML
    private Button esciButton;
    
    /**
 * @brief Identificativo del bottone "Crea contatto"
 */
    
    @FXML
    private Button creaButton;
    
    
    public void initialize(){
        
        
        /**
         * @brief Abilitazione del bottone secondo una condizione dettata dai campi di testo
         * di nome e cognome
         * 
         * Quando viene avviata la schermata secondaria viene attivata una espressione per abilitare il bottone
         * "Crea contatto".
         * L'espressione significa: il bottone è disabilitato finchè entrambe le caselle di testo di
         * nome e cognome sono vuote.
         */
        creaButton.disableProperty().bind(nomeField.textProperty().isEmpty().and(cognomeField.textProperty().isEmpty()));
    }
    
    /**
     * @brief Funzione per cambiare l'immagine
     * 
     * La funzione consente all'utente di selezionare la foto del contatto cliccando su
     * "Cambia foto". Viene aperta una finestra di dialogo dell'esplora risorse dove poter
     * selezionare la foto da inserire al contatto al momento della creazione.
     * 
     * @param event click sul pulsante "Cambia foto"
     */

    @FXML
    private void cambiaImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG File", "*.png", "*.jpg", "*.jpeg")
        );
        
        File file = fc.showOpenDialog(null);
        //Image foto = new Image(file.toURI().toString());
        Contatto.creatoreFoto = file.toURI().toString();
        
        immagine.setImage(new Image(Contatto.creatoreFoto));
        
        //c.setPath();
    }
    
    /**
     * @brief Funzione per la creazione di un contatto
     * 
     * La seguente funzione permette di creare il contatto e aggiungerlo alla lista dei contatti
     * non appena si fa click sul bottone "Crea Contatto".
     * 
     * Infine si ritorna nella schermata Home per poter visualizzare in tabella il contatto inserito.
     * 
     * @param event click sul pulsante "Crea contatto".
     * @throws IOException 
     */

    @FXML
    private void creaContatto(ActionEvent event) throws IOException {
        
        Contatto c = new Contatto(nomeField.textProperty(), cognomeField.textProperty(), t1Field.textProperty(), t2Field.textProperty(), t3Field.textProperty(), m1Field.textProperty(), m2Field.textProperty(), m3Field.textProperty());
        c.setPath(Contatto.creatoreFoto);
        Contatto.creatoreFoto = getClass().getResource("/com/mycompany/rubricatelefonica/iconaSecondary.jpg").toString();
        SuperController.lista.add(c);
        FXCollections.sort(SuperController.lista);
        
        App.setRoot("Home");
        
    }
    
    /**
     * @brief Funzione per ritornare alla schermata Home
     * 
     * La seguente funzione permette all'utente in qualsiasi momento di poter tornare alla
     * schermata home premendo sul pulsanti "Esci".
     * 
     * @param event click sul pulsante "Esci".
     * @throws IOException 
     */

    @FXML
    private void tornaHome(ActionEvent event) throws IOException{
        
          App.setRoot("Home");
    }

}