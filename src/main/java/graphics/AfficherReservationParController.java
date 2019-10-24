/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import entity.Reservation;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ReservationService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherReservationParController implements Initializable {
     @FXML
    private TableView<Reservation> tab_res;   
  @FXML
    private TableColumn<Reservation, Integer> id_ticket;
  @FXML
    private TableColumn<Reservation, Integer> id_ev;    
  @FXML
    private TableColumn<Reservation, Integer> id_par;
    @FXML
    private TableColumn<Reservation, String> nom;
        @FXML
    private TableColumn<Reservation, String> prenom;
            @FXML
    private TableColumn<Reservation, String> image;
       /**
     * Initializes the controller class.
     */
   
        // TODO
         
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ReservationService res = new ReservationService();
        ArrayList<Reservation> list;
        list=(ArrayList<Reservation>) res.afficherReservation();
        ObservableList OL = FXCollections.observableArrayList(list);
         
        tab_res.setItems(OL);
       // id_ticket.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        //id_par.setCellValueFactory(new PropertyValueFactory<>("id_par"));
        //id_ev.setCellValueFactory(new PropertyValueFactory<>("id_ev"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
    }    
    
}
