/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ReservationEvent extends Events {
    
     public ReservationEvent(int id_ev,int id_org,String nom_org,String nom_event, String lieu,int nb_place,Date dt_event,String h_event,int prix,String description) {
       this.id_ev = id_ev;
       this.id_org = id_org;
        this.description = description;
        this.dt_event = dt_event;
        this.nb_place = nb_place;
        this.lieu = lieu;
        this.prix = prix;
        this.h_event = h_event;
        this.nom_event=nom_event;

    }
     public ReservationEvent(int id_ev,Organisateurs o,String nom_event, String lieu,int nb_place,Date dt_event,String h_event,int prix,String description){
         this(id_ev,o.getId_org(),o.getNom(),nom_event,lieu,nb_place,dt_event,h_event,prix,description);
     }
    
}
