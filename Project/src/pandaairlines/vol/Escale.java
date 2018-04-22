/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.vol;

import java.util.Date;

/**
 *
 * @author ky94
 */
class Escale {
    private String villeEscale;
    private Date heureAtterissage;
    private Date heureDepart;

    public Escale(String villeEscale, Date heureAtterissage, Date heureDepart) {
        this.villeEscale = villeEscale;
        this.heureAtterissage = heureAtterissage;
        this.heureDepart = heureDepart;
    }

    public String getVilleEscale() {
        return villeEscale;
    }

    public Date getHeureAtterissage() {
        return heureAtterissage;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public void setVilleEscale(String villeEscale) {
        this.villeEscale = villeEscale;
    }

    public void setHeureAtterissage(Date heureAtterissage) {
        this.heureAtterissage = heureAtterissage;
    }

    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }
    
}
