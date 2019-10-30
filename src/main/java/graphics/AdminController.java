/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
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
    @FXML
    private Button Deconnexion;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bthome(ActionEvent event) {
    }

    @FXML
    private void btorganisateur(ActionEvent event) {
           try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterOrg.fxml"));
            Parent root = (Parent)Loader.load();
            
           
            
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
       
       Stage stage = (Stage) btorganisateur.getScene().getWindow(); 
          stage.close();
           
    }

    @FXML
    private void btutilisateur(ActionEvent event) {
        
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterPar.fxml"));
            Parent root = (Parent)Loader.load();
           
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
       Stage stage = (Stage) utilisateur.getScene().getWindow(); 
          stage.close();
        
        
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
    private void btforum(ActionEvent event) {
    }

    @FXML
    private void Deconnexion(ActionEvent event) {
    
         try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            Parent root = (Parent)Loader.load();
            
           
            
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
       
       Stage stage = (Stage) Deconnexion.getScene().getWindow(); 
          stage.close();
    
    }
    
  
}
