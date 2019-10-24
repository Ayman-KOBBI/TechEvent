/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;
import entity.Organisateurs;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author asus
 */
public interface IOrgService {
    public void creerOrg(Organisateurs org)throws SQLException;
    public void modifierOrg(Organisateurs org)throws SQLException;
    public void supprimerOrg(Organisateurs p);
    public List<Organisateurs> afficherOrg();
    
}
