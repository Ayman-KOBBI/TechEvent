/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.commentaire;
import iservice.IcommentaireService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;
/**
 *
 * @author oussama
 */
public class commentaireService implements IcommentaireService {
    
 Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    public commentaireService() 
    {
       try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
        @Override
        public void ajoutercomm(commentaire m) {
        try {
            String req1="INSERT INTO `commentaire` "
                    + "(`id_article`,`date_comm`,`heure_comm`,`Text`) "
                    + "VALUES ( "+m.getId_article()+","+m.getDate_comm()+","+m.getHeure_comm()+","+m.getText()+");";
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void supprimercomm(commentaire m) {
        try {
            String req1="delete from commentaire where"
                    + " id_comm=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, m.getId_comm());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        @Override
    public List<commentaire> affichercomm() {
      
      List<commentaire> commentaires = new ArrayList<>();
      commentaire m = null ;
      String req2="select date_comm, heure_comm, Text from commentaire";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              m = new commentaire();
                    
                      m.setDate_comm(res.getDate("date_comm"));
                      m.setHeure_comm(res.getTime("heure_comm"));
                      m.setText(res.getString("Text"))  ; 
                      
              commentaires.add(m);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return commentaires;
    }
    @Override
    public void modifiercomm(commentaire m){
         try{
            PreparedStatement as = c.prepareStatement("update commentaire set date_comm=?,heure_comm=?,Text=?");
            as.setString(1, m.getDate_comm());
            as.setString(2, m.getHeure_comm());
            as.setString(3, m.getText());
            
            as.executeUpdate();
            
             }catch(SQLException e) { System.out.println(" Erreur modif " + e);}
    }
    }


