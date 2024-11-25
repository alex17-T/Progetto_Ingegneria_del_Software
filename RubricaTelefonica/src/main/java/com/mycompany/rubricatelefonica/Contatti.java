/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

/**
 *
 * @author Giovanni
 */
public class Contatti {

    private String nome;
    private String cognome;
    private String numTelefono;

    public Contatti(String nome, String cognome, String numTelefono) {

        this.nome = nome;
        this.cognome = cognome;
        this.numTelefono = numTelefono;

    }

    public String getNome() {
        return nome;
    }

}
