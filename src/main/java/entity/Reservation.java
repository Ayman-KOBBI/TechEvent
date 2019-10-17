/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Reservation {
   
   private int id_ticket;
   private int id_ev;
   private int id_par;
   private String nom;
   private String prenom;

    public Reservation() {
    }

    public Reservation(int id_ticket, int id_ev,int id_par, String nom, String prenom) {
        this.id_ticket = id_ticket;
        this.id_ev = id_ev;
        this.id_par = id_par;
        this.nom = nom;
        this.prenom = prenom;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.id_ticket != other.id_ticket) {
            return false;
        }
        return true;
    }

    public int getId_par() {
        return id_par;
    }

    public void setId_par(int id_par) {
        this.id_par = id_par;
    }

    @Override
    public String toString() {
        return "class reservation<"+this.id_ticket+","+this.getId_ev()+","+this.id_par+","+this.nom+","+this.prenom+">"; //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
