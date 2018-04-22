/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.avion;

/**
 *
 * @author ky94
 */
public abstract class Avion {
    private String immatricule;
    private String nom;
    private String marque;
    private String compagne;
   
    private int nbrPersonnel;
    private int maintenance;

    public Avion(String immatricule, String nom, String marque, String compagne,  int nbrPersonnel, int maintenance) {
        this.immatricule = immatricule;
        this.nom = nom;
        this.marque = marque;
        this.compagne = compagne;
       
        this.nbrPersonnel = nbrPersonnel;
        this.maintenance = maintenance;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public String getCompagne() {
        return compagne;
    }

   
    public int getNbrPersonnel() {
        return nbrPersonnel;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setCompagne(String compagne) {
        this.compagne = compagne;
    }

   

    public void setNbrPersonnel(int nbrPersonnel) {
        this.nbrPersonnel = nbrPersonnel;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }
    
}
