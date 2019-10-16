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
        Date d = new Date();

            EventService es = new EventService();
            Events e2 =new Events(9);
            Events e3 = new Events(5, "mjez", 26, "22-07-2020", "20:00", 80, "image", "khat");
        try{
            es.creerEvent(e3);
            System.out.println("element inserer");
        } catch (SQLException ex) {
System.out.println("element non inserer");        }
         
       //  es.creerPersonne(p);
       // es.rechercheEventByID(2);
        es.modifEvent(e3, 8);
       es.supprEvent(e3);
       // es.creerEvent(e1);
         //ArrayList<Events> e = (ArrayList<Events>) es.affichierEvent();
        //System.out.println(e.toString());

            

                    }
}