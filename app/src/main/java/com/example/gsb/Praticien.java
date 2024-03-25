package com.example.gsb;

import java.io.Serializable;

public class Praticien implements Serializable {
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String rue;
    private String code_postale;
    private String ville;

    public Praticien(String nom, String prenom, String tel, String email, String rue, String code_postale, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.rue = rue;
        this.code_postale = code_postale;
        this.ville = ville;
    }

    // Getters and setters for each field
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(String code_postale) {
        this.code_postale = code_postale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}