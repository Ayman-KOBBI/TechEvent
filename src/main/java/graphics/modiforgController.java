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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.OrganisateurService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import service.UserService;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class modiforgController implements Initializable {

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
    private int idO;
    @FXML
    private Label nb_place1;
    @FXML
    private PasswordField password;
    @FXML
    private Button valid;
    @FXML
    private Button retour;

    public void setIdO(int idO) {
        this.idO = idO;
    }

    public int getIdO() {
        return idO;
    }
    private String mail ; 
    private String pwd ;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    

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
        
         OrganisateurService cr = new OrganisateurService();
             
        cr.modifierOrg(getIdO(),nom_or.getText(),nom_e.getText(),nb.getText(),lie.getText(),password.getText());
       
        UserService ur = new UserService();
        ur.modifierDetail(password.getText(),nb.getText(),getMail(),getPwd());
        
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/consulterOrg.fxml"));
            Parent root = (Parent)Loader.load();
            
           
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutorgController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Stage stage = (Stage) valid.getScene().getWindow(); 
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
   
    
       void setText(String nom , String prenom,String email, int idrecc ,String tel,String password )
    {  
              // this.setTest(idrecc);
   nom_or.setText(nom);
    nom_e.setText(prenom);
    nb.setText(email);
    lie.setText(tel);
        setIdO(idrecc);
        setMail(email);
        setPwd(password);
      
    
//     System.out.println("id 2  : "+getTest());
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
