/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ParticiperEventController implements Initializable {

    @FXML
    private Button bAjouter;
    @FXML
    private ImageView evImage;
    @FXML
    private Label dateEvLabel;
    @FXML
    private Label heureEvLabel;
    @FXML
    private Label lieuEvLabel;
    @FXML
    private Label imageEvLabel;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnProfil;
    @FXML
    private Button btnMesevenements;
    @FXML
    private Button btnForum;
    @FXML
    private Label descEvLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void ajouterReservation(ActionEvent event) {
    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
    }

    @FXML
    private void btnProfilAction(ActionEvent event) {
    }

    @FXML
    private void btnMesevenementsAction(ActionEvent event) {
    }

    @FXML
    private void btnForumAction(ActionEvent event) {
    }
    
}
