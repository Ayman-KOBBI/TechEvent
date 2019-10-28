/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entity.Events;
import iservice.IEventService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.JOptionPane;
import utils.ConnexionBD;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.java2d.pipe.SpanShapeRenderer;
/**
 *
 * @author asus
 */
public class EventService implements IEventService{
     Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    Events e ;
 
   

    public EventService() {
        try {
        ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void creerEvent(Events e) throws SQLException{
                   
 Date dt_event = Calendar.getInstance().getTime();
    SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
    
    //Time h_event = Calendar.getInstance().getTime();
    ///SimpleTimeFormat format3=new SimpleTimeFormat("hh:mm:ss");
 

String req="INSERT INTO events(id_ev,nom_org,nom_event,lieu,nb_place,dt_event,prix,description,etat) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pres=c.prepareStatement(req);
        pres.setInt(1,e.getId_ev() );
        pres.setString(2,e.getNom_org() );
        pres.setString(3,e.getNom_event());
        pres.setString(4,e.getLieu());
        pres.setInt(5,e.getNb_place());
        pres.setDate(6, (java.sql.Date) e.getDt_event());
        pres.setString(9,e.getEtat());
        pres.setInt(7,e.getPrix());  
          
        pres.setString(8,e.getDescription());  
        pres.executeUpdate();
       // System.out.println(pres.executeUpdate());
        System.out.println("element inserer");
    }

    @Override
    public void modifEvent(Events e) {    
        Date dt_event = Calendar.getInstance().getTime();
    SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String sql = "UPDATE events SET nom_org=?,lieu=?, nb_place=?,"
            + "  dt_event=?,etat=?,prix=?, description=? where nom_event=?";
 
        PreparedStatement pres;
          

         try {
             pres = c.prepareStatement(sql);
        pres.setString(1,e.getNom_org() );
        pres.setString(8,e.getNom_event()); 
        pres.setString(2,e.getLieu());
        pres.setInt(3,e.getNb_place());
        pres.setDate(4, (java.sql.Date) e.getDt_event());
        pres.setString(5,e.getEtat());
        pres.setInt(6,e.getPrix());  
        
        pres.setString(7,e.getDescription());
       // pres.setInt(9,e.getId_ev());
             System.out.println(e.getId_ev());
        pres.executeUpdate();
     
           System.out.println("L'evenement a été modifier avec succès");
          
         } catch (SQLException ex) {
            System.out.println(ex);

         }
     
    }

    @Override
    public void supprEvent(Events e) {
     try {
            String req1="delete from events where"
                    + " id_ev=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, e.getId_ev());
            ps.executeUpdate();
         System.out.println("evenement supprimer");
           
        } catch (SQLException ex) {
            System.out.println("Impossible de supprimer cet article\n");
        }
  
    }

     @Override   
     public List<Events> chercher(String nom_e){
         Events p = null ;
        String req="select * from events where nom_event like '"+nom_e+"'";
        List<Events> event=new ArrayList<>();
        try {
             ResultSet rs=  ste.executeQuery(req);
            //
            while(rs.next()){
                p = new Events();
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

    @Override
    public List<Events> affichierEvent() {
 
      List<Events> event = new ArrayList<>();
      Events p = null ;
      String req2="SELECT * FROM `events` ";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              p = new Events();
                      p.setId_ev(res.getInt("id_ev"));
                      p.setNom_org(res.getString("nom_org"));
                      p.setDescription(res.getString("Description") );
                      p.setLieu(res.getString("lieu"));
                      p.setDt_event(res.getDate("dt_event"));
                      p.setEtat(res.getString("etat"));
                      p.setPrix(res.getInt("prix"));
                      p.setNb_place(res.getInt("nb_place"));
                      p.setNom_event(res.getString("nom_event"));

                      
              event.add(p);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
          }
             
     return event;
    }     

   /* private int id_ev() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
     @Override
    public void AccepterEvent(Events e){
        
          try {
            String update = "UPDATE events SET  nom_event = ?, etat=? WHERE nom_event = ? ";
            PreparedStatement st2 = c.prepareStatement(update);
            st2.setString(1, e.getNom_event());
            st2.setString(2, "Accepte");
            st2.setString(3, e.getNom_event());
            st2.executeUpdate();
            System.out.println("" + e.getNom_event() + " successfully modified!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + e.getNom_event() + " error modification!!");
        }
    }
    
     @Override
         public void RefuserEvent(Events e){
         
              try {
            String update = "UPDATE events SET  nom_event = ?, etat=? WHERE nom_event = ? ";
            PreparedStatement st2 = c.prepareStatement(update);
            st2.setString(1, e.getNom_event());
            st2.setString(2, "Refuser");
            st2.setString(3, e.getNom_event());
            st2.executeUpdate();
            System.out.println("" + e.getNom_event() + " successfully modified!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + e.getNom_event() + " error modification!!");
        }
         }
         
         
           public List<Events> cherche(String etat){
         Events p = null ;
         String req="select * from events where etat like '"+etat+"'";
       // String req="select * from `events` where etat=?";
        List<Events> event=new ArrayList<>();
        etat="Accepte";
        try {
             ResultSet rs=  ste.executeQuery(req);
            //
            while(rs.next()){
                p = new Events();
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
 
        