/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable {
    @FXML
    private javafx.scene.control.Label lblMsg;
    @FXML 
    private javafx.scene.control.TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnConnexion;
    @FXML
    private Button btnSignup;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnConnexionAction(javafx.event.ActionEvent event) {
    }

    @FXML
    private void btnSignupAction(javafx.event.ActionEvent event) {
    }
    
}
