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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author Giovanni
 */
public class SuperController {
    public static ObservableList<Contatto> lista = FXCollections.observableArrayList();
    

}
