/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import entity.Participants;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ParService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PartController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnProfil;
    @FXML
    private Button btnMesevenements;
    @FXML
    private Button btnForum;
    private TextField nom_p;
    private TextField prenom_p;
    private TextField solde_p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*   try{
        // TODO
        //modifierMembre.setVisible(false);
        ParService ms = new ParService();
        Participants mb = ms.getpar(Participants.session);
        nom_p.setText(mb.getNom());
        prenom_p.setText(mb.getPrenom());
        solde_p.setText(Integer.toString(mb.getSolde()));
        }

    
        catch (SQLException ex) {
            Logger.getLogger(PartController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
    }

    @FXML
    private void btnProfilAction(ActionEvent event) {
    }

    @FXML
    private void btnMesevenementsAction(ActionEvent event) {
         Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ParticipantEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void btnForumAction(ActionEvent event) {
    }
    }    
    

