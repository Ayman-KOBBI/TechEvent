/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Organisateurs;
import iservice.IOrgService;
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
 * @author asus
 */
public class OrgService implements IOrgService{
   Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public OrgService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    } 
    
    @Override
    
    public List<Organisateurs> afficherOrg() {
      
      List<Organisateurs> org = new ArrayList<>();
      Organisateurs o = null ;
      String req2="select * from Organisateur";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              o = new Organisateurs();
                      o.setId_org( res.getInt("id_org"));
                      o.setNom( res.getString("nom") );
                      o.setPrenom(res.getString("prenom"));
                      o.setEmail(res.getString("email"));
                      o.setTel(res.getString("tel"));
              org.add(o);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return org;
    }

    /**
     *
     * @param org
     * @throws SQLException
     */
    @Override
    /*public void creerOrg(Organisateurs org) {
        try {
            String req1="INSERT INTO Organisateur "
                    + "(id_org,'nom', 'prenom', 'email', 'tel') "
                    + "VALUES ( "+org.getId_org()+", "
                    +org.getNom()+", "+org.getPrenom()+", "+org.getEmail()+", "+org.getTel()+");";
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(OrgService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void creerOrg(Organisateurs org) throws SQLException{ 


        String req="INSERT INTO organisateur(id_org,nom,prenom,email,tel) VALUES (?,?,?,?,?)";
        PreparedStatement pres=c.prepareStatement(req);
        pres.setInt(1,org.getId_org() );
        pres.setString(2,org.getNom() );
        pres.setString(3,org.getPrenom());
        pres.setString(4,org.getEmail() );
        pres.setString(5,org.getTel() );  
        pres.executeUpdate();
        System.out.println(pres.executeUpdate());
        System.out.println("element inserer");
    }
    
    @Override
    public void modifierOrg(Organisateurs org) throws SQLException{
        
        String req="UPDATE organisateur SET id_org=?,nom=?,prenom=?,email=?,tel=? WHERE id_org=? ";
        PreparedStatement pres=c.prepareStatement(req);
        pres.setInt(1,org.getId_org() );
        pres.setString(2,org.getNom() );
        pres.setString(3,org.getPrenom());
        pres.setString(4,org.getEmail() );
        pres.setString(5,org.getTel() );
        pres.setInt(6,org.getId_org() );
        pres.executeUpdate();
        System.out.println(pres.executeUpdate());

        System.out.println("element modifier");
    }



    @Override
    public void supprimerOrg(Organisateurs p) {
        try {
            String req1="delete from organisateur where"
                    + " id_org=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, p.getId_org());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(OrgService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
