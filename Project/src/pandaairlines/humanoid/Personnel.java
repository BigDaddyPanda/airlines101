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
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import pandaairlines.avion.Avion;
import pandaairlines.db_cnx.dbcnx;
import pandaairlines.vol.Vol;

/**
 *
 * @author ky94
 */
public class Personnel implements Salairie {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String fonction;
    private String login;
    private String password;
    private int nbHeure;
    private int salaire;
    private SimpleStringProperty snom;
    private SimpleStringProperty sprenom;
    private SimpleStringProperty sdateNaissance;
    private SimpleStringProperty sfonction;
    private SimpleStringProperty slogin;
    private SimpleStringProperty spassword;
    private SimpleIntegerProperty snbHeure;
    private SimpleIntegerProperty ssalaire;

    public Personnel(boolean display, String nom, String prenom, String dateNaissance, String fonction, String login, String password, int nbHeure, int salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.fonction = fonction;
        this.login = login;
        this.password = password;
        this.nbHeure = nbHeure;
        this.salaire = salaire;
        if (display) {
            snom = new SimpleStringProperty(nom);
            sprenom = new SimpleStringProperty(prenom);
            sdateNaissance = new SimpleStringProperty(dateNaissance);
            sfonction = new SimpleStringProperty(fonction);
            slogin = new SimpleStringProperty(login);
            spassword = new SimpleStringProperty(password);
            snbHeure = new SimpleIntegerProperty(nbHeure);
            ssalaire = new SimpleIntegerProperty(salaire);
        }
    }

    @Override
    public float calculSalaire() {
        return salaire * nbHeure;
    }

    public static boolean login(String login, String pw) {
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("SELECT * FROM personnel WHERE login = '" + login + "' AND password= '" + pw + "'");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                dbcnx.identifier = rs.getInt("idpersonnel");
                dbcnx.username = rs.getString("nom")+" "+rs.getString("prenom");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Bad kittens not doing their jobs");
        }
        return false;
    }

    public static ArrayList loadFlight(String req, boolean isAdmin) {
        ArrayList<Vol> A = new ArrayList();
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("SELECT * FROM vol WHERE 1");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //idvol depart arrive heuredepart heurearrive prix idavion
                A.add(new Vol(true, rs.getInt("idvol"),
                        rs.getString("depart"),
                        rs.getString("arrive"),
                        rs.getString("heuredepart"),
                        rs.getString("heurearrive"),
                        rs.getInt("idavion"),
                        rs.getInt("prix")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bad kittens not doing their jobs");
        }
        return A;
    }

    public static ArrayList loadPersonnel(String req, boolean isAdmin) {
        ArrayList<Personnel> A = new ArrayList();
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("SELECT * FROM personnel WHERE 1");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //idvol depart arrive heuredepart heurearrive prix idavion
                A.add(new Personnel(true,
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("datenaissance"),
                        rs.getString("fonction"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("salaire"),
                        rs.getInt("nbHeure")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bad kittens not doing their jobs");
        }
        return A;
    }

    public static ArrayList loadAv(String req, boolean isAdmin) {
        ArrayList<Avion> A = new ArrayList();
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("SELECT * FROM avion WHERE " + req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //idvol depart arrive heuredepart heurearrive prix idavion

                A.add(new Avion(true,
                        rs.getString("idavion"),
                        rs.getString("nom"),
                        rs.getString("marque"),
                        rs.getString("companie"),
                        rs.getString("type"),
                        rs.getInt("nombrepassager") + "/" + rs.getInt("nombrepersonnel"),
                        rs.getInt("massemax") + "/" + rs.getInt("volumemax")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bad kittens not doing their jobs");
        }
        return A;
    }

    public static boolean addPerso(String nom, String prenom, String dateNaissance, String fonction, String login, String password, int nbHeure, float salaire) {

        try {
            String req = "INSERT INTO `personnel` "
                    + "( nom, prenom, dateNaissance, salaire, "
                    + "nbHeure, fonction, login, password) "
                    + "VALUES ( ?, ?, ?, ?, "
                    + "?, ?, ?, ?)";
            Statement st = dbcnx.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from personnel where login='" + login + "'");
            System.out.println("sdsd");
            if (!rs.next()) {
                PreparedStatement prd = dbcnx.connect().prepareStatement(req);
                prd.setString(1, nom);
                prd.setString(2, prenom);
                prd.setString(3, dateNaissance);
                prd.setFloat(4, salaire);
                prd.setInt(5, nbHeure);
                prd.setString(6, fonction);
                prd.setString(7, login);
                prd.setString(8, password);

                prd.execute();
                return true;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return false;
    }

}
