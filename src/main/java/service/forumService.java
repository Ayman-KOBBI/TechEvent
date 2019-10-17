/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.forum;
import iservice.IforumService;
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
public class forumService implements IforumService {
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    public forumService() 
    {
       try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
        @Override

    public void creerarticle(forum f) {
        try {
            String req1="INSERT INTO `forum` "
                    + "(`id_ev`, `id_org`,`date_cr`,`heure_cr`,`lieu`,`image`,`description`) "
                    + "VALUES ( "+f.getId_ev()+","+f.getId_org()+","+f.getDate_cr()+","+f.getHeure_cr()+","+f.getLieu()+","+f.getImage()+","+f.getDescription()+");";
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void supprimerarticle(forum f) {
        try {
            String req1="delete from forum where"
                    + " id_article=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, f.getId_article());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
     public void modifierarticle(forum f){
     throw new UnsupportedOperationException("Not supported yet.");   
    }
        @Override
    public List<forum> afficherarticle() {
      
      List<forum> articles = new ArrayList<>();
      forum f = null ;
      String req2="select * from forum";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              f = new forum();
                      f.setId_article( res.getInt("id_article"));
                      f.setId_ev( res.getInt("id_ev") );
                      f.setId_org(res.getInt("id_org"));
                      f.setDate_cr(res.getDate("date_cr"));
                      f.setHeure_cr(res.getTime("heure_cr"));
                      f.setLieu(res.getString("lieu"))  ; 
                      f.setImage(res.getString("image"));
                      f.setDescription(res.getString("description"));
              articles.add(f);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return articles;
    }
    }


