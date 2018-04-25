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
public class AvionPassager extends Avion {

    private int nbrPassages;

    public int getNbrPassages() {
        return nbrPassages;
    }

    public void setNbrPassages(int nbrPassages) {
        this.nbrPassages = nbrPassages;
    }

    public AvionPassager(boolean display,String immatricule, String nom, String marque, String compagne, int nbrPersonnel, int maintenance, int nbrpassagers) {
//        super(display,immatricule, nom, marque, compagne, nbrPersonnel, maintenance);

        this.nbrPassages = nbrpassagers;
    }

    public AvionPassager() {
        super();
        this.nbrPassages = 0;
    }

    public static AvionPassager chercher_avion(String immatricule) {
        AvionPassager a = null;

        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from avion where idavion =" + immatricule + "and type='passager'");
            if (rs.next()) {

                a.setImmatricule(immatricule);
                a.setNom(rs.getString("nom"));
                a.setMarque(rs.getString("marque"));
                a.setCompagne(rs.getString("companie"));
                a.setNbrPersonnel(rs.getInt("nombrepersonnel")+"/");

                a.setMaintenance(Integer.getInteger(rs.getString("maint"))+"/");
                return a;
            }

        } catch (SQLException ex) {
            //Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return a;
    }

}
