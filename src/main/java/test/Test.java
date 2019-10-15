/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Events;
import java.awt.Event;
import java.sql.Connection;
import service.EventService;
import utils.ConnexionBD;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class Test {
    public static void main(String[] args) {
        
   
            EventService es = new EventService();
            ArrayList<Events> e = (ArrayList<Events>) es.affichierEvent();
            System.out.println(e.toString());
             //es.creerEvent(new events());

            

}
}