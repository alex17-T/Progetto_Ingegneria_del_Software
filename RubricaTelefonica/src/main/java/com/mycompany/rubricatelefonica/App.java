
package com.mycompany.rubricatelefonica;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.stage.FileChooser;

/**
 * 
 * @file App.java
 * @brief Questo file contiene la logica per il lancio dell'applicazione.
 * implementa i metodi per la gestione dei dati salvati in memoria
 */
 
public class App extends Application {

    private static Scene scene;

    /**
     * @brief Setta l'interfaccia grafica iniziale e la mostra a schermo.
     * 
     * Questo metodo trova il file Home.fxml e lo setta come un
     * oggetto di tipo Scene, che viene aggiunto allo stage che 
     * viene poi mostrato a schermo come interfaccia grafica.
     * 
     * @param stage L'oggetto che conterrà la scena e quindi il nodo radice del file Home.fxml.
     * @pre Il parametro stage deve essere non nullo.
     * @throws IOException se il file fxml non può essere caricato.
     */
    @Override
    public void start(Stage stage) throws IOException {
        ImportaListaDefault("/com/mycompany/rubricatelefonica/default.ser");
        scene = new Scene(loadFXML("Home"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @brief Cambia l'interfaccia grafica corrente.
     * 
     * Passa dall'interfaccia grafica corrente a quella codificata nel file
     * il cui nome è presente nella stringa fxml.
     * 
     * @param[in] fxml Il file .fxml che viene usato per mostrare a schermo la relativa interfaccia grafica.
     * @pre Il file FXML deve esistere nel percorso definito dal parametro fxml.
     * @throws IOException se il file fxml non può essere caricato.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * @brief Caricamento del file di default nella tabella.
     * 
     * @param filePath Il path relativo del file .ser da caricare in rubrica.
     */
    private void ImportaListaDefault(String filePath) {
        // Carica il file dal classpath come InputStream
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        
        if (inputStream == null) {
            System.out.println("File non trovato nel classpath.");
            return;
        }

        ArrayList<Contatto> listaContatti = null;

        // Procedi con la deserializzazione del file
        try (ObjectInputStream objIn = new ObjectInputStream(inputStream)) {
            // Deserializza la lista di contatti dal file
            listaContatti = (ArrayList<Contatto>) objIn.readObject();
            System.out.println("Contatti caricati da: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Errore durante la deserializzazione del file " + filePath);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore durante l'importazione");
            alert.setHeaderText("Errore nel file");
            alert.setContentText("Il file non è valido o è corrotto.");
            alert.showAndWait();
            return;
        }

        if (listaContatti != null && !listaContatti.isEmpty()) {
            SuperController.lista.clear();
            for (Contatto contatto : listaContatti) {
                // Esegui validazione del contatto prima di aggiungerlo
                if (contatto.getNome().isEmpty() && contatto.getCognome().isEmpty()) {
                    continue; // Salta il contatto se non valido
                }
                // Ricostruisci ogni contatto usando i valori delle stringhe
                String nome = contatto.getNome();
                String cognome = contatto.getCognome();
                String numTel1 = contatto.getNumTel1();
                String numTel2 = contatto.getNumTel2();
                String numTel3 = contatto.getNumTel3();
                String email1 = contatto.getEmail1();
                String email2 = contatto.getEmail2();
                String email3 = contatto.getEmail3();
                String path = contatto.getPath();
                        

                // Crea un nuovo contatto con le StringProperty
                Contatto nuovoContatto = new Contatto(
                        new SimpleStringProperty(nome),
                        new SimpleStringProperty(cognome),
                        new SimpleStringProperty(numTel1),
                        new SimpleStringProperty(numTel2),
                        new SimpleStringProperty(numTel3),
                        new SimpleStringProperty(email1),
                        new SimpleStringProperty(email2),
                        new SimpleStringProperty(email3)
                );
                nuovoContatto.setSelect(new CheckBox());
                nuovoContatto.setPath(path);
                SuperController.lista.add(nuovoContatto);
            }
            FXCollections.sort(SuperController.lista);
            System.out.println("Rubrica importata correttamente.");
        
        } else {
            System.out.println("Lista di contatti vuota nel file.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("File vuoto");
            alert.setHeaderText("Nessun contatto trovato");
            alert.setContentText("Il file non contiene alcun contatto valido.");
            alert.showAndWait();
        }
    }

    /**
     * @brief Carica un file fxml e ritorna il suo nodo radice.
     * 
     * @param[in] fxml Il nome senza estensione del file fxml da caricare.
     * @pre Il parametro fxml deve essere una stringa non vuota.
     * @return Il nodo radice del file fxml caricato, sotto forma di oggetto Parent.
     * @throws IOException se il file non può essere caricato.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * @brief Lancia il metodo start della classe App.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }

}