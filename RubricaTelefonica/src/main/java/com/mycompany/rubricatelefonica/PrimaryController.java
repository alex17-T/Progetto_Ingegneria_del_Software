/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import com.mycompany.rubricatelefonica.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author alessandro
 */
public class PrimaryController implements Initializable {

    @FXML
    private HBox ToolBar;
    @FXML
    private HBox SerchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AggiungiContatto(ActionEvent event) {
    }

    @FXML
    private void ModificaFotoContatto(ActionEvent event) {
    }

    @FXML
    private void ModificaContatto(ActionEvent event) {
        
    }

    @FXML
    private void RimuoviFotoProfilo(ActionEvent event) {
    }

    @FXML
    private void ImportaLista(ActionEvent event) {
    }

    @FXML
    private void EsportaLista(ActionEvent event) {
    }

    @FXML
    private void ModificaListaContatti(ActionEvent event) {
        
      ToolBar.visibleProperty().set(true);
      SerchBar.visibleProperty().set(false);
           
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
    
}
