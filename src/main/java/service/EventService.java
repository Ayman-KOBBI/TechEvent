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
    public void creerEvent(Events event) {
try {
            String req1="INSERT INTO `events`(`id_ev`, `id_org`, `lieu`, `nb_place`, `dt_event`, `h_event`, `prix`, `description`) VALUES"
                    + "("+e.getId_ev()+","+e.getId_org()+","+e.getLieu()+","+e.getNb_place()+","+e.getDt_event()+","+e.getH_event()+","+e.getPrix()+","+e.getDescription()+")";
                    
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erreur d_'ajout \n"+ex.getMessage());
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void modifEvent(Events event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprEvent(Events event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Events rechercheEventByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    

