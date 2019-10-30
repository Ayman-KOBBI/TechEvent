/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Commentaire;
import entity.Forum;
import iservice.IcommentaireService;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
 @Override
        public void ajoutercomm(Commentaire m) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            Statement st=c.createStatement();
            String req1="INSERT INTO `commentaire` "
                    + "(`score`,`id_article`,`id_user`,`Text`,`date`) "
                    + "VALUES ( "+m.getScore()+","+m.getId_article()+","+m.getId_user()+",'"+m.getText()+"','"+m.getDate()+"');";
            
            
         
            st.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimercomm(int id_comm) {
       try {
            String req1="delete from forum where"
                    + " id_comm=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1,id_comm);
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 @Override
    public ArrayList<Commentaire> affichercomm(Forum f) 
            {
            ArrayList <Commentaire> mylist = new ArrayList();
        try {
            Statement st = c.createStatement();
            String req="select * from commentaire where id_article="+f.getId_article();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()) 
 {
 Commentaire a= new Commentaire(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
 String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate(6));
 a.setDate(date);
 a.setId_comm(rs.getInt(1));
 mylist.add(a);
 
 
 
 }
        } catch (SQLException ex) {
            Logger.getLogger(Commentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return mylist;
       }
    public void modifiercomm(int id_comm, String Text){
        try {
            PreparedStatement pt= c.prepareStatement("update commentaire set Text=? where id_comm=? ");
            pt.setString(1,Text);
            pt.setInt(2,id_comm);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void like ( Commentaire m)
    { 
    try {
            PreparedStatement pt= c.prepareStatement("update commentaire set score=? where id_comm=? ");
            pt.setInt(1,1+(m.getScore()));
          
            pt.setInt(2,m.getId_comm());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void dislike ( Commentaire m)
    { 
    try {
            PreparedStatement pt= c.prepareStatement("update commentaire set score=? where id_comm=? ");
            pt.setInt(1,(m.getScore())-1);
            pt.setInt(2,m.getId_comm());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
} 
      

       
    }
    
    
    


