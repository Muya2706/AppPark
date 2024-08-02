package com.example.projet;

import javafx.collections.ObservableArray;

public class Ligne {

    private String id,nom,type,attributs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttributs() {
        return attributs;
    }

    public void setAttributs(String attributs) {
        this.attributs = attributs;
    }

    public Ligne(String id, String nom, String type, String attributs) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.attributs = attributs;
    }

}
