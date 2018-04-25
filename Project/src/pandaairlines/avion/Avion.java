/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.avion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import pandaairlines.db_cnx.dbcnx;

/**
 *
 * @author ky94
 */
public  class Avion {

    private String immatricule;
    private String nom;
    private String marque;
    private String compagne;
    private String nbrPersonnel;
    private String maintenance;
    private SimpleStringProperty simmatricule;
    private SimpleStringProperty snom;
    private SimpleStringProperty smarque;
    private SimpleStringProperty scompagne;
    private SimpleStringProperty snbrPersonnel;
    private SimpleStringProperty smaintenance;
    private SimpleStringProperty stype;

    public Avion(boolean display, String immatricule, String type, String nom, String marque, String compagne, String nbrPersonnel, String maintenance) {
        this.immatricule = immatricule;
        this.nom = nom;
        this.marque = marque;
        this.compagne = compagne;
        this.nbrPersonnel = nbrPersonnel;
        this.maintenance = maintenance;
        if (display) {
            simmatricule = new SimpleStringProperty(immatricule);
            snom = new SimpleStringProperty(nom);
            smarque = new SimpleStringProperty(marque);
            scompagne = new SimpleStringProperty(compagne);
            stype = new SimpleStringProperty(type);
            snbrPersonnel = new SimpleStringProperty(nbrPersonnel+"/"+nbrPersonnel);
            smaintenance = new SimpleStringProperty(maintenance+"/"+maintenance);
        }
    }

    public Avion() {
        this.immatricule = "";
        this.nom = "";
        this.marque = "";
        this.compagne = "";
        this.nbrPersonnel = "";
        this.maintenance = "";
    }

    public String getImmatricule() {
        return immatricule;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public String getCompagne() {
        return compagne;
    }

    public String getNbrPersonnel() {
        return nbrPersonnel;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setCompagne(String compagne) {
        this.compagne = compagne;
    }

    public void setNbrPersonnel(String nbrPersonnel) {
        this.nbrPersonnel = nbrPersonnel;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public static String getAvionType(int immatricule) throws SQLException {
        Statement stm = dbcnx.connect().createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM avion where idavion=" + immatricule);
        if (rs.next()) {
            return rs.getString("type");
        }
        return "N/A";
    }

}
