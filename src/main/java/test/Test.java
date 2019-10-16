/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Events;
import java.awt.Event;
import java.sql.Connection;
import java.sql.Time;
import java.time.Instant;
import service.EventService;
import utils.ConnexionBD;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author asus
 */
public class Test {
    public static void main(String[] args) {
        

            EventService es = new EventService();
            Events e1;
           Events e2 =  new Events(4, 2);           
         e1 = new Events(0, 1, 0);
        es.rechercheEventByID(2);
        // es.supprEvent(e2);
       // es.creerEvent(e1);
         //ArrayList<Events> e = (ArrayList<Events>) es.affichierEvent();
        //System.out.println(e.toString());

            

                    }
}