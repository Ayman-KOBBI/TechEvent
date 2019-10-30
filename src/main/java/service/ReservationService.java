/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Organisateurs;
import entity.Participants;
import entity.Reservation;
import entity.ReservationEvent;
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
    public List<Reservation> afficherReservation(Organisateurs o) throws Exception {
      
      List<Reservation> Reservations = new ArrayList<>();
      Reservation r = null ;
      
      String req2="select * from reservation r "
              + "INNER join events e ON "
              + "r.id_ev=e.id_ev "
              + "where e.id_org=?;";
              PreparedStatement rs = c.prepareStatement(req2);
        rs.setInt(1,o.getId_org());
      try {
          ResultSet res=  rs.executeQuery();
          while (res.next()) { 
              r = new Reservation();
             // p = new Participants();
                      r.setId_ticket( res.getInt("id_ticket"));
                      r.setId_ev(res.getInt("id_ev"));
                      r.setId_par(res.getInt("id_par"));
                      r.setNom( res.getString("nom") );
                      r.setPrenom(res.getString("prenom"));
                      r.setnom_event(res.getString("nom_event"));
              Reservations.add(r);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        System.out.println(Reservations);
     return Reservations;
    }
    
     @Override
    public List<ReservationEvent> afficherReservationPar(Participants p) throws Exception {
      
      List<ReservationEvent> Event = new ArrayList<>();
      Reservation r = null ;
      ReservationEvent e = null;
    
      
      String req3="select * from reservation r "
              + "INNER join events e ON "
              + "r.id_ev=e.id_ev "
              + "where r.id_par=?;";
              PreparedStatement rs = c.prepareStatement(req3);
        rs.setInt(1,p.getId_par());
      try {
          ResultSet res=  rs.executeQuery();
          while (res.next()) { 
              e  = new ReservationEvent();
             // p = new Participants();
                      e.setId_ev(res.getInt("id_ev"));
                       e.setId_org(res.getInt("Id_org"));
                      e.setNom_org(res.getString("nom_org"));
                      e.setDescription(res.getString("Description") );
                      e.setLieu(res.getString("lieu"));
                      e.setDt_event(res.getDate("dt_event"));
                      e.setEtat(res.getString("etat"));
                      e.setPrix(res.getInt("prix"));
                      e.setNb_place(res.getInt("nb_place"));
                      e.setNom_event(res.getString("nom_event"));
                      e.setId_ticket(res.getInt("id_ticket"));
              Event.add(e);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        System.out.println(Event);
     return Event;
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
        
        ReservationEvent e=new ReservationEvent();
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

         
            e.setNom_org(res2.getString("nom_org"));

            
            e.setId_org(res2.getInt("Id_org"));

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
     public List<Reservation> chercher(String nom_ev){
         Reservation r = null ;
        String req="select * from reservation where nom_event like '"+nom_ev+"'";
        List<Reservation> Reservations=new ArrayList<>();
        try {
             ResultSet res=  ste.executeQuery(req);
            //
            while(res.next()){
                r = new Reservation();
                      r.setId_ticket( res.getInt("id_ticket"));
                      r.setId_ev(res.getInt("id_ev"));
                      r.setId_par(res.getInt("id_par"));
                      r.setNom( res.getString("nom") );
                      r.setPrenom(res.getString("prenom"));
                      r.setnom_event(res.getString("nom_event"));
              
                      
              Reservations.add(r);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return Reservations;
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
     @Override
    public void supprimerReservationEv(ReservationEvent e) {
         try {
            String req1="delete from reservation where"
                    + " id_ticket=?";
       
      PreparedStatement rs = c.prepareStatement(req1);
            rs.setInt(1, e.getId_ticket());
            rs.executeUpdate();
            
            String req_update_nbrplace="UPDATE events SET nb_place=? WHERE(id_ev=?);";
         PreparedStatement rs3 = c.prepareStatement(req_update_nbrplace);
         rs3.setInt(1, e.getNb_place()+1);
         rs3.setInt(2, e.getId_ev());
         rs3.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override   
     public List<ReservationEvent> chercherEv(String nom_e){
         ReservationEvent p = null ;
        String req="select * from events where nom_event like '"+nom_e+"'";
        List<ReservationEvent> event=new ArrayList<>();
        try {
             ResultSet rs=  ste.executeQuery(req);
            //
            while(rs.next()){
                p = new ReservationEvent();
                      p.setId_ev(rs.getInt("id_ev"));
                      p.setNom_org(rs.getString("nom_org"));
                      p.setDescription(rs.getString("Description") );
                      p.setLieu(rs.getString("lieu"));
                      p.setDt_event(rs.getDate("dt_event"));
                      p.setEtat(rs.getString("etat"));
                      p.setPrix(rs.getInt("prix"));
                      p.setNb_place(rs.getInt("nb_place"));
                      p.setNom_event(rs.getString("nom_event"));
System.out.println("evenement trouvé \n");
                      
              event.add(p);
               
             // list.add(new Events(rs.getString("nom_org"),rs.getString("nom_event"),rs.getString("lieu"),rs.getInt("nb_place"),rs.getDate("dt_event"),rs.getString("h_event"),rs.getInt("Nb_place"),rs.getString("description")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return event;
}
    
    
     
}
