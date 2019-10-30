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
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Button;



public class Forum {
    private int id_article ;
    private int id_user;
    private int id_org,score;
    private String titre,description,u;
    private final Date date1= new Date();  
private  String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
private Button button=new Button("Consulter");

    public Forum(int id_article, int id_user, int score, String titre, String description, String date) {
        this.id_article = id_article;
        this.id_user = id_user;
        this.score = score;
        this.titre = titre;
        this.description = description;
        this.date= date;
    }
    public String getU() {
        return u;
    }

    public Forum(int id_article, int id_user, int score, String titre, String description) {
        this.id_article = id_article;
        this.id_user = id_user;
        this.score = score;
        this.titre = titre;
        this.description = description;
    }

    public void setU(String u) {
        this.u = u;
    }
    public Forum() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Forum(int id_user, int score, String description) {
        this.id_user = id_user;
        this.score = score;
        this.description = description;
    }

    

   

    public Forum(int id_user,int score, String titre, String description) {
        this.id_user = id_user;
        this.titre = titre;
        this.description = description;
    }



    public void setButton(Button button) {
        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    @Override
    public String toString() {
        return "Forum{" + "id_article=" + id_article + ", id_user=" + id_user + ", id_org=" + id_org + ", titre=" + titre + ", description=" + description + ", date1=" + date1 + ", date=" + date + '}';
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_article() {
        return id_article;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_org() {
        return id_org;
    }

    public String getTitre() {
        return titre;
    }

   

    public String getDescription() {
        return description;
    }

    public Date getDate1() {
        return date1;
    }

    public String getDate() {
        return date;
    }


}