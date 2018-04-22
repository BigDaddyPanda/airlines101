package pandaairlines.humanoid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;
import pandaairlines.vol.Vol;

/**
 *
 * @author ky94
 */
public class Client {
    private int clientNum;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroPassport;

    public Client(int clientNum, String nom, String prenom, Date dateNaissance, String numeroPassport) {
        this.clientNum = clientNum;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroPassport = numeroPassport;
    }

    public int getClientNum() {
        return clientNum;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getNumeroPassport() {
        return numeroPassport;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNumeroPassport(String numeroPassport) {
        this.numeroPassport = numeroPassport;
    }
    
    
    
    static public ArrayList afficherClient(){
        return new ArrayList();
    }
    static public Vol rechercherVol(int volID){
        return new Vol();
    }
    static public void supprimerClient(int num){
        
    }
}
