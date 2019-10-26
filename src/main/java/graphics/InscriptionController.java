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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class InscriptionController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private Button retour;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
        
        /*    retour.setOnAction((ActionEvent event) -> {
                FXMLLoader loader = new FXMLLoader(InscriptionController.this.getClass().getResource("/fxml/login.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    retour.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });*/
                
    }
                  
    /*@FXML
    private void btnEnregistrerAction(ActionEvent event) throws SQLException {
        String nom = nom.getText();
        String prenom= prenom.getText();
        String tel= tel.getText();
        String email= email.getText();
        int id_par = 0;
        Participants E1= new Participants(id_par,nom,prenom,tel,email);
           ParService p = new ParService();
              p.creerPar(E1);
              JOptionPane.showMessageDialog(null, "Account Created Successfull");
    }*/

    @FXML
    private void btnEnregistrerAction(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
         Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }


}

            
                    

    

