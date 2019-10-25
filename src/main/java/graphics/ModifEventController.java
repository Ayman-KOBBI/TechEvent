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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EventService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifEventController implements Initializable {

    @FXML
    private Label prix;
    @FXML
    private Label id_org;
    @FXML
    private Label h_event;
    @FXML
    private Label dt_event;
    @FXML
    private Label nb_place;
    @FXML
    private Label lieu;
    @FXML
    private Label description;
    @FXML
    private Label image;
    @FXML
    private TextField lie1;
    @FXML
    private TextField nb1;
    @FXML
    private TextField desc1;
    @FXML
    private TextField px1;
    @FXML
    private TextField h_e1;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField nom_or1;
    @FXML
    private TextField nom_e1;
    private TableView table_event;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bt_modifEvent(ActionEvent event) throws SQLException {
       
        
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

    }

    @FXML
    private void bt_Retour2(ActionEvent event) {
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ConsulterEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
        
    }

    @FXML
    private void bt_annuler2(ActionEvent event) {
        
         nom_or1.setText("");
       nom_e1.setText("");
        lie1.setText("");
       nb1.setText(null);
        date1.setValue(null);
        h_e1.setText("");
        px1.setText("");
        
        desc1.setText("");
    }
    
}
