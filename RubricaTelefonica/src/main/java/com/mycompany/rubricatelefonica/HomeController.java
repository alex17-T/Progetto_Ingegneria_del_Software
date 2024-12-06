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
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private TableColumn<Contatto, StringProperty> Colonna_nome;
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_cognome;
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_telefono;
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_email;
    @FXML
    private HBox SearchBar;
    @FXML
    private Button modificaButton;
    @FXML
    private TableColumn<Contatto, CheckBox> Colonna_Spunta;
    @FXML
    private TableColumn<Contatto, Image> Colonna_fotoProfilo;
    @FXML
    private TextField nomeInfo;
    @FXML
    private TextField cognomeInfo;
    @FXML
    private TextField numInfo1;
    @FXML
    private TextField numInfo2;
    @FXML
    private TextField numInfo3;
    @FXML
    private TextField emailInfo1;
    @FXML
    private TextField emailInfo2;
    @FXML
    private TextField emailInfo3;
    @FXML
    private Button SalvaModificeContatto;
    @FXML
    private VBox DettagliContatto;
    @FXML
    private Button ModificaLista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
        Colonna_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Colonna_cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        Colonna_telefono.setCellValueFactory(new PropertyValueFactory<>("numTel1"));
        Colonna_email.setCellValueFactory(new PropertyValueFactory<>("email1"));
        Tabella_contatti.setItems(SuperController.lista);
        
        showContattiDetails(null);
       
         // Tabella_contatti.getSelectionModel().selectedItemProperty().addListener(
        //     observable, oldValue, newValu) -> {showContattiDetails( (Contatto) newValue);
         // }
         Tabella_contatti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contatto>() {
    @Override
    public void changed(ObservableValue<? extends Contatto> observable, Contatto oldValue, Contatto newValue) {
        showContattiDetails(newValue);
       // SalvaModificheContatto(newValue);
        
    }
});

    }    

    @FXML
    private void AggiungiContatto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void ModificaFotoContatto(ActionEvent event) throws FileNotFoundException {
   
    }

    @FXML
    private void ModificaContatto(ActionEvent event) {
        
        SalvaModificeContatto.visibleProperty().set(!SalvaModificeContatto.visibleProperty().get());
        DettagliContatto.mouseTransparentProperty().set(!DettagliContatto.mouseTransparentProperty().get());
        
        
    }

    @FXML
    private void RimuoviFotoProfilo(ActionEvent event) throws FileNotFoundException {
     
    }

    @FXML
    private void ImportaLista(ActionEvent event) {
    }

    @FXML
    private void EsportaLista(ActionEvent event) {
    }

    @FXML
    private void ModificaListaContatti(ActionEvent event) {
      ToolBar.visibleProperty().set(!(ToolBar.visibleProperty().get()));
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
    
     private void showContattiDetails(Contatto c){
     
         if(c != null){
         nomeInfo.setText(c.getNome());
         cognomeInfo.setText(c.getCognome());
         numInfo1.setText(c.getNumTel1());
         numInfo2.setText(c.getNumTel2());
         numInfo3.setText(c.getNumTel3());    
         emailInfo1.setText(c.getEmail1());
         emailInfo2.setText(c.getEmail2());
         emailInfo3.setText(c.getEmail3());
         }else {
         nomeInfo.setText("");
         cognomeInfo.setText("");
         numInfo1.setText("");
         numInfo2.setText("");
         numInfo3.setText("");    
         emailInfo1.setText("");
         emailInfo2.setText("");
         emailInfo3.setText("");
         
         
         }
     
     
     }

    @FXML
    private void DettagliContatto(ActionEvent event) {
    }

    @FXML
    private void SalvaModificheContatto(ActionEvent event) {
     // c.setNome(nomeInfo.getText());  nomeInfo.getText();
        
    }
}
