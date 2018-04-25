/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.avion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pandaairlines.db_cnx.dbcnx;

/**
 *
 * @author ky94
 */
public class AvionMarchandise extends Avion {

    private int masseMax;
    private int volumeMax;

    public AvionMarchandise(boolean display, String immatricule, String nom, String marque, String compagne, int nbrPersonnel, int maintenance, int massemax, int volumemax) {
//        super(display, immatricule, nom, marque, compagne, nbrPersonnel, maintenance);
        this.masseMax = massemax;
        this.volumeMax = volumemax;
    }

    public AvionMarchandise() {
        super();
        this.masseMax = 0;
        this.volumeMax = 0;
    }

    public static AvionMarchandise chercheravionmarchandise(String immatricule) {
        AvionMarchandise avmar = new AvionMarchandise();
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from avion where idavion=" + immatricule + " and type ='marchandise'");
            if (rs.next()) {

                avmar = new AvionMarchandise(true,
                        immatricule,
                        rs.getString("nom"),
                        rs.getString("marque"),
                        rs.getString("companie"),
                        rs.getInt("nombrepersonnel"),
                        rs.getInt("maint"),
                        rs.getInt("massemax"),
                        rs.getInt("volumemax"));
            }

        } catch (SQLException ex) {
            //Logger.getLogger(AvionMarchandise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avmar;
    }

}
