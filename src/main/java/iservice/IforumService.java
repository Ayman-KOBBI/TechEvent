/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;
import entity.forum;
import java.util.List;
/**
 *
 * @author oussama
 */
public interface IforumService {
    public void creerarticle(forum f);
    public void modifierarticle(forum f);
    public void supprimerarticle(forum f);
    public List<forum> afficherarticle();
    
}
