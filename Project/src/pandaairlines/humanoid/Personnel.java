/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines.humanoid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import pandaairlines.db_cnx.dbcnx;

/**
 *
 * @author ky94
 */
public abstract class Personnel implements Salairie {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private int nbHeure;
    private float salaire;
    public Personnel(String nom, String prenom, Date dateNaissance, int nbHeure) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nbHeure = nbHeure;
    }
    @Override
    public float calculSalaire(){
        return salaire*nbHeure;
    }
    public static boolean login(String login,String pw) {
        try {
            PreparedStatement st = dbcnx.connect().prepareStatement("SELECT * FROM personnel WHERE login = '" + login + "' AND password= '" + pw+"'");
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                dbcnx.identifier=rs.getInt("idpersonnel");
                return true;
            }
        }
        catch(SQLException e){
            System.out.println("Bad kittens not doing their jobs");
        }
        return false;
    }
    
    public static ArrayList loadFlight(){
        
    }
}
