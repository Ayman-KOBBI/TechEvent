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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EventService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EventController implements Initializable {

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
    private TextField id_or;
    @FXML
    private TextField lie;
    @FXML
    private TextField nb;
    @FXML
    private TextField desc;
    @FXML
    private TextField imag;
    @FXML
    private TextField px;
    @FXML
    private TextField h_e;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO

      
        
    }    

    @FXML
    private void ajout1(ActionEvent event) throws SQLException {
        
         int id_org = Integer.parseInt(id_or.getText());
        String lieu= lie.getText();
        int nb_place = Integer.parseInt(nb.getText());
        LocalDate locald = date.getValue();
        Date dt_event = Date.valueOf(locald);     
        String h_event= h_e.getText();
        int prix= Integer.parseInt(px.getText());
        String image= imag.getText();
        String description= desc.getText();

           Events E1= new Events(id_org,lieu,nb_place,dt_event,h_event,prix,image,description);
           EventService p = new EventService();
              p.creerEvent(E1);
              JOptionPane.showMessageDialog(null, "Account Created Successfull");
        
        
    }
    
}
