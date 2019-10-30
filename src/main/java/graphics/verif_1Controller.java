/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import service.ParticipantService;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.OrganisateurService;
import service.UserService;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class verif_1Controller implements Initializable {

    @FXML
    private Label noml;
    @FXML
    private Label prenom;

    private int idOrg;
    @FXML
    private Button retour;
    @FXML
    private Button supp;

    public void setIdOrg(int idOrg) {
        this.idOrg = idOrg;
    }

    public int getIdOrg() {
        return idOrg;
    }
        private String mail ;
    private String pwd ;

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void annuler(ActionEvent event) {
            
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

    @FXML
    private void bt_sup(ActionEvent event) {
        
          try {
            OrganisateurService d = new OrganisateurService();
            d.supprimerOrg(getIdOrg());
            
            UserService ur = new UserService();
             ur.supprimerJUser(getMail(), getPwd());
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterOrg.fxml"));
            Parent root = (Parent)Loader.load();
            
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(verifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
       
    
       Stage stage = (Stage) retour.getScene().getWindow(); 
          stage.close(); 
        
    }
    void setText1(int idO,String nom ,String pren,String mail ,String pwd )
    {noml.setText(nom);
    prenom.setText(pren);
        setIdOrg(idO);
        setMail(mail);
        setPwd(pwd);
    
    }
}
