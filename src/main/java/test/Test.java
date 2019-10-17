/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Events;
import java.awt.Event;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Instant;
import service.EventService;
import utils.ConnexionBD;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
public class Test {
    public static void main(String[] args) {
        //Date d = new Date();

            EventService es = new EventService();
            Events e2 =new Events(9);
            Events e4 =new Events(24, 7, "mjez", 7, "dt_event", "h_event", 0, "image", "description");
            e4.setDescription("esprit_ariena");
          es.modifEvent(e4);
        /*try {
            es.creerEvent(e4);
            e4.setDescription("espriiiiit");
             es.modifEvent(e4);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
      
           /* try{
            es.creerEvent(e4);
          

            System.out.println("element inserer");
        } catch (SQLException ex) {
System.out.println("element non inserer");       }*/
         
       //  es.creerPersonne(p);
       es.rechercheEventByID(1);
      es.supprEvent(e2);
       // es.creerEvent(e1);
         //ArrayList<Events> e = (ArrayList<Events>) es.affichierEvent();
        //System.out.println(e.toString());

            

                    }
}