/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import entity.Events;
import entity.Participants;
import entity.Reservation;
import java.awt.Event;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import service.EventService;
import utils.ConnexionBD;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ParService;
import service.ReservationService;
/**
 *
 * @author asus
 */
public class Test {

 
    public static void main(String[] args) throws SQLException, ParseException {
       String m = "2019-01-28";
    java.util.Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(m);
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
          /*  EventService es = new EventService();
            Events e2 =new Events(9);
            Events e3 =new Events(11, "mjez", 8, sqlDate, "08:00", 70, "m", "esprit");
            Events e4 =new Events(62, 9, "m", 0, sqlDate, "m", 0, "m", "m"); */
            //Events e3=new Events(5, "lieu", 9, "dt_event", "h_event", 0, "image", "description");
           // Events e4 =new Events(24, 7, "mjez", 7, "dt_event", "h_event", 0, "image", "description");
            //e4.setDescription("esprit_ariena");
         // es.modifEvent(e4);
       //  Events p = new Events("resouces/fxml/Event.fxml");
       /* try {
            es.creerEvent(e3);
          //  e4.setDescription("espriiiiit");
             es.modifEvent(e4);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } */
      
           /* try{
            es.creerEvent(e4);
          

            System.out.println("element inserer");
        } catch (SQLException ex) {
System.out.println("element non inserer");       }*/
         
       //  es.creerPersonne(p);
       //es.rechercheEventByID(1);
      //es.supprEvent(e2);
       // es.creerEvent(e1);
         //ArrayList<Events> e = (ArrayList<Events>) es.affichierEvent();
        //System.out.println(e.toString());
       ///reservation 
       //  ReservationService res1= new ReservationService();
        
        //res1.supprimerReservation(r1);
        //System.out.println(res1.afficherReservation().toString());    
    /*    ParService par1= new ParService();
        Participants p1= new Participants(11,"ayman","kobbi","6546","eaemail",50);
        try{    
            par1.creerPar(p1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        Reservation r1=new Reservation(1,1,p1.getId_par(),p1.getNom(),p1.getPrenom(),"image.jpg");
        try{
            res1.ajouterReservation(r1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
//Reservation r1=new Reservation(1,1,p1,"aaaaaa");
        //res1.ajouterReservation(r1); */
                    }
}
