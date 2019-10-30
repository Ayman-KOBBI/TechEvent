/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import service.OrganisateurService;
import service.UserService;
import entity.Organisateurs;
import entity.User;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ParticipantService;
import service.UserService;
import entity.Participants;
import java.io.UnsupportedEncodingException;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;




/**
 * FXML Controller class
 *
 * @author DELL
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tnom;
    @FXML
    private TextField tprenom;
    @FXML
    private TextField ttel;
    @FXML
    private TextField temail;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField password;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        tnom.addEventHandler(KeyEvent.KEY_TYPED, letter_Validation(20));
      tprenom.addEventHandler(KeyEvent.KEY_TYPED, letter_Validation(20));
      ttel.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(4));
      //temail.addEventFilter(KeyEvent.KEY_TYPED, mail_Validation(30));
    }    

      
   
        
    @FXML
    private void btnEnregistrerAction(ActionEvent event) {
          
          
                
                
               
                Participants r = new Participants();
                r.setNom(tnom.getText());
                r.setPrenom(tprenom.getText());
                r.setEmail(temail.getText());
                r.setTel(ttel.getText());
                r.setMdp(password.getText());
                r.setSolde(0);
                ParticipantService cr = new ParticipantService();
                cr.ajouterPart(r);
                
                User u = new User() ;
                u.setLogin(temail.getText());
                u.setMdp(password.getText());
                u.setRole("participant");
                UserService ur = new UserService();
                ur.AjoutUser(u);
                
                Stage stage = (Stage) btnEnregistrer.getScene().getWindow();
                stage.close();
                
                try {
                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
                    Parent root = (Parent)Loader.load();
                    
                    
                    Stage st= new Stage();
                    st.setScene(new Scene(root));
                    st.show();
                } catch (IOException ex) {
                    Logger.getLogger(AjoutorgController.class.getName()).log(Level.SEVERE, null, ex);
                }
 
                    TrayNotification tray = new TrayNotification("Notification", "User  " + tnom.getText() + " ajouté avec succes", NotificationType.NOTICE);
                    tray.setAnimationType(AnimationType.POPUP);
                    tray.showAndDismiss(javafx.util.Duration.seconds(10));
              
                
    }

    @FXML
    private void retour(ActionEvent event) {
           
              try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
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
 

/*public EventHandler<KeyEvent> mail_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,6}$")) {
                } else {
                    e.consume();
                }
            }
        };
    }
*/


//""    
}
