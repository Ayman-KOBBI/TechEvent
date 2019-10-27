/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Events;
import entity.Participants;
import entity.Reservation;
import iservice.IReservationService;
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
 * @author ASUS
 */
public class ReservationService implements IReservationService{
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
     public ReservationService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     @Override
    public List<Reservation> afficherReservation() {
      
      List<Reservation> Reservations = new ArrayList<>();
      Reservation r = null ;
      String req2="select * from reservation";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              r = new Reservation();
             // p = new Participants();
                      r.setId_ticket( res.getInt("id_ticket"));
                      r.setId_ev(res.getInt("id_ev"));
                      r.setId_par(res.getInt("id_par"));
                      r.setNom( res.getString("nom") );
                      r.setPrenom(res.getString("prenom"));
                      r.setnom_event("nom_event");
              Reservations.add(r);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return Reservations;
    }

    @Override
    public void ajouterReservation(Reservation r) throws Exception {
        Participants p=new Participants();
        String requete_solde_part="Select * from participant where id_par=?;";
        PreparedStatement rs = c.prepareStatement(requete_solde_part);
        rs.setInt(1, r.getId_par());
        try{    
            ResultSet res= rs.executeQuery();
            res.next();
            p.setSolde(res.getInt("solde"));
            p.setNom(res.getString("nom"));
            p.setPrenom(res.getString("prenom"));
            p.setId_par(res.getInt("id_par"));
            p.setTel(res.getString("tel"));
            p.setEmail(res.getString("email"));
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println(p);
        
        Events e=new Events();
        String requete_prix_event="Select * from events where id_ev=?;";
        PreparedStatement rs1 = c.prepareStatement(requete_prix_event);
        rs1.setInt(1, r.getId_ev());
        
         try{    
            ResultSet res2= rs1.executeQuery();
            res2.next();
            e.setPrix(res2.getInt("prix"));
            e.setDescription(res2.getString("Description"));
            e.setDt_event(res2.getDate("dt_event"));
            e.setId_ev(res2.getInt("id_ev"));
            e.setH_event(res2.getString("H_event"));
            e.setNom_org(res2.getString("Id_org"));
            e.setNom_event(res2.getString("nom_event"));
            e.setLieu(res2.getString("lieu"));
            e.setNb_place(res2.getInt("Nb_place"));
                 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }     
        
        ParService par1=new ParService();
        par1.SetJetons(p, true, -e.getPrix());
         String req_update_solde="UPDATE participant SET solde=? WHERE(id_par=?);";
         PreparedStatement rs2 = c.prepareStatement(req_update_solde);
         rs2.setInt(1, p.getSolde());
         rs2.setInt(2, p.getId_par());
         rs2.executeUpdate();
         
         if (e.getNb_place()-1<0){
             throw new Exception("nbr de places insuffisant");
         }
         
         String req_update_nbrplace="UPDATE events SET nb_place=? WHERE(id_ev=?);";
         PreparedStatement rs3 = c.prepareStatement(req_update_nbrplace);
         rs3.setInt(1, e.getNb_place()-1);
         rs3.setInt(2, e.getId_ev());
         rs3.executeUpdate();
         
         
    //    ste.executeUpdate(req_update_solde);   
        try {
            String req1="INSERT INTO `reservation` "
                    + "(`id_ev`,`id_par`,`nom`, `prenom`,`nom_event`) "
                    + "VALUES ( "
                    + ""+r.getId_ev()+","+r.getId_par()+",'"+r.getNom()+"','"
                    +r.getPrenom()+"','"+r.getnom_event()+"');";
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public void supprimerReservation(Reservation r) {
         try {
            String req1="delete from reservation where"
                    + " id_ticket=?";
       
      PreparedStatement rs = c.prepareStatement(req1);
            rs.setInt(1, r.getId_ticket());
            rs.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
}
