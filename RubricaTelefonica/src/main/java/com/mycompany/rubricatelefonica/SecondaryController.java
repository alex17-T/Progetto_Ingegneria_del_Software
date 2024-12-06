
package com.mycompany.rubricatelefonica;


import java.io.IOException;
import java.util.ArrayList;
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

public class SecondaryController {

    @FXML
    private VBox datiObbligatori;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField t1Field;
    @FXML
    private TextField t2Field;
    @FXML
    private TextField t3Field;
    @FXML
    private TextField m1Field;
    @FXML
    private TextField m2Field;
    @FXML
    private TextField m3Field;
    
    @FXML
    private ImageView immagine;
    @FXML
    private Button fotoButton;
    @FXML
    private Button esciButton;
    @FXML
    private Button creaButton;
    
    
    public void initialize(){
        creaButton.disableProperty().bind(nomeField.textProperty().isEmpty().and(cognomeField.textProperty().isEmpty()));
    }

    @FXML
    private void verificaObblighi(ActionEvent event) {
    }

    @FXML
    private void cambiaImage(ActionEvent event) {
    }

    @FXML
    private void creaContatto(ActionEvent event) throws IOException {
        
        SuperController.lista.add(new Contatto(nomeField.getText(), cognomeField.getText(), t1Field.getText(), t2Field.getText(), t3Field.getText(), m1Field.getText(), m2Field.getText(), m3Field.getText()));
        App.setRoot("Home");
        
    }

    @FXML
    private void tornaHome(ActionEvent event) throws IOException{
        
          App.setRoot("Home");
    }
}