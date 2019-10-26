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
public class Participants {
    private int id_par;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private int solde=20;
    public static String session;

    
    public Participants(){}

    public Participants(int id_par, String nom, String prenom, String email, String tel, int solde) {
        this.id_par = id_par;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.solde = solde;
    }

    public Participants(int id_par, String nom, String prenom, String email, String tel) {
        this(id_par,nom,prenom,email,tel,20);
 
    }

    public Participants(String nom, String prenom, String tel, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId_par() {
        return id_par;
    }

    public void setId_par(int id_par) {
        this.id_par = id_par;
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

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    public static String getSession() {
        return session;
    }

    public static void setSession(String session) {
        Participants.session = session;
    }

    @Override
    public String toString() {
        return "Participants{" + "id_par=" + id_par + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", solde=" + solde + '}';
    }
    
    
    
    
}
