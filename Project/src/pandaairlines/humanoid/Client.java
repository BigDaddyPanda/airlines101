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

import aeroport.Client;
import aeroport.Connecter;
import pandaairlines.db_cnx.dbcnx;
import pandaairlines.vol.Vol;

/**
 *
 * @author ky94
 */
public class Client {
    private int clientNum;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroPassport;

    public Client(int clientNum, String nom, String prenom, Date dateNaissance, String numeroPassport) {
        this.clientNum = clientNum;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroPassport = numeroPassport;
    }

    public int getClientNum() {
        return clientNum;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getNumeroPassport() {
        return numeroPassport;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNumeroPassport(String numeroPassport) {
        this.numeroPassport = numeroPassport;
    }
    
    static public void ajouterClient(String nom,String prenom,String date,String passport) {
    	dbcnx.connecter();
    	try {
    		PreparedStatement st=dbcnx.conn.prepareStatement("insert into client values('?','?','?','?')");
    		
    		st.setString(0,nom);
    		st.setString(1, prenom);
    		Date d=java.sql.Date.valueOf(date);
    		st.setDate(2, (java.sql.Date) d);
    		st.setString(3, passport);
    		st.executeUpdate();
    	} catch (SQLException e) {
    		
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	
    }
    
    static public ArrayList afficherClient(){
    	dbcnx.connecter();
    	Client c = null;
    	ArrayList<Client> l=new ArrayList<Client>();
    	try {
    		Statement st=dbcnx.conn.createStatement();
    		
    		ResultSet rs=st.executeQuery("select * from client");
    	
    		while(rs.next()) {
    			c.setClientNum(rs.getInt("idclient"));
    			c.setNom(rs.getString("nom"));
    			c.setPrenom(rs.getString("prenom"));
    			c.setDateNaissance(rs.getDate("datenaissance"));
    			c.setNumeroPassport(rs.getString("numeropasseport"));
    			l.add(c);
    			
    			
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	if(l.isEmpty()) {
    		return null;
    	}else {
    	return l;}
        
    }
    static public Vol rechercherVol(int volID){
    	dbcnx.connecter();
    	Vol v=null;
    	try {
    		Statement st=dbcnx.conn.createStatement();
    		ResultSet rs=st.executeQuery("select * from vol where idvol= "+volID);
    		v.setVolId(volID);
    		while(rs.next()){
    			
    			v.setHeureArrive(rs.getTime("heurearrive").toString());
    			v.setHeureDepart(rs.getTime("heuredepart").toString());
    			v.setvArrive(rs.getString("arrive"));
    			v.setvDepart(rs.getString("depart"));
    			
    		}
    		
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	if(v==null) {
    		return null;
    	}else {
    	return v;
    	}
    }
    static public void supprimerClient(int idvol,int num) {
    	try {
    		PreparedStatement st=dbcnx.conn.prepareStatement("delete from reservation where idclient = "+num+"and idvol= "+idvol);
    	st.executeUpdate();
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	
    }
}
