/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.humanoid;

import java.util.Date;

/**
 *
 * @author ky94
 */
public abstract class Personnel implements Salairie {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private int nbHeure;
    private float salaire;
    public Personnel(String nom, String prenom, Date dateNaissance, int nbHeure) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nbHeure = nbHeure;
    }
    @Override
    public float calculSalaire(){
        return salaire*nbHeure;
    }
}
