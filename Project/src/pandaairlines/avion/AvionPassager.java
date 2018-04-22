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
public class AvionPassager extends Avion {
	private int nbrPassages;

    public int getNbrPassages() {
		return nbrPassages;
	}

	public void setNbrPassages(int nbrPassages) {
		this.nbrPassages = nbrPassages;
	}

	public AvionPassager(String immatricule, String nom, String marque, String compagne,  int nbrPersonnel, int maintenance,int nbrpassagers){
        super( immatricule,  nom, marque, compagne, nbrPersonnel,maintenance);
       
        this.nbrPassages=nbrpassagers;
    }
    
}
