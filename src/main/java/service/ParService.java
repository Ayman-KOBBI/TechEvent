/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Participants;
import iservice.IParService;
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
public class ParService implements IParService{
   Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public ParService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    } 
    
    @Override
    
    public List<Participants> afficherPar() {
      
      List<Participants> par = new ArrayList<>();
      Participants o = null ;
      String req2="select * from participant";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              o = new Participants();
                      o.setId_par( res.getInt("id_par"));
                      o.setNom( res.getString("nom") );
                      o.setPrenom(res.getString("prenom"));
                      o.setEmail(res.getString("email"));
                      o.setTel(res.getString("tel"));
                      o.setSolde(res.getInt("solde"));
              par.add(o);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return par;
    }
    public ArrayList<Participants> getAllMembers() throws SQLException {
        ArrayList<Participants> retour = new ArrayList<>();
        Statement stm = c.createStatement();
        String req = "SELECT * FROM participant ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          int id_par= resultat.getInt(1);
           //String login=resultat.getString("username");
           //String mdp=resultat.getString("password");
           String email=resultat.getString("email");
            String nom = resultat.getString("nom");
           String prenom= resultat.getString("prenom");
           String tel = resultat.getString("tel");
           retour.add(new Participants(id_par,email, prenom, nom, tel));
           
        }
      return retour;
    }
    
    /**
     *
     * @param par
     * @throws SQLException
     */
    @Override
    public void creerPar(Participants par) throws SQLException{ 


        String req="INSERT INTO participant(id_par,nom,prenom,email,tel,solde) VALUES (?,?,?,?,?,?)";
        PreparedStatement pres=c.prepareStatement(req);
        pres.setInt(1,par.getId_par() );
        pres.setString(2,par.getNom() );
        pres.setString(3,par.getPrenom());
        pres.setString(4,par.getEmail() );
        pres.setString(5,par.getTel() );
        pres.setInt(6,par.getSolde() );
        pres.executeUpdate();
        System.out.println(pres.executeUpdate());
        System.out.println("element inserer");
    }
    
    @Override
    public void modifierPar(Participants par) throws SQLException{
        
        String req="UPDATE participant SET id_par=?,nom=?,prenom=?,email=?,tel=?,solde=? WHERE id_par=? ";
        PreparedStatement pres=c.prepareStatement(req);
        pres.setInt(1,par.getId_par() );
        pres.setString(2,par.getNom() );
        pres.setString(3,par.getPrenom());
        pres.setString(4,par.getEmail() );
        pres.setString(5,par.getTel() );
        pres.setInt(6,par.getSolde() );
        pres.setInt(7,par.getId_par() );
        pres.executeUpdate();
        System.out.println(pres.executeUpdate());

        System.out.println("element modifier");
    }



    @Override
    public void supprimerPar(Participants p) {
        try {
            String req1="delete from participant where"
                    + " id_par=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, p.getId_par());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(OrgService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // methode pour gestion de reservation
    @Override
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
    public Participants getpar(String email) throws SQLException {
        Statement stm = c.createStatement();
        String req = "SELECT * FROM `participant` WHERE email='"+email+"' ";
        ResultSet resultat = stm.executeQuery(req);
        while(resultat.next()){
          int id_par= resultat.getInt(1);
            String nom = resultat.getString("nom");
           String prenom= resultat.getString("prenom");
           String tel=resultat.getString("tel");
           int solde=resultat.getInt("solde");

         return (new Participants(id_par, prenom, nom,tel,email,solde));
            
        }
         return null;
    
}
    
}
