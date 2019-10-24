/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.time.LocalDate;
import entity.Events;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import service.EventService;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.S;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class ConsulterEventController implements Initializable {

    @FXML
    private TableView table_event;
    
    private TableColumn<?, ?> id_e;
    private TableColumn<?, ?> id_or;
    @FXML
    private TableColumn<?, ?> lie;
    @FXML
    private TableColumn<?, ?> nb;
    @FXML
    private TableColumn<?, ?> dt_e;
    @FXML
    private TableColumn<?, ?> h_e;
    @FXML
    private TableColumn<?, ?> px;
    private TableColumn<?, ?> imag;
    @FXML
    private TableColumn<?, ?> desc;
    @FXML
    private TableColumn<?, ?> nom_or;
    @FXML
    private TableColumn<?, ?> nom_e;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ////////////////Afficher///////////
        EventService p= new EventService();
        ArrayList<Events> e = (ArrayList<Events>) p.affichierEvent(); 
        ObservableList<Events> obs=FXCollections.observableArrayList(e);
        table_event.setItems(obs);
        nom_or.setCellValueFactory(new PropertyValueFactory<>("nom_org") );
        nom_e.setCellValueFactory(new PropertyValueFactory<>("nom_event") );
        lie.setCellValueFactory(new PropertyValueFactory<>("lieu") );
        nb.setCellValueFactory(new PropertyValueFactory<>("nb_place") );
        dt_e.setCellValueFactory(new PropertyValueFactory<>("dt_event") );
        h_e.setCellValueFactory(new PropertyValueFactory<>("h_event") );
        px.setCellValueFactory(new PropertyValueFactory<>("prix") );
        desc.setCellValueFactory(new PropertyValueFactory<>("description") );
    }    

    @FXML
    private void bt_aj(ActionEvent event) throws SQLException {
          Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/Event.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bt_modif(ActionEvent event) {
        
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ModifEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
        
        
    }

    @FXML
    private void bt_sup(ActionEvent event) {
       
        EventService cs = new EventService();
      
        Events a = (Events) table_event.getSelectionModel().getSelectedItem();
        cs.supprEvent(a);
        
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ConsulterEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    
    

    
   
}
   



    

