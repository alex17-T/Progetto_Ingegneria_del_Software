

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
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;

/**
 * @brief Questa classe gestisce l'interfaccia principale della rubrica
 * telefonica.
 *
 * @brief Questo file contiene la logica dell'interfaccia principale.
 *
 * @brief Questo file implementa i metodi che rendono interattiva e correttamente
 * @brief funzionante l'interfaccia grafica codificata nel file Home.fxml.
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
  
    /**
     * @brief Identificativo della colonna delle checkbox della tabella dei contatti
     */
    
    @FXML
    private TableColumn<Contatto, CheckBox> Colonna_Spunta;
    
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
     /**
     * @brief Identificativo della textfield per cercare un contatto 
     */
    @FXML
    private TextField serchBar;
    /**
 * @brief Lista filtrata dei contatti.
 * 
 * Utilizzata per applicare filtri dinamici alla lista principale.
 */
     public static FilteredList<Contatto> listaFiltrata;
     /**
 * @brief Lista ordinata dei contatti.
 * 
 * Basata sulla lista filtrata per mantenere un ordine specifico.
 */
     public static SortedList<Contatto> listaOrdinata;

     /**
 * @brief Serve  a inizializzare i checkbox in modo da farli funzionare da subito,
    altrimenti alla prima selezione e deselezione non verranno rispettivamente selezionati e deselezionati
    tutti i checkbox dei contatti in rubrica.
 */
     private boolean listenerAdded = false;
     
      /**
     * @brief Identificativo della checkbox per selezionare tutti i contatti
     */

    @FXML
    private CheckBox selezionaTutti;
     /**
     * @brief Identificativo del bottone per  modificare la foto profilo del contatto selezionato
     */
    @FXML
    private Button mFotobtn;
    /**
     * @brief Identificativo del bottone per eliminare la foto profilo del contatto selezionato
     */
    @FXML
    private Button RFotobtn;
  /**
     * @brief Identificativo della variabile booleana per gestiore le transizioni della tool bar
     */
     boolean visibilita;

    /**
     * @brief Il metodo configura la tabella e le sue colonne.
     *
     * Questo metodo inizializza le colonne della tabella riferendole agli
     * attributi nome, cognome, numTel1 e email1 di Contatto. La tabella viene
     * anche settata come "senza elementi selezionati" e gli viene associato un
     * ChangeListener per attivarsi se il contatto selezionato cambia.
     * Rende la lista interattiva filtrandola e ordinadola 
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
        Colonna_Spunta.setCellValueFactory(new PropertyValueFactory<>("select"));
        Tabella_contatti.setItems(SuperController.lista);

        showContattiDetails(null);
        modificaButton.setDisable(true);

      
          listaFiltrata = new FilteredList<>(lista, b->true);
        Tabella_contatti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contatto>() {
        
            @Override
            public void changed(ObservableValue<? extends Contatto> observable, Contatto oldValue, Contatto newValue) {
                showContattiDetails(newValue);
                modificaButton.setDisable(newValue == null);
            }
        });
        
 
        serchBar.textProperty().addListener((observable ,oldValue , newValue)->{
        listaFiltrata.setPredicate(Contatto -> {
          // Verifica se il filtro è vuoto o nullo, in tal caso mostra tutti i contatti.
          if(newValue == null || newValue.isEmpty()) return true;
        
          String lowCaseFilter = newValue.toLowerCase();
          // Controlla se il filtro corrisponde al nome, cognome, numeri di telefono o email.
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
    public void AggiungiContatto(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    /**
     * Il metodo permette di modificare la foto profilo di un contatto
     *
     * Dopo che l'utente ha cliccato il pulsante edit viene aperta la finestra
     * dell’esplora risorse dove può essere inserito inserire il percorso del
     * file immagine da usare come foto profilo.
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
         mFotobtn.mouseTransparentProperty().set(!mFotobtn.mouseTransparentProperty().get());
        RFotobtn.mouseTransparentProperty().set(!RFotobtn.mouseTransparentProperty().get());

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
            //Controlla se il file è vuoto
            if(file.length() == 0){
                System.out.println("Il file è vuoto. Impossibile importare.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore durante l'importazione");
                alert.setHeaderText("File vuoto");
                alert.setContentText("Il file selezionato è vuoto. Impossibile procedere con l'importazione.");
                alert.showAndWait();
                return;  // Non procedere oltre
            }
            // Esegui azioni con il file selezionato
            ArrayList<Contatto> listaContatti = null;
        
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))) {
                // Deserializza la lista di contatti dal file
                listaContatti = (ArrayList<Contatto>) objIn.readObject();
                System.out.println("Contatti caricati da: " + file.getAbsolutePath());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Errore durante la deserializzazione del file " + file.getAbsolutePath());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore durante l'importazione");
                alert.setHeaderText("Errore nel file");
                alert.setContentText("Il file non è valido o è corrotto.");
                alert.showAndWait();
                return;
            }
            if(listaContatti != null && !listaContatti.isEmpty()){
                SuperController.lista.clear();
                for(Contatto contatto : listaContatti){
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
                SuperController.lista.add(nuovoContatto);
            }
                FXCollections.sort(SuperController.lista);
                System.out.println("Rubrica importata correttamente.");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Importazione completata");
                alert.setHeaderText("Rubrica importata");
                alert.setContentText("La rubrica è stata importata correttamente.");
                alert.showAndWait();
        } else {
            System.out.println("Lista di contatti vuota nel file.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("File vuoto");
            alert.setHeaderText("Nessun contatto trovato");
            alert.setContentText("Il file non contiene alcun contatto valido.");
            alert.showAndWait();
        }
    } else {
        System.out.println("Nessun file selezionato.");
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
            String fileName = file.getName();
            if (!fileName.endsWith(".ser")) {
                file = new File(file.getParentFile(), fileName + ".ser"); // Usa getParentFile() invece di getParent()
            }
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
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Operazione completata");
                    successAlert.setHeaderText("Esportazione completata");
                    successAlert.setContentText("La rubrica è stata esportata correttamente.");
                    successAlert.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Errore durante l'esportazione");
                    errorAlert.setHeaderText("Errore nel file");
                    errorAlert.setContentText("Si è verificato un errore durante l'esportazione.");
                    errorAlert.showAndWait();
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
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operazione completata");
                    alert.setHeaderText("Esportazione completata");
                    alert.setContentText("La rubrica è stata esportata correttamente.");
                    alert.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Errore durante l'esportazione");
                    errorAlert.setHeaderText("Errore nel file");
                    errorAlert.setContentText("Si è verificato un errore durante l'esportazione.");
                    errorAlert.showAndWait();
                }
            }
        } else {
                System.out.println("Nessun file selezionato.");
            }
        }

    /**
     * Il metodo mostra la barra degli strumenti.
     *
     * Viene invocato al clic dell'utente sul pulsante "modifica lista".
     *
     * @param event evento generato dall'utente tramite interazione con
     * l'interfaccia grafica.
     */
    @FXML
    private void ModificaListaContatti(ActionEvent event) {
    
         FadeTransition fadeIn = new FadeTransition(Duration.millis(500), ToolBar);
         FadeTransition fadeOut= new FadeTransition(Duration.millis(500), ToolBar);
        
        if(!visibilita){
           
             fadeIn.setFromValue(0); // Opacità iniziale
             fadeIn.setToValue(1);   // Opacità finale (visibile)
             fadeIn.play();
             ToolBar.setVisible(true);
             visibilita = true;
             
      }else {
      
           
             fadeOut.setFromValue(1); // Opacità iniziale
             fadeOut.setToValue(0);   // Opacità finale (non visibile visibile)
             fadeOut.play();
             visibilita = false;
          
      } 
            
        Colonna_Spunta.setVisible(!Colonna_Spunta.visibleProperty().get());
       
       
        // Dopo che la toolbar è visibile, imposta il listener sul checkbox principale
        if (ToolBar.visibleProperty().get() && !listenerAdded) {
            selezionaTutti.selectedProperty().addListener((obs, oldVal, newVal) -> {
                for (Contatto c : listaOrdinata) {
                    c.getSelect().setSelected(newVal); // Imposta il valore di selezione per ogni contatto
                }
            });
            // Imposta la variabile di stato per evitare aggiunta ripetuta del listener
            listenerAdded = true;
        }
        if(ToolBar.visibleProperty().get()){
            // Inizializza lo stato dei checkbox dei contatti in base al checkbox principale
            boolean initialSelection = selezionaTutti.isSelected();
            for (Contatto c : listaOrdinata) {
                c.getSelect().setSelected(initialSelection); // Imposta lo stato iniziale dei checkbox
            }
        }
    }

    /**
     * Il metodo seleziona tutti i contatti nella tabella utilizzando i
     * checkbox.
     *
     * Viene invocato al clic dell'utente sul pulsante "seleziona tutto".
     *
     * @param event evento generato dall'utente tramite interazione con
     * l'interfaccia grafica.
     */
    @FXML
    private void SelezionaTuttoCheckBox(ActionEvent event) {
        // Aggiungi un listener per il checkbox principale (selezionaTutti)
        selezionaTutti.selectedProperty().addListener((obs, oldVal, newVal) -> {
            // Se il checkbox principale è selezionato, seleziona tutti i contatti
            for (Contatto c : listaOrdinata) {
                c.getSelect().setSelected(newVal); // Propaga la selezione o deselezione
            }
        });
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
        
         ObservableList<Contatto> listaDaRimovere = FXCollections.observableArrayList();
                       for (Contatto c : lista){
       if(c.getSelect().isSelected()){
     listaDaRimovere.add(c);
   
       }
       }
                     
                       SuperController.rimElement(listaDaRimovere);
     
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
            // Controlla se un contatto è selezionato
        if (Tabella_contatti.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Nessun contatto selezionato");
            alert.setContentText("Per salvare le modifiche, seleziona prima un contatto dalla tabella.");
            alert.showAndWait();
            return; // Interrompe l'esecuzione se nessun contatto è selezionato
        }

        // Controlla se i campi sono vuoti
        if (nomeInfo.getText().isEmpty() && cognomeInfo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Campi incompleti");
            alert.setContentText("Il nome o il cognome sono OBBLIGATORI");
            alert.showAndWait();
            return; // Interrompe l'esecuzione se i campi obbligatori sono vuoti
        }
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
          String filepath = SuperController.class.getResource("/com/mycompany/rubricatelefonica/default.ser").getPath();
     
       ArrayList<Contatto> listaContattiSalvati = new ArrayList<>(lista);
       try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filepath))){
            objOut.writeObject(listaContattiSalvati);
             System.out.println("Rubrica aggiornata correttamente ");
       }catch(IOException ex){
          ex.printStackTrace();
       }
      
        
        // Mostra un messaggio di conferma
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Operazione completata");
        successAlert.setHeaderText("Modifiche salvate");
        successAlert.setContentText("Le modifiche al contatto sono state salvate correttamente.");
        successAlert.showAndWait();
    }
}
    
