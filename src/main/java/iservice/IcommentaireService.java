/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;
import entity.commentaire;
import java.util.List;
/**
 *
 * @author oussama
 */
public interface IcommentaireService {
    public void ajoutercomm(commentaire m);
    public void modifiercomm(commentaire m);
    public void supprimercomm(commentaire m);
    public List<commentaire> affichercomm();
    
}