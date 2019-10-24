/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author oussama
 */
public class Commentaire {
    private int id_comm;
    private int id_article,id_user;
    private String Text;
        private final Date date1= new Date();  
private  String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);

    public Commentaire(int id_comm, int id_article, int id_user, String Text) {
        this.id_comm = id_comm;
        this.id_article = id_article;
        this.id_user = id_user;
        this.Text = Text;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_comm=" + id_comm + ", id_article=" + id_article + ", id_user=" + id_user + ", Text=" + Text + ", date1=" + date1 + ", date=" + date + '}';
    }

    public Commentaire(int id_user, String Text) {
        this.id_user = id_user;
        this.Text = Text;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_comm() {
        return id_comm;
    }

    public int getId_article() {
        return id_article;
    }

    public int getId_user() {
        return id_user;
    }

    public String getText() {
        return Text;
    }

    public Date getDate1() {
        return date1;
    }

    public String getDate() {
        return date;
    }



    
}