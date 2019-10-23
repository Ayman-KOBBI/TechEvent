/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import entity.Events;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private TextField id_or1;
    @FXML
    private TextField lie1;
    @FXML
    private TextField nb1;
    @FXML
    private TextField desc1;
    @FXML
    private TextField imag1;
    @FXML
    private TextField px1;
    @FXML
    private TextField h_e1;
    @FXML
    private DatePicker date1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bt_modifEvent(ActionEvent event) throws SQLException {
        int id_org = Integer.parseInt(id_or1.getText());
        String lieu= lie1.getText();
        int nb_place = Integer.parseInt(nb1.getText());
        LocalDate locald = date1.getValue();
        Date dt_event = Date.valueOf(locald);     
        String h_event= h_e1.getText();
        int prix= Integer.parseInt(px1.getText());
        String image= imag1.getText();
        String description= desc1.getText();

           Events E1= new Events(id_org,lieu,nb_place,dt_event,h_event,prix,image,description);
           EventService e = new EventService();
              e.modifEvent(E1);
              JOptionPane.showMessageDialog(null, "Account edited Successfull");
    }

    @FXML
    private void bt_Retour2(ActionEvent event) {
    }

   
    
}
