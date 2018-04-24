/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.avion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pandaairlines.db_cnx.dbcnx;
import pandaairlines.vol.Vol;

/**
 *
 * @author ky94
 */
public class Aeroport {

    private String immatricule;
    private String nomAero;
    private String adresse;
    private String pays;

    public Aeroport(String immatricule, String nomAero, String adresse, String pays) {

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

    public static String getPaysStringfromId(String aeroId) {
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM aeroport where immatricule ='" + aeroId + "'");
            if (rs.next()) {
                return rs.getString("pays") + "/" + rs.getString("adress");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "N/A - N/A";
    }

    public static Aeroport chercheraeroport(String immatricule) {
        Aeroport aero =new Aeroport("N/A", "N/A", "N/A", "N/A");
        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from aeroport where immatricule ='" + immatricule + "'");
            if (rs.next()) {
                aero=new Aeroport(rs.getString("immatricule"), 
                        rs.getString("nom"), 
                        rs.getString("adresse"), 
                        rs.getString("pays"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aero;
    }

}
