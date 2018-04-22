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
public class Navigant extends Personnel {

    private int volId;
    private int maxSomme;

    public Navigant(int volId, int maxSomme, String nom, String prenom, Date dateNaissance, int nbHeure, int nbHeures) {
        super(nom, prenom, dateNaissance, nbHeure);
        this.volId = volId;
        this.maxSomme = maxSomme;
    }
}
