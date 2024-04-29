package com.example.gsb;

import java.io.Serializable;

public class Motif implements Serializable {
    private String libelle;


    public Motif(String libelle){
        this.libelle = libelle;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
