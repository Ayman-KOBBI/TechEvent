/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utils.ConnexionBD;
import entity.Participants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Organisateurs;
/**
 *
 * @author DELL
 */
public class OrganisateurService {
    
     Connection connection = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
      public void ajouterOrg(Organisateurs p) {
        try {
            Statement st = connection.createStatement();
            String req = "insert into organisateur (`nom`, `prenom`, `email`, `tel`,`mdp`) values ('" +p.getNom()+ "','" + p.getPrenom()+ "','" + p.getEmail()+ "','" + p.getTel()+ "','" + p.getMdp()+"')";
            st.execute(req);
            
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
      public ArrayList<Organisateurs> aaficherOrg() {
        ArrayList<Organisateurs> l = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String req = "select * from organisateur";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {
                l.add(new Organisateurs(rs.getInt("id_org"),rs.getString("nom"),rs.getString("prenom"),
                        rs.getString("email"),rs.getString("tel"),
                        rs.getString("mdp")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }
 
      
     public void supprimerOrg(int id) {
        try {
            PreparedStatement pt = connection.prepareStatement("delete from organisateur where id_org=?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
   
     public void modifierOrg(int id,String nom, String prenom, String email, String tel,String mdp ) {
        try {
            PreparedStatement pt = connection.prepareStatement("update organisateur set nom=?, prenom=?, email=?, tel=?, mdp=? where id_org=?");
              pt.setString(1,nom);
              pt.setString(2, prenom);
              pt.setString(3, email);
              pt.setString(4, tel);
              pt.setString(5, mdp);
              pt.setInt(6, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
     
     
     
    
}
