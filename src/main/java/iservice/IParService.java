/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;
import entity.Participants;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public interface IParService {
    public void creerPar(Participants par)throws SQLException;
    public void modifierPar(Participants par)throws SQLException;
    public void supprimerPar(Participants p);
    public List<Participants> afficherPar();
    
}
