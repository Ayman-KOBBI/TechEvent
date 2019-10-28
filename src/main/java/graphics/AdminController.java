/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ParService;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class AdminController implements Initializable {

    @FXML
    private Label es_admin;
    @FXML
    private Button Home;
    @FXML
    private Button btorganisateur;
    @FXML
    private Button utilisateur;
    @FXML
    private Button event;
    @FXML
    private Button forum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void event2(ActionEvent event) {
         Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bthome(ActionEvent event) {
    }

    @FXML
    private void btorganisateur(ActionEvent event) {
    }

    @FXML
    private void btutilisateur(ActionEvent event) {
    }

    @FXML
    private void btforum(ActionEvent event) {
    }
    
}
