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
 * @author oussama
 */
public class commentaire {
    private int id_comm;
    private int id_article;
    private Date date_comm;
    private Time heure_comm;
    private String Text;

    @Override
    public String toString() {
        return "commentaire{" + "id_comm=" + id_comm + ", id_article=" + id_article + ", date_comm=" + date_comm + ", heure_comm=" + heure_comm + ", Text=" + Text + '}';
    }

    public commentaire(int id_comm, int id_article, Date date_comm, Time heure_comm, String Text) {
        this.id_comm = id_comm;
        this.id_article = id_article;
        this.date_comm = date_comm;
        this.heure_comm = heure_comm;
        this.Text = Text;
    }
    public commentaire() {
}
    public int getId_comm() {
        return id_comm;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public Date getDate_comm() {
        return date_comm;
    }

    public void setDate_comm(Date date_comm) {
        this.date_comm = date_comm;
    }

    public Time getHeure_comm() {
        return heure_comm;
    }

    public void setHeure_comm(Time heure_comm) {
        this.heure_comm = heure_comm;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

}
