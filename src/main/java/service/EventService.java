/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Events;
import iservice.IEventService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.ConnexionBD;
import java.util.Date;
import java.sql.Time;
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
    java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
   

    public EventService() {
        try {
        ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void creerEvent(Events e) {
                   

try {

  // String req1="INSERT INTO `events`(`id_ev`, `id_org`, `lieu`, `nb_place`, `dt_event`, `h_event`, `prix`, `description`) VALUES ("+null+","+e.getId_org()+","+e.getLieu()+","+e.getNb_place()+","+e.getDt_event()+","+e.getH_event()+","+e.getPrix()+","+e.getDescription()+")";
                    
            String req1="INSERT INTO `events` (`id_ev`, `id_org`) VALUES ("+null+","+e.getId_org()+","+e.getNb_place()+")";
         //  String req1="INSERT INTO `events`( `lieu`, `description`) VALUES ("+e.getLieu()+","+e.getDescription()+")";
          
  // String req1 = +"insert into 'events' values ("+null+","+e.getId_org()+","+e.getDescription()+","+e.getLieu()+","+e.getDt_event()+","+e.getH_event()+","+e.getImage()+","+e.getPrix()+")";
           ste.executeUpdate(req1);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erreur d_'ajout \n"+ex.getMessage());
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public void modifEvent(Events e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {

  String req2=("UPDATE events SET description = '"+e.getDescription()+"', nb_place = "+e.getNb_place()+  " ',image = "+e.getImage()+  "',  dt_event = '"+e.getDt_event()+"', h_event = '"+e.getH_event()+"', lieu= '"+e.getLieu()+"', prix= '"+e.getPrix()+"' WHERE id_ev = "+e.getId_ev());
           ste.executeUpdate(req2);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erreur de modifier \n"+ex.getMessage());
            System.out.println(ex.getMessage());
        } 
    
    }

    @Override
    public void supprEvent(Events e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    try {
        String req3=("delete from events where id_ev = '"+e.getId_ev()+"'");
           ste.executeUpdate(req3);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Impossible de supprimer cet article\n"+ex.getMessage());
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public Events rechercheEventByID(int id) {
      
        String res1=("select * from events where where id_ev="+id);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
        
        
        ResultSet res=  ste.executeQuery(res1);
        while(res.next())
            {
                
               int id_ev = res.getInt("id_ev");
                int id_org = res.getInt("id_org");
                String description=res.getString("description");
                Date dt_event=res.getDate("dt_event");
                Time h_event=res.getTime("h_event");
                int nb_place=res.getInt("nb_place");
                String lieu=res.getString("lieu");
                float prix=res.getFloat("prix");
                String image=res.getString("image");
                 
                    

                      
               
            
                
                return  new Events(id_ev, id_org, description, dt_event,h_event, nb_place,lieu, prix ,image);  
                
            }
        
           ste.executeUpdate(res1);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Introuvable \n"+ex.getMessage());
            System.out.println(ex.getMessage());
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
                      p.setH_event(res.getTime("h_event"));
                      p.setPrix(res.getFloat("prix"));
                      p.setNb_place(res.getInt("nb_place"));
                      p.setImage(res.getString("image"));

                      
              event.add(p);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
          }
             
     return event;
    }}
    

