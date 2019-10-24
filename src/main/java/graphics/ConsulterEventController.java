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
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
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
import static javafx.scene.input.KeyCode.S;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class ConsulterEventController implements Initializable {

    @FXML
    private TableView table_event;
    
    @FXML
    private TableColumn<?, ?> id_e;
    @FXML
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
    @FXML
    private TableColumn<?, ?> imag;
    @FXML
    private TableColumn<?, ?> desc;
    
    
    

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
        id_e.setCellValueFactory(new PropertyValueFactory<>("id_ev") );
        id_or.setCellValueFactory(new PropertyValueFactory<>("id_org") );
        lie.setCellValueFactory(new PropertyValueFactory<>("lieu") );
        nb.setCellValueFactory(new PropertyValueFactory<>("nb_place") );
        dt_e.setCellValueFactory(new PropertyValueFactory<>("dt_event") );
        h_e.setCellValueFactory(new PropertyValueFactory<>("h_event") );
        px.setCellValueFactory(new PropertyValueFactory<>("prix") );
        imag.setCellValueFactory(new PropertyValueFactory<>("image") );
        desc.setCellValueFactory(new PropertyValueFactory<>("description") );
    }    

    @FXML
    private void bt_aj(ActionEvent event) throws SQLException {
        
    }

    @FXML
    private void bt_modif(ActionEvent event) {
        
    }

    @FXML
    private void bt_sup(ActionEvent event) {
        int id_ev = Integer.parseInt(id_e.getText());
        Events P = new Events();
        P.setId_ev(id_ev);
        EventService p1 = new EventService();
        p1.supprEvent(P);
        JOptionPane.showMessageDialog(null, "Account Deleted Successfull");
    }

    
    

    
   
}
   



    

