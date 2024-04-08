package com.example.gsb;

import java.io.Serializable;

public class Visite implements Serializable {
    private String date_visite;
    private String commentaire;
    private String id_praticien;
    private String id_visiteur;
    private String id_motif;

    public Visite(String date_visite, String commentaire, String id_praticien, String id_visiteur, String id_motif) {
        this.date_visite = date_visite;
        this.commentaire = commentaire;
        this.id_praticien = id_praticien;
        this.id_visiteur = id_visiteur;
        this.id_motif = id_motif;
    }


    public String getDate_visite() {
        return date_visite;
    }

    public void setDate_visite(String date_visite) {
        this.date_visite = date_visite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getId_praticien() {
        return id_praticien;
    }

    public void setId_praticien(String id_praticien) {
        this.id_praticien = id_praticien;
    }

    public String getId_visiteur() {
        return id_visiteur;
    }

    public void setId_visiteur(String id_visiteur) {
        this.id_visiteur = id_visiteur;
    }

    public String getId_motif() {
        return id_motif;
    }

    public void setId_motif(String id_motif) {
        this.id_motif = id_motif;
    }
}
