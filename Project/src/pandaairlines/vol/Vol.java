/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.vol;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pandaairlines.avion.Avion;

import pandaairlines.db_cnx.dbcnx;
import pandaairlines.humanoid.Client;

/**
 *
 * @author ky94
 *
 */
public class Vol {

    private int volId;
    private String vDepart;
    private String vArrive;
    private String heureDepart;
    private String heureArrive;
    private String type;
    private Avion avion;
    private int prix;

    public Vol() {
    }

    public Vol(int volId, String vDepart, String vArrive, String heureDepart, String heureArrive, String type, int prix) {
        this.volId = volId;
        this.vDepart = vDepart;
        this.type = type;
        this.vArrive = vArrive;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.prix = prix;

    }

    public String getType() {
        return type;
    }

    public Avion getAvion() {
        return avion;
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

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureArrive() {
        return heureArrive;
    }

    public int getPrix() {
        return prix;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
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

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    static public void ajouterClient(int idclient, int vol) {
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from reservation where idclient= " + idclient + "idvol=" + vol);
            if (rs.wasNull()) {
                PreparedStatement s = dbcnx.connect().prepareStatement("insert into reservation values(?,?,'?',?)");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
                System.err.println(sdf.format(System.currentTimeMillis()));
                Timestamp t = new Timestamp(System.currentTimeMillis());
                s.setInt(0, idclient);
                s.setInt(1, vol);
                s.executeUpdate();

            } else {
                return;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public static ArrayList rechercherClient(int num) {
//        ArrayList a = null;
//        Client c = null;
//        try {
//
//            Statement st = dbcnx.connect().createStatement();
//            ResultSet rs = st.executeQuery("select * from client where idclient=" + num);
//            if (rs.next()) {                
//                a.add(c);
//                Statement stmnt = dbcnx.connect().createStatement();
//                ResultSet res = stmnt.executeQuery("select count(*) from reservation where idclient=" + num);
//                if (res.next()) {
//                    a.add(res.getInt(0));
//                } else {
//                    a.add(0);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return a;
//    }

    public static ArrayList rechercherReserves(int volId) {
        ArrayList<Client> a = new ArrayList();
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from reservation where idvol=" + volId);
            if (rs.next()) {
                a.add(new Client(rs.getInt("idclient")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
