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
public class Forum {
    private int id_article ;
    private int id_user;
    private int id_org;
    private String titre,image,description;
    private final Date date1= new Date();  
private  String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);

    public Forum(int id_article, int id_user, int id_org, String titre, String image, String description) {
        this.id_article = id_article;
        this.id_user = id_user;
        this.id_org = id_org;
        this.titre = titre;
        this.image = image;
        this.description = description;
    }

    public Forum(int id_user, String titre, String description) {
        this.id_user = id_user;
        this.titre = titre;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Forum{" + "id_article=" + id_article + ", id_user=" + id_user + ", id_org=" + id_org + ", titre=" + titre + ", image=" + image + ", description=" + description + ", date1=" + date1 + ", date=" + date + '}';
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

    public void setImage(String image) {
        this.image = image;
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

    public String getImage() {
        return image;
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