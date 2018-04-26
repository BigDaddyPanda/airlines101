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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
    private int immatricule;
    private String type;
    private int prix;

    private SimpleIntegerProperty svolId;
    private SimpleStringProperty svDepart;
    private SimpleStringProperty svArrive;
    private SimpleStringProperty sheureDepart;
    private SimpleStringProperty sheureArrive;
    private SimpleIntegerProperty simmatriculeAv;
    private SimpleStringProperty stype;
    private SimpleIntegerProperty sprix;

    public Vol() {
    }

    public Vol(boolean fordisplay, int volId, String vDepart, String vArrive, String heureDepart, String heureArrive, int immatricule, int prix) throws SQLException {
        this.volId = volId;
        this.vDepart = vDepart;
        this.immatricule = immatricule;
        this.type = Avion.getAvionType(immatricule);
        this.vArrive = vArrive;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.prix = prix;
        if (fordisplay) {
            this.svolId = new SimpleIntegerProperty(this.volId);
            this.svDepart = new SimpleStringProperty(this.vDepart);
            this.stype = new SimpleStringProperty(this.type);
            this.simmatriculeAv = new SimpleIntegerProperty(this.immatricule);
            this.svArrive = new SimpleStringProperty(this.vArrive);
            this.sheureDepart = new SimpleStringProperty(this.heureDepart);
            this.sheureArrive = new SimpleStringProperty(this.heureArrive);
            this.sprix = new SimpleIntegerProperty(this.prix);
        }
    }

    static public void ajouterClient(int idclient, int vol) {
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from reservation where idclient= " +
                    idclient + "idvol=" + vol);
            if (rs.wasNull()) {
                PreparedStatement s = dbcnx.connect().prepareStatement("insert into reservation values(?,?,'?',?)");
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
//                System.err.println(sdf.format(System.currentTimeMillis()));
//                Timestamp t = new Timestamp(System.currentTimeMillis());
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

    public static Vol recherchevol(int volid) {
        Vol v = new Vol();
        try {

            Statement st = dbcnx.connect().createStatement();
            ResultSet result = st.executeQuery("select * from vol where idvol=" + volid);
            if (result.next()) {
                v = new Vol(true,result.getInt("idvol"), result.getString("depart"), result.getString("arrive"), result.getString("heuredepart"), result.getString("heurearrive"), result.getInt("idavion"), result.getInt("prix"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public static ArrayList rechercherVols() {
        ArrayList<Vol> a = new ArrayList();
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet result = st.executeQuery("select * from vol ");
            while (result.next()) {
                a.add(new Vol(true,result.getInt("idvol"), result.getString("depart"), result.getString("arrive"), result.getString("heuredepart"), result.getString("heurearrive"), result.getInt("idavion"), result.getInt("prix")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    /*
     
     
     
     
     */
    public String getType() {
        return type;
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

    @Override
    public String toString() {
        return "Vol{" + "volId=" + volId + ", vDepart=" + vDepart + ", vArrive=" + vArrive + ", heureDepart=" + heureDepart + ", heureArrive=" + heureArrive + ", immatricule=" + immatricule + ", type=" + type + ", prix=" + prix + ", svolId=" + svolId + ", svDepart=" + svDepart + ", svArrive=" + svArrive + ", sheureDepart=" + sheureDepart + ", sheureArrive=" + sheureArrive + ", simmatriculeAv=" + simmatriculeAv + ", stype=" + stype + ", sprix=" + sprix + '}';
    }

    public Integer getSvolId() {
        return svolId.get();
    }

    public String getSvDepart() {
        return svDepart.get();
    }

    public SimpleStringProperty getSvArrive() {
        return svArrive;
    }

    public SimpleStringProperty getSheureDepart() {
        return sheureDepart;
    }

    public SimpleStringProperty getSheureArrive() {
        return sheureArrive;
    }

    public SimpleIntegerProperty getSimmatriculeAv() {
        return simmatriculeAv;
    }

    public SimpleStringProperty getStype() {
        return stype;
    }

    public SimpleIntegerProperty getSprix() {
        return sprix;
    }

}
