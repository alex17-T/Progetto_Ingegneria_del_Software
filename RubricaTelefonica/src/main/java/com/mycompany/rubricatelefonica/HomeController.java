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
     * Il metodo configura le colonne della tabella, imposta a null i dettagli
     * iniziali dei contatti
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    /**
     * Il metodo apre una finestra per l’inserimento dei dati del nuovo contatto
     *
     * Questo metodo viene invocato al clic sul pulsante "Aggiungi".
     * Viene aperta una nuova finestra per l'inserimento nella tabella dei dati:
     * nome, cognome, numeri di telefono ed indirizzi email. 
     * Dopo l'inserimento è possibile vedere il contatto in tabella 
     * 
     * @param event l'evento è generato dall'utente tramite interazione con
     * l'interfaccia grafica quando desidera aggiungere un contatto.
     * 
     * @throws IOException se il contatto che l'utente cerca di aggiungere è già
     * presente in rubrica
     */
    @FXML
    private void AggiungiContatto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    /**
     * Il metodo permette di modificare la foto profilo di un contatto
     *
     * Dopo che l'utente ha cliccato il pulsante edit viene aperta la finestra 
     * dell’esplora risorse dove può essere inserito inserire il percorso del
     * file .jpg da usare come foto profilo.
     * 
     * @param event l'evento è generato dall'utente tramite interazione con
     * l'interfaccia grafica.
     * 
     * @throws FileNotFoundException se il file specificato non viene trovato
     */
    @FXML
    private void ModificaFotoContatto(ActionEvent event) throws FileNotFoundException {

    }

    /**
     * Il metodo abilita o disabilita la modalità di modifica per i dettagli
     * di un contatto.
     *
     * @param event l'evento è generato dall'utente tramite l'interazione con 
     * l'interfaccia grafica. 
     */
    @FXML
    private void ModificaContatto(ActionEvent event) {

        SalvaModificheContatto.visibleProperty().set(!SalvaModificheContatto.visibleProperty().get());
        DettagliContatto.mouseTransparentProperty().set(!DettagliContatto.mouseTransparentProperty().get());

    }

    /**
     * Il metodo permette di rimuovere la foto profilo di un contatto
     *
     * Dopo che l'utente ha cliccato il pulsante del cestino accanto alla foto
     * profilo, quest'ultima viene rimossa. 
     * 
     * @param event l'evento è generato dall'utente tramite l'interazione con 
     * l'interfaccia grafica. 
     */
    @FXML
    private void RimuoviFotoProfilo(ActionEvent event) throws FileNotFoundException {
        // Tabella_contatti.getSelectionModel().getSelectedItem().setFotoprofilo(new Image("C:\\Users\\alessandro\\Documents\\NetBeansProjects\\RubricaTelefonica\\Progetto_Ingegneria_del_Software\\RubricaTelefonica\\src\\main\\resources\\com\\mycompany\\rubricatelefonica"));

    }

    /**
     * Il metodo permette l'importazione completa di una lista di contatti
     *
     * Dopo che l'utente ha cliccato il pulsante importa viene aperta la
     * finestra dell’esplora risorse dove può essere inserito il file da cui 
     * importare.
     * 
     * @param event l'evento è generato dall'utente tramite interazione con
     * l'interfaccia grafica.
     */
    @FXML
    private void ImportaLista(ActionEvent event) {
    }

    /**
     * Il metodo permette l'esportazione completa di una lista di contatti
     *
     * Dopo che l'utente ha cliccato il pulsante esporta viene aperta la
     * finestra dell’esplora risorse dove può scegliere la cartella dove
     * esportare
     * 
     * @param event l'evento è generato dall'utente tramite interazione con
     * l'interfaccia grafica
     */
    @FXML
    private void EsportaLista(ActionEvent event) {
    }

    /**
     * Il metodo mostra la barra degli strumenti.
     *
     * Viene invocato al clic dell'utente sul pulsante seleziona
     * tutto.
     * 
     * @param event evento generato dall'utente tramite interazione con 
     * l'interfaccia grafica.
     */
    @FXML
    private void ModificaListaContatti(ActionEvent event) {
        ToolBar.visibleProperty().set(!(ToolBar.visibleProperty().get()));
    }
    
    /**
     * Il metodo seleziona tutti i contatti nella tabella utilizzando i checkbox.
     *
     * Viene invocato al clic dell'utente sul pulsante seleziona
     * tutto.
     * 
     * @param event evento generato dall'utente tramite interazione con 
     * l'interfaccia grafica.
     */
    @FXML
    private void SelezionaTuttoCheckBox(ActionEvent event) {
    }

    /**
     * Il metodo rimuove tutti i contatti nella tabella selezionati.
     *
     * Viene invocato al clic dell'utente sul pulsante rimuovi selezionati.
     * 
     * @param event evento generato dall'utente tramite interazione con 
     * l'interfaccia grafica.
     */    
    
    @FXML
    private void RimuoviContattiSelezionati(ActionEvent event) {
    }

    /**
     * Il metodo permette di cercare un contatto nella lista dei contatti
     *
     * Viene invocato al clic sulla barra di ricerca.
     * 
     * @param event evento generato dall'utente tramite interazione con 
     * l'interfaccia grafica.
     */
    @FXML
    private void CercaElemento(ActionEvent event) {
    }

    /**
     * Il metodo annulla l'operazione corrente e nasconde la barra degli
     * strumenti.
     *
     * Viene invocato al clic sulla barra di ricerca.
     * 
     * @param event evento generato dall'utente tramite interazione con 
     * l'interfaccia grafica.
     */    
    @FXML
    private void AnnullaOperazione(ActionEvent event) {
        ToolBar.visibleProperty().set(false);
    }

    /**
     * Il metodo mostra i dettagli di un contatto selezionato
     *
     * @param event evento generato dall'utente tramite interazione con 
     * l'interfaccia grafica, quando seleziona un contatto.
     */
    private void showContattiDetails(Contatto c) {

        if (c != null) {
            nomeInfo.setText(c.getNome());
            cognomeInfo.setText(c.getCognome());
            numInfo1.setText(c.getNumTel1());
            numInfo2.setText(c.getNumTel2());
            numInfo3.setText(c.getNumTel3());
            emailInfo1.setText(c.getEmail1());
            emailInfo2.setText(c.getEmail2());
            emailInfo3.setText(c.getEmail3());
        } else {
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
     * Salva le modifiche apportate alle informazioni di un contatto selezionato
     * nella tabella.
     *
     * Questo metodo viene invocato al clic sul pulsante "Salva Modifiche".
     * Aggiorna il contatto attualmente selezionato nella tabella con i dati
     * inseriti nei campi di input relativi al nome, cognome, numeri di telefono
     * ed email. Dopo l'aggiornamento: - Viene ricaricata la tabella per
     * riflettere le modifiche. - Viene abilitata/disabilitata la proprietà
     * `mouseTransparent` del pannello `DettagliContatto`.
     *
     * @param event l'evento che rappresenta l'azione del clic sul pulsante
     * (tipicamente generato dall'utente tramite interazione con l'interfaccia
     * grafica).
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
