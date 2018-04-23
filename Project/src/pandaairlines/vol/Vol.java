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
    private int prix;
    private ArrayList<Escale> Escales;

    public Vol() {
    }

    public Vol(int volId, String vDepart, String vArrive, String heureDepart, String heureArrive, int prix, ArrayList<Escale> Escales) {
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

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureArrive() {
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

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setEscales(ArrayList<Escale> Escales) {
        this.Escales = Escales;
    }

    static public void ajouterClient(int idclient, int vol) {
        dbcnx.connecter();
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

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
