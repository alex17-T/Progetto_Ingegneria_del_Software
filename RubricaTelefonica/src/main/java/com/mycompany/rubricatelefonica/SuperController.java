
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @brief Gestisce centralmente una lista di contatti visibili in una tabella.
 * 
 * Questa classe contiene una lista di contatti (`ObservableList<Contatto>`) che può essere condivisa
 * tra altre classi per visualizzare, aggiungere o modificare contatti nella rubrica.
 * L'invariante della classe è che `lista` non può mai essere null, e deve contenere oggetti di tipo `Contatto`.
 * 
 * @author Giovanni
 */
public class SuperController {
    /**
     * @brief Lista centralizzata di contatti da visualizzare in una tabella.
     * 
     * Questa lista è una `ObservableList<Contatto>` che viene utilizzata per 
     * gestire i contatti.
     * 
     * @invariant La lista non può mai essere null e deve contenere oggetti di tipo `Contatto`.
     */
    public static ObservableList<Contatto> lista = FXCollections.observableArrayList();
    public static   FilteredList<Contatto> listaFiltrata = new FilteredList<>(lista, b->true);
     public static SortedList<Contatto> listaOrdinata = new SortedList<>(listaFiltrata);
 /**
 * @brief Aggiunge un nuovo contatto alla lista principale e aggiorna il file serializzato.
 *
 * Questo metodo consente di aggiungere un oggetto `Contatto` alla lista principale
 * dei contatti e di aggiornare il file serializzato in cui la lista è salvata.
 * 
 * Il file si trova nel percorso relativo "/com/mycompany/rubricatelefonica/default.ser".
 * 
 * @param c Il contatto da aggiungere alla lista.
 *
 * @note Se il file non è accessibile o non scrivibile, viene stampato uno stack trace.
 */
  public static void addElemento (Contatto c){
      lista.add(c);
      
       String filepath = App.nameP+File.separator+"default.ser";     
       ArrayList<Contatto> listaContattiSalvati = new ArrayList<>(lista);
       try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filepath))){
            objOut.writeObject(listaContattiSalvati);
             System.out.println("Rubrica aggiornata correttamente ");
       }catch(IOException ex){
          ex.printStackTrace();
       }
      
      
      
  }
/**
 * @brief Rimuove un elenco di contatti dalla lista principale e aggiorna il file serializzato.
 *
 * Questo metodo consente di eliminare tutti i contatti specificati nella lista
 * `listaR` dalla lista principale e di aggiornare il file serializzato in cui è salvata.
 * 
 * Il file si trova nel percorso relativo "/com/mycompany/rubricatelefonica/default.ser".
 *
 * @param listaR Una lista osservabile contenente i contatti da rimuovere.
 *
 * @note Se il file non è accessibile o non scrivibile, viene stampato uno stack trace.
 */
  public static void rimElement( ObservableList<Contatto> listaR){
  lista.removeAll(listaR);
  String filepath = App.nameP+File.separator+"default.ser";
     
       ArrayList<Contatto> listaContattiSalvati = new ArrayList<>(lista);
       try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filepath))){
            objOut.writeObject(listaContattiSalvati);
             System.out.println("Rubrica aggiornata correttamente ");
       }catch(IOException ex){
          ex.printStackTrace();
       }
  }
}
