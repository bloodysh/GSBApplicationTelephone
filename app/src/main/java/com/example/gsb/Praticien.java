package com.example.gsb;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Praticien implements Serializable {
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String rue;
    private String code_postale;
    private String ville;
    private String _id;
    private ArrayList<Visite> visites;


    public Praticien(String nom, String prenom, String tel, String email, String rue, String code_postale, String ville, String _id){
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.rue = rue;
        this.code_postale = code_postale;
        this.ville = ville;
        this._id = _id;

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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public ArrayList<Visite> getVisites() {
        return visites;
    }

    public void setVisites(ArrayList<Visite> visites) {
        this.visites = visites;
    }
}