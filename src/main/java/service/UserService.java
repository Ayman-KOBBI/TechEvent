/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class UserService {
        Connection connection = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    public void AjoutUser(User u) {
        try {

            Statement st = connection.createStatement();
            String req = "INSERT INTO `user`(`login`, `mdp`, `role`) VALUES ('" + u.getLogin()+ "','" + u.getMdp()+ "','" + u.getRole()+ "')";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
       public void modifierDetail( String mdp, String login,String mail,String pwd) {

        try {
            PreparedStatement st = connection.prepareStatement("UPDATE user SET login= ? , mdp=? WHERE login=? and mdp=?");
            
            st.setString(1, login);
            st.setString(2, mdp);
            st.setString(3,pwd);
            st.setString(4,mail);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
       
      public void supprimerJUser(String login , String pass) {
        try {
            PreparedStatement pt = connection.prepareStatement("delete from user where login=? and mdp=?");
            pt.setString(1, login);
            pt.setString(2, pass);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
       
       public String seConnecter(String login , String pwd) {

        try {

            Statement st = connection.createStatement();
            String req = "SELECT * from user where login='" + login + "' ";
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                if(res.getString("mdp").equals(pwd))
                    return res.getString("role");
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
     public boolean verifyPass(String username, String password) {
        try {
            Statement st = connection.createStatement();
            String req = "SELECT mdp from user where login='" + username + "' ";
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
               if (res.getString("mdp").equals(password)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
       
       
}
