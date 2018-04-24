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
public class AvionMarchandise extends Avion {

    private int masseMax;
    private int volumeMax;

    public AvionMarchandise(String immatricule, String nom, String marque, String compagne, int nbrPersonnel, int maintenance, int massemax, int volumemax) {
        super(immatricule, nom, marque, compagne, nbrPersonnel, maintenance);
        this.masseMax = massemax;
        this.volumeMax = volumemax;
    }

}
