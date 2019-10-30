/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Button;
/**
 *
 * @author oussama
 */
public class Commentaire {
    private int id_comm;
    private int id_article,id_user,score;
    private String Text;
        private final Date date1= new Date();  
private  String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
private Button button1 = new Button("Like");
private Button button2 = new Button("Dislike");

    public Commentaire(int id_article, int id_user, int score, String Text) {
        this.id_article = id_article;
        this.id_user = id_user;
        this.score = score;
        this.Text = Text;
    }
    public Commentaire(int id_article, int id_user, int score, String Text, String date) {
        this.id_article = id_article;
        this.id_user = id_user;
        this.score = score;
        this.Text = Text;
        this.date=date;
    }
    

    public void setScore(int score) {
        this.score = score;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public int getScore() {
        return score;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
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