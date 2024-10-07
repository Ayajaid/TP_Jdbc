/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author Pc
 */
public class Entreprise {
     private int id;
    private String nom;
    private Date dateCreation;

    public Entreprise(String nom, Date dateCreation) {
        this.nom = nom;
        this.dateCreation = dateCreation;
    }

    public Entreprise(int id, String nom, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
}
