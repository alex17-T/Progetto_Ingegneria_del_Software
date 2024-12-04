/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricatelefonica;

import java.util.LinkedList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author alessandro
 */
public class ListaContatti {
    
    
    private List <Contatto>listaContatti;
    public ObservableList<Contatto> listaOsservabile;
    
    public ListaContatti(){
    
       listaContatti = new LinkedList<>();
         
    }
    
    public List getLista(){
        return listaContatti;
    }
    
    public void addOsservabile(Contatto c){
        listaOsservabile.add(c);
    }
    
    
}
