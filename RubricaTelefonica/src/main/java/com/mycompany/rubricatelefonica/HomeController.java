/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import com.mycompany.rubricatelefonica.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author alessandro
 */
public class HomeController implements Initializable {

    @FXML
    private HBox ToolBar;
    @FXML
    private HBox SerchBar;
    @FXML
    private ImageView contactImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AggiungiContatto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void ModificaFotoContatto(ActionEvent event) throws FileNotFoundException {
        /*FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fc.showOpenDialog(null);
        Image img = new Image(new FileInputStream(file));
        contactImage.imageProperty().set(img);*/
    }

    @FXML
    private void ModificaContatto(ActionEvent event) {
        
    }

    @FXML
    private void RimuoviFotoProfilo(ActionEvent event) {
        /*Image defImg = new Image("@FotoProfiloDefault.png");
        contactImage.setImage(defImg);*/
    }

    @FXML
    private void ImportaLista(ActionEvent event) {
    }

    @FXML
    private void EsportaLista(ActionEvent event) {
    }

    @FXML
    private void ModificaListaContatti(ActionEvent event) {
        
      //if(ToolBar.visibleProperty().get() == false)
      ToolBar.visibleProperty().set(!(ToolBar.visibleProperty().get()));
      
      //SerchBar.visibleProperty().set(false);
           
    }

    @FXML
    private void SelezionaTuttoCheckBox(ActionEvent event) {
    }

    @FXML
    private void RimoviContattiSelezionati(ActionEvent event) {
    }

    @FXML
    private void CercaElemento(ActionEvent event) {
    }

    @FXML
    private void AnnullaOperazione(ActionEvent event) {
        ToolBar.visibleProperty().set(false);
    }
    
}
