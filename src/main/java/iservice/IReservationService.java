/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iservice;

import entity.Events;
import entity.Organisateurs;
import entity.Participants;
import entity.Reservation;
import entity.ReservationEvent;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IReservationService {

    public void ajouterReservation(Reservation r) throws Exception;
    public void supprimerReservation(Reservation r);
    public List<Reservation> afficherReservation(Organisateurs o) throws Exception;
    public List<ReservationEvent> afficherReservationPar(Participants p) throws Exception;
    public List<Reservation> chercherOrg(String nom_ev,Organisateurs org);
   public void supprimerReservationEv(ReservationEvent e);
    public List<ReservationEvent> chercherEv(String nom_e);
}
