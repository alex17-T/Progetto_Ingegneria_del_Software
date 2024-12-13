/**
 * @file SuperController.java
 * @brief Questo file contiene la ObservableList per la tabella.
 * 
 * La classe SuperController contiene una ObservableList di contatti, gestita in modo centralizzato
 * così da poterla visualizzare e gestire senza passaggi di dati superflui.
 */

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
    /**
 * @brief Aggiunge un nuovo contatto alla lista dei contatti.
 * 
 * @param c Il contatto da aggiungere alla lista.
 * 
 * Questo metodo consente di aggiungere un oggetto `Contatto` alla lista principale
 * dei contatti.
 */
  public static void addElemento (Contatto c){
      lista.add(c);
  }
  /**
 * @brief Rimuove un elenco di contatti dalla lista principale.
 * 
 * @param listaR Una lista osservabile contenente i contatti da rimuovere.
 * 
 * Questo metodo elimina tutti i contatti specificati nella lista `listaR` dalla
 * lista principale.
 */
  public static void rimElement( ObservableList<Contatto> listaR){
  lista.removeAll(listaR);
  }
}
