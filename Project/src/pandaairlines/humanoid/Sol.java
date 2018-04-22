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
public class Sol extends Personnel implements Salairie{
    private int nbHeures;

    public Sol(String nom, String prenom, Date dateNaissance, int nbHeure, int nbHeures) {
        super(nom, prenom, dateNaissance, nbHeure);
        this.nbHeures = nbHeures;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }
    
    @Override
    public float calculSalaire() {
        return this.nbHeures*300;
    }
    
}
