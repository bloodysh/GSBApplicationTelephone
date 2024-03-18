package com.example.gsb;

import java.text.DateFormat;
import java.util.Date;

public class Visiteur {
    private String nom;
    private String prenom;
    private String numero;
    private String email;
    private String password;
    private Date date_embauche;

    public Visiteur(String nom, String prenom, String numero, String email, String password, Date date_embauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
        this.password = password;
        this.date_embauche = date_embauche;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }
}
