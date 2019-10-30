/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import service.OrganisateurService;
import entity.Organisateurs;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import service.UserService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AjoutorgController implements Initializable {

    @FXML
    private Label nom_org;
    @FXML
    private Label nb_place;
    @FXML
    private Label lieu;
    @FXML
    private Label nom_event;
    @FXML
    private TextField nom_or;
    @FXML
    private TextField lie;
    @FXML
    private TextField nb;
    @FXML
    private TextField nom_e;
    @FXML
    private Button valider;
    @FXML
    private Button retour;
    @FXML
    private Label nb_place1;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         nom_or.addEventHandler(KeyEvent.KEY_TYPED, letter_Validation(20));
      nom_e.addEventHandler(KeyEvent.KEY_TYPED, letter_Validation(20));
      lie.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(4));
    }    

    @FXML
    private void ajout1(ActionEvent event) {
        
        Organisateurs or = new Organisateurs();
        or.setEmail(nb.getText());
        or.setNom(nom_or.getText());
        or.setPrenom(nom_e.getText());
        or.setMdp(password.getText());
        or.setTel(lie.getText());
        OrganisateurService s = new OrganisateurService();
        s.ajouterOrg(or);
       User u = new User() ;
                u.setLogin(nb.getText());
                u.setMdp(password.getText());
                u.setRole("organisateur");
                UserService ur = new UserService();
                ur.AjoutUser(u);
          try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterOrg.fxml"));
            Parent root = (Parent)Loader.load();
            
           
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutorgController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         TrayNotification tray = new TrayNotification("Notification", "l organisateur  " + nom_or.getText() + " ajouté avec succes", NotificationType.NOTICE);
                    tray.setAnimationType(AnimationType.POPUP);
                    tray.showAndDismiss(javafx.util.Duration.seconds(10));
              
        Stage stage = (Stage) valider.getScene().getWindow(); 
           stage.close();
        
    }

    @FXML
    private void bt_Retour(ActionEvent event) {
        
         try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterOrg.fxml"));
            Parent root = (Parent)Loader.load();
            
           
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutorgController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        Stage stage = (Stage) retour.getScene().getWindow(); 
           stage.close();
                     
     
        
    }
   
      public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {
                } else {
                    e.consume();
                }
            }
        };}
    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[0-9]")) {
                } else {
                    e.consume();
                }
            }
        };
    } 
}
