/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;


import entity.Organisateurs;
import entity.Reservation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ReservationService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherResOrgController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Reservation> tab_res;        
    @FXML
    private TableColumn<Reservation, String> nomPar;
    @FXML
    private TableColumn<Reservation, String> prenomPar;
    
    @FXML
    private TextField rechercheEv;
    @FXML
    private TableColumn<Reservation, String> nomEv;
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Organisateurs org=new Organisateurs();
        org.setId_org(0);
         ReservationService res = new ReservationService();
        ArrayList<Reservation> list = null;
         try {
             list=(ArrayList<Reservation>) res.afficherReservation(org);
         } catch (Exception ex) {
             Logger.getLogger(AfficherResOrgController.class.getName()).log(Level.SEVERE, null, ex);
         }
        ObservableList OL = FXCollections.observableArrayList(list);
         
        tab_res.setItems(OL);
       
       
       // id_ticket.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        //id_par.setCellValueFactory(new PropertyValueFactory<>("id_par"));
        //id_ev.setCellValueFactory(new PropertyValueFactory<>("id_ev"));
        nomEv.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        nomPar.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomPar.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        
       
        
       /* tab_res.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    Reservation r2=tab_res.getItems().get(tab_res.getSelectionModel().getSelectedIndex());
                    nomPar.setText(r2.getNom());
                     prenomPar.setText(r2.getPrenom());
                
                    nom_e.setText(r2.getnom_event());
                    
                }
            }
        });   */
    } 
    @FXML
    private void btRetour(ActionEvent event) {
         Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/Org.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }
    
    
    
     @FXML
    private void search(KeyEvent event) {
        
           ReservationService res = new ReservationService();
            String m = rechercheEv.getText().concat("%");
            ArrayList<Reservation> r= (ArrayList<Reservation>) res.chercher(m);
            ObservableList<Reservation> obs=FXCollections.observableArrayList(r);
            tab_res.setItems(obs);
    }  
     
    
}
