/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import entity.Events;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EventService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AdminEventController implements Initializable {

    @FXML
    private TableView table_event;
    @FXML
    private TableColumn<?, ?> nom_or;
    @FXML
    private TableColumn<?, ?> nom_e;
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
    private TableColumn<?, ?> desc;
    @FXML
    private TextField nom_or1;
    @FXML
    private TextField nom_e1;
    @FXML
    private TextField lie1;
    @FXML
    private TextField nb1;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField h_e1;
    @FXML
    private TextField px1;
    @FXML
    private TextField desc1;
    @FXML
    private TextField tfserach;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        
         EventService ps=new EventService();
        ////////////
        table_event.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    Events e=(Events) table_event.getItems().get(table_event.getSelectionModel().getSelectedIndex());
                    nom_or1.setText(e.getNom_org());
                nom_e1.setText(e.getNom_event());
                     String date=String.valueOf(e.getDt_event()); 
                   LocalDate date2 = LocalDate.parse(date);
                   date1.setValue(date2);
               h_e1.setText(e.getH_event());
                lie1.setText(e.getLieu());
                px1.setText(Integer.toString(e.getPrix()));
                nb1.setText(Integer.toString(e.getNb_place()));
                desc1.setText(e.getDescription());
                    
                }
            }
        });
 
    }    

    @FXML
    private void retour(ActionEvent event) {
          Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void refrech(ActionEvent event) {
         String nom_org = nom_or1.getText();
         String nom_event = nom_e1.getText();
        String lieu= lie1.getText();
        int nb_place = Integer.parseInt(nb1.getText());
        LocalDate locald = date1.getValue();
       Date dt_event = Date.valueOf(locald);  
        String h_event= h_e1.getText();
        int prix= Integer.parseInt(px1.getText());
        String description= desc1.getText();
          Events E1= new Events(nom_org,nom_event,lieu,nb_place,dt_event,h_event,prix,description);
           EventService p = new EventService();
              p.modifEvent(E1);
            JOptionPane.showMessageDialog(null, "Account edited Successfull");
        
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
          nom_or1.setText("");
       nom_e1.setText("");
        lie1.setText("");
       nb1.setText(null);
        date1.setValue(null);
        h_e1.setText("");
        px1.setText("");
        
        desc1.setText("");
    }

    @FXML
    private void search(KeyEvent event) {
           EventService p = new EventService();
            String m = tfserach.getText().concat("%");
            ArrayList<Events> e= (ArrayList<Events>) p.chercher(m);
            ObservableList<Events> obs=FXCollections.observableArrayList(e);
            table_event.setItems(obs);
    }

    @FXML
    private void bt_sup(ActionEvent event) {
        EventService cs = new EventService();
      
        Events a = (Events) table_event.getSelectionModel().getSelectedItem();
        cs.supprEvent(a);
        
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bt_aj(ActionEvent event) {
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
    
}
