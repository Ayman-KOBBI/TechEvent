/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.EventService;

/**
 *
 * @author ASUS
 */
public class ReservationEvent extends Events {
   
     private int id_ticket;
    
    public ReservationEvent(int id_ev,int id_org,String nom_event, String lieu,int nb_place,Date dt_event,int prix,String description,String etat,int id_ticket) {
      super(id_ev,id_org,nom_event,lieu,nb_place,dt_event,prix,description,etat);
      this.id_ticket=id_ticket;
    }

    public ReservationEvent() {
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_org() {
        return id_org;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    @Override
    public String toString() {
        return "ReservationEvent{" +super.toString() + " ,id_ticket=" + id_ticket + '}';
    }
     
     public ReservationEvent(int id_ev,Organisateurs o,String nom_event, String lieu,int nb_place,Date dt_event,int prix,String description,String etat,int id_ticket){
         this(id_ev,o.getId_org(),nom_event,lieu,nb_place,dt_event,prix,description,etat,id_ticket);
     }
    
}
