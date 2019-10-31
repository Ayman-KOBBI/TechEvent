/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;
import java.util.Date;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
/**
 *
 * @author asus
 */
public class Events {
    
    protected int id_ev ; 
    protected int id_org;
   protected String nom_org ; 
    protected String description; 
   protected Date dt_event; 
    protected int nb_place ; 
    protected String lieu ;
    protected int  prix ; 
 //   private String h_event ; 
    protected String nom_event ;
    protected String etat ;
   
    
    public Events() {
    }
    
    public Events(int id_ev) {
            this.id_ev=id_ev;
                
               
                
    }
   
   
    public Events(String description,String lieu) {
                this.description = description;
                this.lieu = lieu;


    }

    public Events(int id_ev,String nom_org,String nom_event, String lieu,int nb_place,Date dt_event,int prix,String description,String etat) {
       this.id_ev = id_ev;
       this.nom_org = nom_org;
        this.description = description;
        this.dt_event = dt_event;
        this.nb_place = nb_place;
        this.lieu = lieu;
        this.prix = prix;
        this.etat = etat;
        this.nom_event=nom_event;
    }
     public Events(int id_ev,int id_org, String lieu,int nb_place,Date dt_event,int prix,String description,String etat) {
       this.id_ev = id_ev;
      this.id_org = id_org;
        this.description = description;
        this.dt_event = dt_event;
        this.nb_place = nb_place;
        this.lieu = lieu;
        this.prix = prix;
        this.etat = etat;
        
    }
     
public Events(String nom_org,String nom_event, String lieu,int nb_place,Date dt_event,int prix,String description,String etat) {
       //this.id_ev = id_ev;
       this.nom_org = nom_org;
        this.description = description;
        this.dt_event = dt_event;
        this.nb_place = nb_place;
        this.lieu = lieu;
        this.prix = prix;
        this.etat = etat;
        this.nom_event=nom_event;    }

    public Events(TableColumn<Events, String> nom_or, TableColumn<Events, String> nom_e, TableColumn<Events, String> lie, TableColumn<Events, String> nb, TableColumn<Events, java.sql.Date> dt_e, TableColumn<Events, String> h_e, TableColumn<Events, String> px, TableColumn<Events, String> desc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Events(String nom_org, String nom_event, String lieu, int nb_place, String dt_event, String h_event, int prix, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    @Override
    public String toString() {
        return "Events{" + "id_ev=" + id_ev + "," + "nom_org=" + nom_org + ", description=" + description + ", dt_event=" + dt_event + ", nb_place=" + nb_place + ", lieu=" + lieu + ", prix=" + prix + ",etat=" + etat + ", nom_event=" + nom_event + '}';
    }


    
    

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }
    
    

    public void setNom_org(String nom_org) {
        this.nom_org = nom_org;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDt_event(Date dt_event) {
        this.dt_event = dt_event;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public int getId_ev() {
        return id_ev;
    }

   
  

    public String getNom_org() {
        return nom_org;
    }

    public String getDescription() {
        return description;
    }

    public Date getDt_event() {
        return dt_event;
    }

    public int getNb_place() {
        return nb_place;
    }

    public String getLieu() {
        return lieu;
    }

    public int getPrix() {
        return prix;
    }

    public String getEtat() {
        return etat;
    }

    public String getNom_event() {
        return nom_event;
    }

   


}
