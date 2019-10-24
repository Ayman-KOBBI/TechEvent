/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Forum;
import iservice.IforumService;
import java.sql.Connection;
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

    public void creerarticle(Forum f) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            String req1="INSERT INTO `forum` "
                    + "(`id_article`, `id_user`,`titre`,`image`,`description`,`date`) "
                    + "VALUES ( "+f.getId_article()+","+f.getid_user()+","+f.getTitre()+","+f.getImage()+","+f.getDescription()+","+f.getDate()+");";
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void supprimerarticle(int id_article) {
        try {
            String req1="delete from forum where"
                    + " id_article=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1,id_article);
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
     public void modifierarticle(int id_article, String description)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update forum set description=? where id_article=? ");
            pt.setString(1,description);
            pt.setInt(2,id_article);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void afficherarticle() {
      
      try {
            Statement st = c.createStatement();
            String req="select * from forum";
            ResultSet rs=st.executeQuery(req);
            while(rs.next()) {System.out.println("user id: "+rs.getInt(2)+" titre: "+rs.getString(3)+" description: "+rs.getString(5)+" date: "+rs.getDate(6)+" image: "+rs.getString(4));}
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public ArrayList<Forum> afficherarticles()
    {
        ArrayList <Forum> mylist = new ArrayList();
        try {
            Statement st = c.createStatement();
            String req="select * from post";
            ResultSet rs=st.executeQuery(req);
            while(rs.next()) 
 {
 Forum f = new Forum(rs.getInt(2),rs.getString(3),rs.getString(5),rs.getString(6));
 mylist.add(f);
 
 
 
 }
        } catch (SQLException ex) {
            Logger.getLogger(forumService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return mylist;
}
}


