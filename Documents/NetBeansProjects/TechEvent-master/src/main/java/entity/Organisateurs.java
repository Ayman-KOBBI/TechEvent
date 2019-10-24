/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
public Organisateurs(){}

    public Organisateurs(int id_org, String nom, String prenom, String email, String tel) {
        this.id_org = id_org;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
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

