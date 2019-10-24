/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;
import entity.Commentaire;
import entity.Forum;
import java.util.List;
/**
 *
 * @author oussama
 */
public interface IcommentaireService {
    public void ajoutercomm(Commentaire m);
    public void modifiercomm(int id_comm, String Text);
    public void supprimercomm(int id_comm);
    public List<Commentaire> affichercomm(Forum f) ;
    
}