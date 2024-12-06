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
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ImageView contactImage;
    @FXML
    private TableView<Contatto> Tabella_contatti;
    @FXML
    private TableColumn<Contatto, String> Colonna_nome;
    @FXML
    private TableColumn<Contatto, String> Colonna_cognome;
    @FXML
    private HBox SearchBar;
    

    //private ObservableList<Contatto> listaHome = SuperController.lista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //HomeController hm  = new HomeController(Tabella_contatti, Colonna_nome, Colonna_cognome,listaHome);
   
        Colonna_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Colonna_cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        Tabella_contatti.setItems(SuperController.lista);
    }    

    @FXML
    private void AggiungiContatto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
        //Tabella_contatti.setItems(SuperController.lista);
        //Tabella_contatti.refresh();
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
    private void RimuoviFotoProfilo(ActionEvent event) throws FileNotFoundException {
        /*Image defImg = new Image(new FileInputStream("FotoProfiloDefault.png"));
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
