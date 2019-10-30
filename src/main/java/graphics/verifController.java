/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import service.ParticipantService;
import service.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class verifController implements Initializable {

    private int Test ; 
    @FXML
    private Label noml;
    @FXML
    private Label prenom;
    @FXML
    private Button retour;
    @FXML
    private Button supp;

    public void setTest(int Test) {
        this.Test = Test;
    }

    public int getTest() {
        return Test;
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
            
      
    
       Stage stage = (Stage) retour.getScene().getWindow(); 
          stage.close(); 
    }

    @FXML
    private void bt_sup(ActionEvent event) {
        try {
            ParticipantService d = new ParticipantService();
            d.supprimerPart(getTest());
             UserService ur = new UserService();
             ur.supprimerJUser(getMail(), getPwd());
             
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterPar.fxml"));
            Parent root = (Parent)Loader.load();
            
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(verifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
       Stage stage = (Stage) supp.getScene().getWindow(); 
          stage.close(); 
       
        
    }
    
       void setIdrecla(int idrecc , String nom , String prenom,String mail,String pwd  )
    {  this.setTest(idrecc);
    noml.setText(nom);
    this.prenom.setText(prenom);
    
        setMail(mail);
        setPwd(pwd);
    
    
    }
    
}
