
package com.mycompany.rubricatelefonica;

import static com.mycompany.rubricatelefonica.HomeController.c;
import static com.mycompany.rubricatelefonica.HomeController.listaOsservabile;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

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
    
    //private String defaultImagePath = "https://static.vecteezy.com/system/resources/previews/014/300/061/original/man-profile-glyph-icon-anonymous-photo-for-documents-illustration-vector.jpg";
    
    @FXML
    private ImageView immagine;
    @FXML
    private Button fotoButton;
    @FXML
    private Button esciButton;
    @FXML
    private Button creaButton;
    
    public void initialize(){
        //checkImage();
    }
    
    /*private void checkImage(){
        if(immagine.getImage() == null){
            Image defaultImage = new Image(defaultImagePath);
            immagine.setImage(defaultImage);
        }
    }*/

    @FXML
    private void verificaObblighi(ActionEvent event) {
    }

    @FXML
    private void cambiaImage(ActionEvent event) {
    }

    @FXML
    private void creaContatto(ActionEvent event) throws IOException {
        listaOsservabile.add(new Contatto(
                nomeField.getText(),cognomeField.getText()));
        App.setRoot("Home");
    }

    @FXML
    private void tornaHome(ActionEvent event) throws IOException{
        
          App.setRoot("Home");
    }
}