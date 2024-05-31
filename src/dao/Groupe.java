package dao;

import java.io.Serializable;

public class Groupe implements Serializable {
    private int idGroupe;
    private String nomGroupe;

    public Groupe(){}

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
    public Groupe(int idGroupe, String nomGroupe) {
        this.idGroupe = idGroupe;
        this.nomGroupe = nomGroupe;
    }
    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
}
