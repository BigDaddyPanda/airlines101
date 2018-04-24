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
    private float salaire;

    public Personnel(String nom, String prenom, String dateNaissance, String fonction, String login, String password, int nbHeure, float salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.fonction = fonction;
        this.login = login;
        this.password = password;
        this.nbHeure = nbHeure;
        this.salaire = salaire;
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
            PreparedStatement st = dbcnx.
                    connect().prepareStatement("SELECT * FROM vol WHERE '"
                            + req + "' ");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                A.add(new Vol(rs.getInt(""), rs.getString("depart"),
                        rs.getString("arrive"),
                        rs.getTime("heuredepart").toString(),
                        rs.getTime("heurearrive").toString(),
                        rs.getString("type"), rs.getInt("prix")));
            }
        } catch (SQLException e) {
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
