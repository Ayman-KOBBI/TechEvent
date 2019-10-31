/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utils.ConnexionBD;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Participants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ParticipantService {
      Connection connection = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
      public void ajouterPart(Participants p) {
        try {
            Statement st = connection.createStatement();
            String req = "insert into participant (`nom`, `prenom`, `email`, `tel`,`mdp`, `solde`) values ('" +p.getNom()+ "','" + p.getPrenom()+ "','" + p.getEmail()+ "','" + p.getTel()+ "','" + p.getMdp()+ "','"+p.getSolde()+"')";
            st.execute(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
      public ArrayList<Participants> aaficherPart() {
        ArrayList<Participants> l = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String req = "select * from participant";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {
                l.add(new Participants(rs.getInt("id_par"),rs.getString("nom"),rs.getString("prenom"),
                        rs.getString("email"),rs.getString("tel"),
                        rs.getInt("solde"),
                        rs.getString("mdp")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }
      
     
    public void SetJetons(Participants p,boolean flag,int n) throws Exception{
        if (flag){
            if (p.getSolde()+n>=0)  
                p.setSolde(p.getSolde()+n);
            else
                throw new Exception("Solde insuffisant");
        }else{
            if (n>=0)    
                p.setSolde(n);
            }
    }
 
      
     public void supprimerPart(int id) {
        try {
            PreparedStatement pt = connection.prepareStatement("delete from participant where id_par=?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
      
}
