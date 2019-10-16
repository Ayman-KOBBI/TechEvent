/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;
import java.util.Date;
/**
 *
 * @author asus
 */
public class Events {
    
    private int id_ev ; 
    private int id_org ; 
    private String description; 
    private Date dt_event; 
    private int nb_place ; 
    private String lieu ;
    private float  prix ; 
    private Time h_event ; 
    private String image ;
   
    
    public Events() {
    }
    public Events(int id_ev, int id_org,int nb_place) {
            this.id_ev=id_ev;
                this.id_org = id_org;
                this.nb_place=nb_place;
                
    }
    public Events(String description,String lieu) {
                this.description = description;
                this.lieu = lieu;


    }

    public Events(int id_ev, int id_org, String description, Date dt_event, int nb_place, String lieu, float prix, Time h_event) {
        this.id_ev = id_ev;
        this.id_org = id_org;
        this.description = description;
        this.dt_event = dt_event;
        this.nb_place = nb_place;
        this.lieu = lieu;
        this.prix = prix;
        this.h_event = h_event;
    }

    public Events(int id_ev,String description,int nb_place, float prix) {
        this.id_ev = id_ev;
       
        this.description = description;
        this.nb_place = nb_place;
        this.prix = prix;
    
    }

    public Events(int id_ev, int id_org, String description, Date dt_event, Time h_event, int nb_place, String lieu, float prix, String image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Events{" + "id_ev=" + id_ev + ", id_org=" + id_org + ", description=" + description + ", dt_event=" + dt_event + ", nb_place=" + nb_place + ", lieu=" + lieu + ", prix=" + prix + ", h_event=" + h_event + ", image=" + image + '}';
    }


    
    

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
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

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setH_event(Time h_event) {
        this.h_event = h_event;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId_ev() {
        return id_ev;
    }

    public int getId_org() {
        return id_org;
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

    public float getPrix() {
        return prix;
    }

    public Time getH_event() {
        return h_event;
    }

    public String getImage() {
        return image;
    }


}

