/**
 * @file App.java
 * @brief Questo file contiene la logica per il lancio dell'applicazione.
 */
package com.mycompany.rubricatelefonica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
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
     * @throws IOException se il file fxml non può essere caricato.
     */
    @Override
    public void start(Stage stage) throws IOException {
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
     * @throws IOException se il file fxml non può essere caricato.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * @brief Carica un file fxml e ritorna il suo nodo radice.
     * 
     * @param[in] fxml Il nome senza estensione del file fxml da caricare.
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