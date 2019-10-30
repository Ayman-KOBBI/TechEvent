/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.scene.control.Button;

/**
 *
 * @author asus
 */
public class Organisateurs {
private int id_org;
private String nom;
private String prenom;
private String email;
private String tel;
private String mdp;
public static String session;
 private Button modifier=new Button ("modifier");
    private Button supprimer=new Button ("supprimer"); 

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

    public Button getModifier() {
        return modifier;
    }

    public Button getSupprimer() {
        return supprimer;
    }
    

    public static String getSession() {
        return session;
    }

    public static void setSession(String session) {
        Organisateurs.session = session;
    }
public Organisateurs(){}

  
    public Organisateurs(int id_org, String nom, String prenom, String email, String tel,String mdp) {
        this.id_org = id_org;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.mdp=mdp;
     
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public int getId_org() {
        return id_org;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Organisateurs{" + "id_org=" + id_org + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + '}';
    }

}

