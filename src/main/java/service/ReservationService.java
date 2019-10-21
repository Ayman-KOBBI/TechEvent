/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
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
              Reservations.add(r);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return Reservations;
    }

    @Override
    public void ajouterReservation(Reservation r) {
         try {
            String req1="INSERT INTO `reservation` "
                    + "(`id_ticket`,`id_ev`,`id_par`,`nom`, `prenom`,`image`) "
                    + "VALUES ( "
                    + ""+r.getId_ticket()+","+r.getId_ev()+","+r.getId_par()+",'"+r.getNom()+"','"
                    +r.getPrenom()+"','"+r.getImage()+"');";
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
