/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;
import entity.Forum;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author oussama
 */
public interface IforumService {
    public void creerarticle(Forum f);
    public void modifierarticle(int id_article,String titre, String description);
    public void supprimerarticle(int id_article);
    public void afficherarticle();
    public ArrayList<Forum> afficherarticles();
    
}
