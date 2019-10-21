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
import javax.swing.JOptionPane;
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
  
String req="INSERT INTO events(id_ev,id_org,lieu,nb_place,dt_event,h_event,prix,image,description) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pres=c.prepareStatement(req);
        pres.setInt(1,e.getId_ev() );
        pres.setInt(2,e.getId_org() );
        pres.setString(3,e.getLieu());
        pres.setInt(4,e.getNb_place());
        pres.setDate(5, (java.sql.Date) e.getDt_event());
        pres.setString(6,e.getH_event());
        pres.setInt(7,e.getPrix());  
        pres.setString(8,e.getImage());  
        pres.setString(9,e.getDescription());  
        pres.executeUpdate();
       // System.out.println(pres.executeUpdate());
        System.out.println("element inserer");
    }

    @Override
    public void modifEvent(Events e) {    
        Date dt_event = Calendar.getInstance().getTime();
    SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String sql = "UPDATE events SET id_org=?,lieu=?, nb_place=?,"
            + "  dt_event=?,h_event=?,prix=?,image=?, description=? where id_ev=?";
 
        PreparedStatement pres;
          

         try {
             pres = c.prepareStatement(sql);
        pres.setInt(1,e.getId_org());
        pres.setString(2,e.getLieu());
        pres.setInt(3,e.getNb_place());
        pres.setDate(4, (java.sql.Date) e.getDt_event());
        pres.setString(5,e.getH_event());
        pres.setInt(6,e.getPrix());  
        pres.setString(7,e.getImage());  
        pres.setString(8,e.getDescription());
        pres.setInt(9,e.getId_ev());
             System.out.println(e.getId_ev());
        pres.executeUpdate();
     
           System.out.println("L'evenement a été modifier avec succès");
          
         } catch (SQLException ex) {
            System.out.println(ex);

         }
        
        
        
        //pres.setInt(1,e.getId_ev());
       
          
          
    
    }

    @Override
    public void supprEvent(Events e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Events rechercheEventByID(int id) {
    try {
         
                String res1=("select * from events where id_ev="+id);
     ResultSet res=  ste.executeQuery(res1);
        while(res.next())
            {    
                int id_ev = res.getInt("id_ev");
                int id_org = res.getInt("id_org");
                String description=res.getString("description");
                Date dt_event=res.getDate("dt_event");
                String h_event=res.getString("h_event");
                int nb_place=res.getInt("nb_place");
                String lieu=res.getString("lieu");
                float prix=res.getInt("prix");
                String image=res.getString("image");
                 
                System.out.println("evenement trouvé \n");
              
           //    return new Events(id_ev, id_org, description, dt_event,h_event, nb_place,lieu, prix ,image);  
                
            }
        
          // ste.executeUpdate(res1);
        } catch (SQLException ex) {
             System.out.println("introvable \n");
        } 
         return null;
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
                      p.setId_org(res.getInt("id_org"));
                      p.setDescription(res.getString("Description") );
                      p.setLieu(res.getString("lieu"));
                      p.setDt_event(res.getDate("dt_event"));
                      p.setH_event(res.getString("h_event"));
                      p.setPrix(res.getInt("prix"));
                      p.setNb_place(res.getInt("nb_place"));
                      p.setImage(res.getString("image"));

                      
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
    
    
}

        