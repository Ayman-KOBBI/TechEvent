/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entity.Participants;
import entity.Reservation;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IReservationService {

    public void ajouterReservation(Reservation r);
    public void supprimerReservation(Reservation r);
    public List<Reservation> afficherReservation();
}
