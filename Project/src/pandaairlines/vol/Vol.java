/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.vol;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ky94
 */
public class Vol {
    private int volId;
    private String vDepart;
    private String vArrive;
    private Date heureDepart;
    private Date heureArrive;
    private int prix;
    private ArrayList<Escale> Escales;
    public Vol() {
    }

    public Vol(int volId, String vDepart, String vArrive, Date heureDepart, Date heureArrive, int prix, ArrayList<Escale> Escales) {
        this.volId = volId;
        this.vDepart = vDepart;
        this.vArrive = vArrive;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.prix = prix;
        this.Escales = Escales;
    }

    public int getVolId() {
        return volId;
    }

    public String getvDepart() {
        return vDepart;
    }

    public String getvArrive() {
        return vArrive;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public Date getHeureArrive() {
        return heureArrive;
    }

    public int getPrix() {
        return prix;
    }

    public ArrayList<Escale> getEscales() {
        return Escales;
    }

    public void setVolId(int volId) {
        this.volId = volId;
    }

    public void setvDepart(String vDepart) {
        this.vDepart = vDepart;
    }

    public void setvArrive(String vArrive) {
        this.vArrive = vArrive;
    }

    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrive(Date heureArrive) {
        this.heureArrive = heureArrive;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setEscales(ArrayList<Escale> Escales) {
        this.Escales = Escales;
    }
    
}
