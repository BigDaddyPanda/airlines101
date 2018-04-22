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
public class Aeroport {
    private int ref;
    private String immatricule;
    private String nomAero;
    private String ville;
    private String pays;

    public Aeroport(int ref, String immatricule, String nomAero, String ville, String pays) {
        this.ref = ref;
        this.immatricule = immatricule;
        this.nomAero = nomAero;
        this.ville = ville;
        this.pays = pays;
    }

    public int getRef() {
        return ref;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public String getNomAero() {
        return nomAero;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public void setNomAero(String nomAero) {
        this.nomAero = nomAero;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
}

