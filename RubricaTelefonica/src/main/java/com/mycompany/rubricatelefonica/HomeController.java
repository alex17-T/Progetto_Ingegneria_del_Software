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
import javafx.scene.Node;
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
import javafx.stage.Stage;

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
    private TableColumn<Contatto, ImageView> Colonna_fotoProfilo;
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
    private VBox DettagliContatto;
    @FXML
    private Button ModificaLista;
    @FXML
    private Button SalvaModificheContatto;

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
       }
    });
 
    }    

    @FXML
    private void AggiungiContatto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void ModificaFotoContatto(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
         Image image = new Image(new FileInputStream(file));// Leggi l'immagine
          ImageView FotoSel = new ImageView(image);// Creazione di un ImageView
      //    Tabella_contatti.getSelectionModel().getSelectedItem().setFotoprofilo(FotoSel);
          contactImage.setImage(image);
          
    }

    @FXML
    private void ModificaContatto(ActionEvent event) {
        
        SalvaModificheContatto.visibleProperty().set(!SalvaModificheContatto.visibleProperty().get());
        DettagliContatto.mouseTransparentProperty().set(!DettagliContatto.mouseTransparentProperty().get());
        
        
    }

    @FXML
    private void RimuoviFotoProfilo(ActionEvent event) throws FileNotFoundException {
       //mageView FotoDefault = new ImageView(new Image(this.getClass().getResourceAsStream("FotoProfiloDefault")));
      //  Tabella_contatti.getSelectionModel().getSelectedItem().setFotoprofilo(FotoDefault)   ;    
     contactImage.setImage(new Image(this.getClass().getResourceAsStream("FotoProfiloDefault")));
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
    private void RimuoviContattiSelezionati(ActionEvent event) {
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
/**
 * Salva le modifiche apportate alle informazioni di un contatto selezionato nella tabella.
 *
 * Questo metodo viene invocato al clic sul pulsante "Salva Modifiche". Aggiorna il contatto
 * attualmente selezionato nella tabella con i dati inseriti nei campi di input relativi al nome,
 * cognome, numeri di telefono ed email. Dopo l'aggiornamento:
 * - Viene ricaricata la tabella per riflettere le modifiche.
 * - Viene abilitata/disabilitata la proprietà `mouseTransparent` del pannello `DettagliContatto`.
 *
 * @param event l'evento che rappresenta l'azione del clic sul pulsante
 *              (tipicamente generato dall'utente tramite interazione con l'interfaccia grafica).
 *
 * 
 */
    @FXML
    private void SalvaModificheContatto(ActionEvent event) {
     
      // Seleziona il contatto corrente dalla tabella e aggiorna i suoi dati
        Tabella_contatti.getSelectionModel().getSelectedItem().setNome(nomeInfo.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setCognome(cognomeInfo.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setNumTel1(numInfo1.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setNumTel2(numInfo2.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setNumTel3(numInfo3.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setEmail1(emailInfo1.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setEmail2(emailInfo2.getText());
        Tabella_contatti.getSelectionModel().getSelectedItem().setEmail3(emailInfo3.getText());
        // Aggiorna la visualizzazione della tabella
        Tabella_contatti.refresh();
         // Inverte la proprietà `mouseTransparent` del pannello dei dettagli per renderli non selezionabili
        DettagliContatto.mouseTransparentProperty().set(!DettagliContatto.mouseTransparentProperty().get());
    }
    
    
    
}
