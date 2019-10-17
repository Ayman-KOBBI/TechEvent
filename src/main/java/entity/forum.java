/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author oussama
 */
import java.sql.Time;
import java.util.Date;
public class forum {
    private int id_article ;
    private int id_ev;
    private int id_org;
    private Date date_cr;
    private Time heure_cr;
    private String lieu;
    private String image;
    private String description;


    public forum(int id_article, int id_ev, int id_org, Date date_cr, Time heure_cr, String lieu, String image, String description) {
        this.id_article = id_article;
        this.id_ev = id_ev;
        this.id_org = id_org;
        this.date_cr = date_cr;
        this.heure_cr = heure_cr;
        this.lieu = lieu;
        this.image = image;
        this.description = description;
    }

    public forum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public int getId_org() {
        return id_org;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    public Date getDate_cr() {
        return date_cr;
    }

    public void setDate_cr(Date date_cr) {
        this.date_cr = date_cr;
    }

    public Time getHeure_cr() {
        return heure_cr;
    }

    public void setHeure_cr(Time heure_cr) {
        this.heure_cr = heure_cr;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "forum{" + "id_article=" + id_article + ", id_ev=" + id_ev + ", id_org=" + id_org + ", date_cr=" + date_cr + ", heure_cr=" + heure_cr + ", lieu=" + lieu + ", image=" + image + ", description=" + description + '}';
    }

}
