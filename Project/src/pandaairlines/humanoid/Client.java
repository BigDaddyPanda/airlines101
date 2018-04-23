package pandaairlines.humanoid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.*;
import pandaairlines.db_cnx.dbcnx;
import pandaairlines.vol.Vol;

/**
 *
 * @author ky94
 */
public class Client {

    private SimpleIntegerProperty clientNum;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty dateNaissance;
    private SimpleStringProperty numeroPassport;

    public Client() {
        clientNum = null;
        nom = null;
        prenom = null;
        dateNaissance = null;
        numeroPassport = null;
    }

    public Client(Integer clientNum, String nom, String prenom, String dateNaissance, String numeroPassport) {
        this.clientNum = new SimpleIntegerProperty(clientNum);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.dateNaissance = new SimpleStringProperty(dateNaissance);
        this.numeroPassport = new SimpleStringProperty(numeroPassport);
    }

    public Integer getClientNum() {
        return clientNum.get();
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getDateNaissance() {
        return dateNaissance.get();
    }

    public String getNumeroPassport() {
        return numeroPassport.get();
    }

    public void setClientNum(Integer clientNum) {
        this.clientNum.set(clientNum);
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance.set(dateNaissance);
    }

    public void setNumeroPassport(String numeroPassport) {
        this.numeroPassport.set(numeroPassport);
    }

    static public void ajouterClient(String nom, String prenom, String date, String passport) {
        dbcnx.connecter();
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("insert into client values('?','?','?','?')");
            st.setString(0, nom);
            st.setString(1, prenom);
            Date d = java.sql.Date.valueOf(date);
            st.setDate(2, (java.sql.Date) d);
            st.setString(3, passport);
            st.executeUpdate();
        } catch (SQLException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    static public ArrayList afficherClient() {
        Client c = null;
        ArrayList<Client> l = new ArrayList<Client>();
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from client");

            while (rs.next()) {
                c.setClientNum(rs.getInt("idclient"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setDateNaissance(rs.getString("datenaissance"));
                c.setNumeroPassport(rs.getString("numeropasseport"));
                l.add(c);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (l.isEmpty()) {
            return null;
        } else {
            return l;
        }

    }

    static public Vol rechercherVol(int volID) {
        Vol v = null;
        try {
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from vol where idvol= " + volID);
            v.setVolId(volID);
            while (rs.next()) {

                v.setHeureArrive(rs.getTime("heurearrive").toString());
                v.setHeureDepart(rs.getTime("heuredepart").toString());
                v.setvArrive(rs.getString("arrive"));
                v.setvDepart(rs.getString("depart"));

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (v == null) {
            return null;
        } else {
            return v;
        }
    }

    static public void supprimerClient(int idvol, int num) {
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("delete from reservation where idclient = " + num + "and idvol= " + idvol);
            st.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static boolean login(String login, String pw) {
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("SELECT * FROM client WHERE numeropasseport = '" + login + "' AND password= '" + pw + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                dbcnx.identifier = rs.getInt("idclient");

                return true;
            }
        } catch (SQLException e) {
            System.out.println("Bad kittens not doing their jobs");
        }
        return false;
    }

}
