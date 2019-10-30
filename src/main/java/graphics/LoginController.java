/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entity.User;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnConnexion;
    @FXML
    private Button btnSignup;
    @FXML
    private Label lblMsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnConnexionAction(ActionEvent event) {
        
        String logf = txtUsername.getText();
        String passf = txtPassword.getText();
        UserService u = new UserService();
        User res = null;
        String rol ; 
         if (u.verifyPass(logf, passf)) {
            rol = u.seConnecter(logf,passf);
            
           
          //  session.getInstance(res.getLogin(), res.getMdp(), res.getRole(), res.getId_user());
      
          switch(rol)
          {case "admin":  try {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
                    Parent root = loader.load();
                     
                
                    Scene scene = new Scene(root);
                    stage.setTitle("TechExpo");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } 
          break ; 
          
          
          case "participant":   try {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Part.fxml"));
                    Parent root = loader.load();
                     PartController tr = loader.getController();
               
                tr.setIdrecla(logf,passf);
                    Scene scene = new Scene(root);
                    stage.setTitle("Garantia");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
          break ;
          case "organisateur": try {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/org.fxml"));
                    Parent root = loader.load();
                            OrgController tr = loader.getController();
               
                tr.setIdrecla(logf,passf);
                    Scene scene = new Scene(root);
                    stage.setTitle("TechExpoa");
                    stage.setScene(scene);
                    stage.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
          break;
          
          
          }
       
           Stage stage = (Stage) btnConnexion.getScene().getWindow(); 
          stage.close();           
        
       
         }
         else {
           try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/verif_2.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage.setTitle("TechExpo");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } 
          
         }
        
    }

    @FXML
    private void btnSignupAction(ActionEvent event) {
          try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscription.fxml"));
        Scene scene = new Scene(root);
            Stage stage = new Stage();
           
            stage.setScene(scene);
            stage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
               Stage stage = (Stage) btnSignup.getScene().getWindow(); 
          stage.close(); 
          
    }
    
}
