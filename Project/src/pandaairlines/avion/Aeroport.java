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
   
    private String immatricule;
    private String nomAero;
    private String adresse;
    private String pays;

    public Aeroport( String immatricule, String nomAero, String adresse, String pays) {
       
        this.immatricule = immatricule;
        this.nomAero = nomAero;
        this.adresse = adresse;
        this.pays = pays;
    }

   

    public String getImmatricule() {
        return immatricule;
    }

    public String getNomAero() {
        return nomAero;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPays() {
        return pays;
    }

   

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public void setNomAero(String nomAero) {
        this.nomAero = nomAero;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    public static Aeroport chercheraeroport(int ref) {
    	
		return null;
    	
    }
    
}

