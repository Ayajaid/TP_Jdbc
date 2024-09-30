/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.devdata;


    public class DevData {
    
    private int Nbscript;
    private String developpeur;
    private String jour;
    
    public DevData() {
    }

    public DevData(String developpeur , String jour) {
        this.developpeur = developpeur;
        this.jour = jour;
    }

    public DevData(String developpeur, String jour,int Nbscript) {
        this.Nbscript = Nbscript;
        this.developpeur = developpeur;
        this.jour = jour;
    }

    public int getNbscript() {
        return Nbscript;
    }

    public void setNbscript(int Nbscript) {
        this.Nbscript = Nbscript;
    }

    public String getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(String developpeur) {
        this.developpeur = developpeur;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }
    
}
