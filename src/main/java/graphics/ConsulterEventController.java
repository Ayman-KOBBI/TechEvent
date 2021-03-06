/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Date;
import java.time.LocalDate;
import entity.Events;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
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
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import javafx.scene.chart.PieChart.Data;
import service.EventService;
import utils.ConnexionBD;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class ConsulterEventController implements Initializable {

    @FXML
    private TableView <Events> table_event;
    
   
    @FXML
    private TableColumn<Events, String> lie;
    @FXML
    private TableColumn<Events, String> nb;
    @FXML
    private TableColumn<Events, Date> dt_e;
    @FXML
    private TableColumn<Events, String>px;
    
    @FXML
    private TableColumn<Events, String> desc;
    @FXML
    private TableColumn<Events, String> nom_or;
    @FXML
    private TableColumn<Events, String> nom_e;
    
    private DatePicker date;
    
    @FXML
    private TextField tfserach;
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
    private TextField h_e1;
    @FXML
    private TextField px1;
    @FXML
    private TextField desc1;
    
    private TextField dt_e1;
    @FXML
    private TableColumn<Events, String> et;
    private TextField et1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ////////////////Afficher///////////
       /* EventService p= new EventService();
        ArrayList<Events> e = (ArrayList<Events>) p.affichierEvent(); 
        ObservableList<Events> obs=FXCollections.observableArrayList(e);*/
       String m = "Accepte";
    
  
        EventService p= new EventService();
        ArrayList<Events> e = (ArrayList<Events>) p.cherche(m); 
        ObservableList<Events> obs=FXCollections.observableArrayList(e);
        table_event.setItems(obs);
        nom_or.setCellValueFactory(new PropertyValueFactory<>("nom_org") );
        nom_e.setCellValueFactory(new PropertyValueFactory<>("nom_event") );
        lie.setCellValueFactory(new PropertyValueFactory<>("lieu") );
        nb.setCellValueFactory(new PropertyValueFactory<>("nb_place") );
        dt_e.setCellValueFactory(new PropertyValueFactory<>("dt_event") );
        et.setCellValueFactory(new PropertyValueFactory<>("etat") );
        px.setCellValueFactory(new PropertyValueFactory<>("prix") );
        desc.setCellValueFactory(new PropertyValueFactory<>("description") );
        
         EventService ps=new EventService();
        
        table_event.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    Events e=table_event.getItems().get(table_event.getSelectionModel().getSelectedIndex());
                    nom_or1.setText(e.getNom_org());
                nom_e1.setText(e.getNom_event());
                     String date=String.valueOf(e.getDt_event()); 
                   LocalDate date2 = LocalDate.parse(date);
                   date1.setValue(date2);
             //  et1.setText(e.getEtat());
                lie1.setText(e.getLieu());
                px1.setText(Integer.toString(e.getPrix()));
                nb1.setText(Integer.toString(e.getNb_place()));
                desc1.setText(e.getDescription());
                    
                }
            }
        });
 
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
    private void bt_sup(ActionEvent event) {
       
        EventService cs = new EventService();
      
        Events a = (Events) table_event.getSelectionModel().getSelectedItem();
        cs.supprEvent(a);
         JOptionPane.showMessageDialog(null, "Event supprimer");
        
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

    @FXML
    private void search(KeyEvent event) {
        
            EventService p = new EventService();
            String m = tfserach.getText().concat("%");
            
            ArrayList<Events> e= (ArrayList<Events>) p.chercher(m);
            ObservableList<Events> obs=FXCollections.observableArrayList(e);
            table_event.setItems(obs);
    }  

    @FXML
    private void refrech(ActionEvent event) {
           if(date1.getValue() == null ||desc1.getText().equals("") || lie1.getText().equals("") || px1.getText().equals("")|| nom_e1.getText().equals("")|| nom_or1.getText().equals("")|| nb1.getText().equals("") ){ 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("OPPS");
                alert.setHeaderText("Erreur !!");
                alert.setContentText("svp remplir les champs");
                 alert.showAndWait();
}else{
        
        String nom_org = nom_or1.getText();
         String nom_event = nom_e1.getText();
        String lieu= lie1.getText();
        int nb_place = Integer.parseInt(nb1.getText());
        LocalDate locald = date1.getValue();
       Date dt_event = Date.valueOf(locald);  
       String etat= "En attent";
        int prix= Integer.parseInt(px1.getText());
        String description= desc1.getText();
          Events E1= new Events(nom_org, nom_event, lieu, nb_place, dt_event, prix, description, etat);
           EventService p = new EventService();
              p.modifEvent(E1);
            JOptionPane.showMessageDialog(null, "Event modifier");}
             
        
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

    @FXML
    private void annuler(ActionEvent event) {
          nom_or1.setText("");
       nom_e1.setText("");
        lie1.setText("");
       nb1.setText(null);
        date1.setValue(null);
    //   et1.setText("");
        px1.setText("");
        
        desc1.setText("");
        
    }

    @FXML
    private void retour(ActionEvent event) {
           Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/org.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    
    
   
    }

    
   
    
    


