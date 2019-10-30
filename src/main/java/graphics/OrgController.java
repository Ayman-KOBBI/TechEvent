/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import utils.ConnexionBD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */

public class OrgController implements Initializable {
private String log , pd ;
    @FXML
    private Label prenoml;
    @FXML
    private Label soldel;
    @FXML
    private Label noml;

    public String getLog() {
        return log;
    }

    public String getPd() {
        return pd;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }
    

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private Button Deconnexion;
Connection connection = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //  nom.setText(getMail());
        
    }    

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void event1(ActionEvent event) {
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ConsulterEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void forum(ActionEvent event) {
        
                         FXMLLoader loader=new FXMLLoader (getClass().getResource("/fxml/Forum.fxml")) ;
                 //Parent root = null;
            try {
                loader.load();
                //AjoutController irc=loader.getController();
            } catch (IOException ex) {
                Logger.getLogger(OrgController.class.getName()).log(Level.SEVERE, null, ex);
            }
             Parent p1=loader.getRoot();
                // String str=""+p.getId();
                 Stage primaryStage=new Stage();
                 Scene scene=new Scene(p1);
                // primaryStage.setTitle(str);
                 primaryStage.setScene(scene);
                 primaryStage.showAndWait();
            
    }
//      void SetLogg(String login ,String pwd)
//    {
//        setMail(login);
//     
//    }

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
    
       void setIdrecla(String login , String pwd)
  {setLog(login);
      setPd(pwd);
           
        try {
     
                   Statement st = connection.createStatement();
                   String req = "select nom,prenom from organisateur where email='"+getLog()+"' and mdp='"+getPd()+"'";
                   ResultSet rs = st.executeQuery(req);
                   ResultSetMetaData meta = rs.getMetaData();
                   while (rs.next())
                       
                   {  
                       prenom.setText(rs.getString("prenom"));
                   nom.setText(rs.getString("nom"));
                       
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(PartController.class.getName()).log(Level.SEVERE, null, ex);
               }
  } 
       
       
       
     
}

