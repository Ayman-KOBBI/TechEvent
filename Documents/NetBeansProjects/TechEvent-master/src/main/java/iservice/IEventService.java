/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entity.Events;
import java.sql.SQLException;

import java.util.List;

/**
 *
 * @author asus
 */
public interface IEventService {
    public void creerEvent(Events e) throws SQLException;
  //  public void modifEvent(Events e,int i);
        public void modifEvent(Events e);    

    public void supprEvent(Events e);
    public Events rechercheEventByID(int id);;
    public List<Events> affichierEvent();
    
}