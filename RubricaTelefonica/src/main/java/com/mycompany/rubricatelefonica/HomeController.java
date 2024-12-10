/**
 * @file HomeController.java
 * @brief Questo file contiene la logica dell'interfaccia principale.
 *
 * Questo file implementa i metodi che rendono interattiva e correttamente
 * funzionante l'interfaccia grafica codificata nel file Home.fxml.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import com.mycompany.rubricatelefonica.*;
import static com.mycompany.rubricatelefonica.SuperController.lista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @brief Questa classe gestisce l'interfaccia principale della rubrica
 * telefonica.
 *
 * FXML Controller class
 *
 * @author alessandro
 */
public class HomeController implements Initializable{

    /**
     * @brief Identificativo H - Box della toolbar
     */
    @FXML
    private HBox ToolBar;

    /**
     * @brief Identificativo dell'immagine di un contatto
     */
    @FXML
    private ImageView contactImage;

    /**
     * @brief Identificativo della tabella dei contatti
     */
    @FXML
    private TableView<Contatto> Tabella_contatti;

    /**
     * @brief Identificativo della colonna del nome della tabella dei contatti
     */
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_nome;

    /**
     * @brief Identificativo della colonna del cognome della tabella dei
     * contatti
     */
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_cognome;

    /**
     * @brief Identificativo della colonna del numero di telefono della tabella
     * dei contatti
     */
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_telefono;

    /**
     * @brief Identificativo della colonna dell'email della tabella dei contatti
     */
    @FXML
    private TableColumn<Contatto, StringProperty> Colonna_email;


    /**
     * @brief Identificativo del bottone per modificare i dettagli di un
     * contatto
     */
    @FXML
    private Button modificaButton;
    @FXML
    private TableColumn<Contatto, CheckBox> Colonna_Spunta;
    @FXML
    private TableColumn<Contatto, ImageView> Colonna_fotoProfilo;

    /**
     * @brief Identificativo della casella di testo del ome
     */
    @FXML
    private TextField nomeInfo;

    /**
     * @brief Identificativo della casella di testo del cognome
     */
    @FXML
    private TextField cognomeInfo;

    /**
     * @brief Identificativo della casella di testo del primo numero di telefono
     */
    @FXML
    private TextField numInfo1;

    /**
     * @brief Identificativo della casella di testo del secondo numero di
     * telefono
     */
    @FXML
    private TextField numInfo2;

    /**
     * @brief Identificativo della casella di testo del terzo numero di telefono
     */
    @FXML
    private TextField numInfo3;

    /**
     * @brief Identificativo della casella di testo della prima email
     */
    @FXML
    private TextField emailInfo1;

    /**
     * @brief Identificativo della casella di testo della seconda email
     */
    @FXML
    private TextField emailInfo2;

    /**
     * @brief Identificativo della casella di testo della terza email
     */
    @FXML
    private TextField emailInfo3;

    /**
     * @brief Identificativo della Vertical Box contenente i dettagli di un
     * contatto
     */
    @FXML
    private VBox DettagliContatto;

    /**
     * @brief Identificativo del bottone per modificare la lista dei contatti
     */
    @FXML
    private Button ModificaLista;

    /**
     * @brief Identificativo del bottone per salvare una modifica a un contatto
     */
    @FXML
    private Button SalvaModificheContatto;
    @FXML
    private Pane detailPane;
    @FXML
    private HBox SearchBox;
    @FXML
    private TextField serchBar;
     public static FilteredList<Contatto> listaFiltrata;
     public static SortedList<Contatto> listaOrdinata;

    /**
     * @brief Il metodo configura la tabella e le sue colonne.
     *
     * Questo metodo inizializza le colonne della tabella riferendole agli
     * attributi nome, cognome, numTel1 e email1 di Contatto. La tabella viene
     * anche settata come "senza elementi selezionati" e gli viene associato un
     * ChangeListener per attivarsi se il contatto selezionato cambia.
     *
     * @pre La lista dei contatti (cioè SuperController.lista) è inizializzata.
     * @post La tabella contiene i contatti della lista osservabile.
     *
     * @see showContattiDetails()
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Colonna_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Colonna_cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        Colonna_telefono.setCellValueFactory(new PropertyValueFactory<>("numTel1"));
        Colonna_email.setCellValueFactory(new PropertyValueFactory<>("email1"));
        Colonna_fotoProfilo.setCellValueFactory(new PropertyValueFactory<>("fotoprofilo"));
        Tabella_contatti.setItems(SuperController.lista);

        showContattiDetails(null);

        // Tabella_contatti.getSelectionModel().selectedItemProperty().addListener(
        //     observable, oldValue, newValu) -> {showContattiDetails( (Contatto) newValue);
        // }
          listaFiltrata = new FilteredList<>(lista, b->true);
        Tabella_contatti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contatto>() {
            /**
             * @brief Visualizza i dettagli di un contatto se selezionato.
             *
             * Quando cambia il contatto selezionato nella tabella (anche
             * nessuno), questo metodo si attiva e mostra i dati del contatto
             * selezionato (tali dati sono tutte stringhe vuote se non è
             * selezionato nessun contatto).
             *
             * @invariant oldValue e newValue hanno valori differenti.
             * @param observable La proprietà osservata, in questo caso il
             * cambio del contatto selezionato.
             * @param oldValue Il contatto precedentemente selezionato (anche
             * nessuno).
             * @param newValue Il nuovo contatto selezionato (anche nessuno).
             */
            @Override
            public void changed(ObservableValue<? extends Contatto> observable, Contatto oldValue, Contatto newValue) {
                showContattiDetails(newValue);
            }
        });
        
        
        serchBar.textProperty().addListener((observable ,oldValue , newValue)->{
        listaFiltrata.setPredicate(Contatto -> {
        
          if(newValue == null || newValue.isEmpty()) return true;
        
          String lowCaseFilter = newValue.toLowerCase();
        
          if(Contatto.getNome().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if (Contatto.getCognome().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if(Contatto.getNumTel1().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if(Contatto.getNumTel2().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if(Contatto.getNumTel3().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if(Contatto.getEmail1().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if(Contatto.getEmail1().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
          else if(Contatto.getEmail1().toLowerCase().indexOf(lowCaseFilter)!= -1) return true;
        
            return false;
        
            });
        });
      
        listaOrdinata = new SortedList<>(listaFiltrata);
        listaOrdinata.comparatorProperty().bind(Tabella_contatti.comparatorProperty());
        
        Tabella_contatti.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            if(newValue !=null){
                Contatto c = newValue;
                contactImage.setImage(c.getFotoprofilo());
            }
        });
        
        Tabella_contatti.setItems(listaOrdinata);
        
        
    }

    /**
     * Il metodo apre una finestra per l’inserimento dei dati del nuovo contatto
     *
     * Questo metodo viene invocato al clic sul pulsante "Aggiungi". Viene
     * aperta una nuova finestra per l'inserimento nella tabella dei dati: nome,
     * cognome, numeri di telefono ed indirizzi email. Dopo l'inserimento è
     * possibile vedere il contatto in tabella
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
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG File", "*.png", "*.jpg", "*.jpeg")
        );
        
        SuperController.lista.get(Tabella_contatti.getSelectionModel().getSelectedIndex()).setPath(file.toURI().toString());
        //contactImage.setImage(Tabella_contatti.getSelectionModel().getSelectedItem().getFotoprofilo());
        contactImage.setImage(Tabella_contatti.getSelectionModel().getSelectedItem().getFotoprofilo());
    }

    /**
     * Il metodo abilita o disabilita la modalità di modifica per i dettagli di
     * un contatto.
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
     *
     * @throws FileNotFoundException se il file specificato non viene trovato
     */
    @FXML
    private void RimuoviFotoProfilo(ActionEvent event) throws FileNotFoundException {
        //mageView FotoDefault = new ImageView(new Image(this.getClass().getResourceAsStream("FotoProfiloDefault")));
        //  Tabella_contatti.getSelectionModel().getSelectedItem().setFotoprofilo(FotoDefault)   ;    
        //contactImage.setImage(new Image(this.getClass().getResourceAsStream("iconaSecondary.jpg")));
        Tabella_contatti.getSelectionModel().getSelectedItem().setPath("/com/mycompany/rubricatelefonica/iconaSecondary.jpg");
        contactImage.setImage(Tabella_contatti.getSelectionModel().getSelectedItem().getFotoprofilo());
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
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di Oggetti Serializzati", "*.ser"));
        File file = fileChooser.showOpenDialog(stage); // Si aprirà la finestra per selezionare un file

        if (file != null) {
            // Esegui azioni con il file selezionato
            ArrayList<Contatto> listaContatti = null;
        
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))) {
                // Deserializza la lista di contatti dal file
                listaContatti = (ArrayList<Contatto>) objIn.readObject();
                System.out.println("Contatti caricati da: " + file.getAbsolutePath());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Errore durante la deserializzazione del file " + file.getAbsolutePath());
            }
            if(listaContatti != null){
                SuperController.lista.clear();
                for(Contatto contatto : listaContatti){
                // Ricostruisci ogni contatto usando i valori delle stringhe
                String nome = contatto.getNome();
                String cognome = contatto.getCognome();
                String numTel1 = contatto.getNumTel1();
                String numTel2 = contatto.getNumTel2();
                String numTel3 = contatto.getNumTel3();
                String email1 = contatto.getEmail1();
                String email2 = contatto.getEmail2();
                String email3 = contatto.getEmail3();

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
                SuperController.lista.add(nuovoContatto);
            }
                FXCollections.sort(SuperController.lista);
                System.out.println("Rubrica importata correttamente.");
        } else {
            System.out.println("Nessun file selezionato.");
        }
    }
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di Oggetti Serializzati", "*.ser"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage); // Si aprirà la finestra per selezionare un file

        if (file != null) {
            if(file.exists()){
                // Fai apparire una finestra di conferma per sovrascrivere il file
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Conferma Sovrascrittura");
                alert.setHeaderText("Il file esiste già");
                alert.setContentText("Vuoi sovrascrivere il file?");
            
            // Mostra la finestra di conferma e aspetta la risposta
            if (alert.showAndWait().get() == ButtonType.OK) {
                // Se l'utente conferma, serializza i dati nel file
                ArrayList<Contatto> listaContatti = new ArrayList<>(SuperController.lista);

                // Serializza la lista di contatti nel file
                try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
                    objOut.writeObject(listaContatti);
                    System.out.println("Rubrica esportata correttamente in " + file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Esportazione annullata.");
            }
            } else {
                // Se il file non esiste, salva direttamente
                ArrayList<Contatto> listaContatti = new ArrayList<>(SuperController.lista);

                // Serializza la lista di contatti nel file
                try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
                    objOut.writeObject(listaContatti);
                    System.out.println("Rubrica esportata correttamente in " + file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
                System.out.println("Nessun file selezionato.");
            }
        }

    /**
     * Il metodo mostra la barra degli strumenti.
     *
     * Viene invocato al clic dell'utente sul pulsante seleziona tutto.
     *
     * @param event evento generato dall'utente tramite interazione con
     * l'interfaccia grafica.
     */
    @FXML
    private void ModificaListaContatti(ActionEvent event) {
        ToolBar.visibleProperty().set(!(ToolBar.visibleProperty().get()));
    }

    /**
     * Il metodo seleziona tutti i contatti nella tabella utilizzando i
     * checkbox.
     *
     * Viene invocato al clic dell'utente sul pulsante seleziona tutto.
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

        SuperController.lista.remove(Tabella_contatti.getSelectionModel().getSelectedItem());

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

    /**
     * Salva le modifiche apportate alle informazioni di un contatto selezionato
     * nella tabella.
     *
     * Questo metodo viene invocato al clic sul pulsante "Salva Modifiche".
     * Aggiorna il contatto attualmente selezionato nella tabella con i dati
     * inseriti nei campi di input relativi al nome, cognome, numeri di telefono
     * ed email. Dopo l'aggiornamento:
     * - Viene ricaricata la tabella per riflettere le modifiche.
     * - Viene abilitata/disabilitata la proprietà `mouseTransparent` del
     * pannello `DettagliContatto`.
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
        int index = SuperController.lista.indexOf(Tabella_contatti.getSelectionModel().getSelectedItem());
        Contatto contatto = SuperController.lista.get(index);
        contatto.setNome(nomeInfo.getText());
        contatto.setCognome(cognomeInfo.getText());
        contatto.setNumTel1(numInfo1.getText());
        contatto.setNumTel2(numInfo2.getText());
        contatto.setNumTel3(numInfo3.getText());
        contatto.setEmail1(emailInfo1.getText());
        contatto.setEmail2(emailInfo2.getText());
        contatto.setEmail3(emailInfo3.getText());
        SuperController.lista.set(index, contatto);
        // Aggiorna la visualizzazione della tabella
        Tabella_contatti.refresh();
        // Inverte la proprietà `mouseTransparent` del pannello dei dettagli per renderli non selezionabili
        DettagliContatto.mouseTransparentProperty().set(!DettagliContatto.mouseTransparentProperty().get());
        SalvaModificheContatto.visibleProperty().set(false);
    }

}
