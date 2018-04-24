/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.humanoid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import pandaairlines.db_cnx.dbcnx;

/**
 *
 * @author ky94
 */
public class Admin extends Personnel {

    public Admin(String nom, String prenom, String dateNaissance, String fonction, String login, String password, int nbHeure, float salaire) {
        super(nom, prenom, dateNaissance, fonction, login, password, nbHeure, salaire);
    }

    public static void ajouteravionmarchandise(int immatricule, String nom, String marque, String compagne, int nbrPersonnel, int maintenance, int massemax, int volumemax) {
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from avion where idavion=" + immatricule + "and type='marchandise'");
            if (!rs.next()) {
                PreparedStatement prd = dbcnx.connect().prepareStatement("insert into avion(nom,marque,companie,type,nombrepersonnel,massemax,volumemax) values(?,?,?,?,?,?,?)");
                prd.setString(1, nom);
                prd.setString(2, marque);
                prd.setString(3, compagne);
                prd.setString(4, "marchandise");
                prd.setInt(5, nbrPersonnel);
                prd.setInt(6, massemax);
                prd.setInt(7, volumemax);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ajouteravionpassager(int immatricule, String nom, String marque, String compagne, int nbrPersonnel, int maintenance, int nbrpassagers) {
        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from avion where idavion=" + immatricule + "type ='passager'");
            if (!rs.next()) {
                PreparedStatement prd = dbcnx.connect().prepareStatement("insert into avion(nom,marque,companie,type,nombrepassager,nombrepersonnel) values(?,?,?,?,?,?)");

                prd.setString(1, nom);
                prd.setString(2, marque);
                prd.setString(3, compagne);
                prd.setString(4, "passager");
                prd.setInt(5, nbrpassagers);
                prd.setInt(6, nbrPersonnel);

            }
        } catch (SQLException ex) {
            //Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ajoutervol(int volId, String vDepart, String vArrive, String heureDepart, String heureArrive, int prix, String type, int idavion) {
        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from vol where idvol =" + volId);
            if (!rs.next()) {
                PreparedStatement prd = dbcnx.connect().prepareStatement("insert into vol values(?,?,?,?,?,?,?,?)");
                prd.setInt(1, volId);
                prd.setString(2, vDepart);
                prd.setString(3, vArrive);
                prd.setString(4, heureDepart);
                prd.setString(5, heureArrive);
                prd.setString(6, type);
                prd.setInt(7, prix);
                prd.setInt(8, idavion);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ajouteraerport(String immatricule, String nomAero, String adresse, String pays) {
        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from aeroport where immatricule ='" + immatricule + "'");
            if (!rs.next()) {
                PreparedStatement prdstmnt = dbcnx.connect().prepareStatement("insert into aeroport values(?,?,?,?)");
                prdstmnt.setString(1, immatricule);
                prdstmnt.setString(2, nomAero);
                prdstmnt.setString(3, adresse);
                prdstmnt.setString(4, pays);
                prdstmnt.executeUpdate();
            }

        } catch (SQLException ex) {
            //Logger.getLogger(Aeroport.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void modif_aeroport(String immatricule, String nomAero, String adresse, String pays, boolean delete) {

        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from aeroport where immatricule=" + immatricule);
            if (rs.next()) {
                PreparedStatement prd;
                if (delete) {
                    prd = dbcnx.connect().prepareStatement("DELETE FROM aeroprot WHERE immatricule=" + immatricule);
                } else {
                    prd = dbcnx.connect().prepareStatement("UPDATE aeroprot SET nom = ?, adresse = ?, pays= ? WHERE immatricule=" + immatricule);
                }
                prd.setString(1, nomAero);
                prd.setString(2, adresse);
                prd.setString(3, pays);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
