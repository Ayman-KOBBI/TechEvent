/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import service.ParticipantService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import entity.Organisateurs;
import entity.Participants;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import service.OrganisateurService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import service.UserService;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ConsulterOrgController implements Initializable {

    @FXML
    private TableView<Organisateurs> table_org;
    @FXML
    private TableColumn<Organisateurs, String> nom_or;
    @FXML
    private TableColumn<Organisateurs, String> prenom;
    @FXML
    private TableColumn<Organisateurs, String> tel;
    @FXML
    private TableColumn<Organisateurs, String> email;
    @FXML
    private TextField tfserach;

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableColumn<Organisateurs, Button> modifcol;
    @FXML
    private TableColumn<Organisateurs, Button> suppcol;
    @FXML
    private Button ajout;
    @FXML
    private Button retour;
    
   ObservableList<Organisateurs> data1 =FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     OrganisateurService cr = new OrganisateurService();

ArrayList<Organisateurs> r = cr.aaficherOrg();

       for (int i=0 ;i<r.size();i++)
    { 
        //Button b = new Button("Consulter");
        Organisateurs p = new Organisateurs();
        p.setNom(r.get(i).getNom());
        p.setPrenom(r.get(i).getPrenom());
        p.setEmail(r.get(i).getEmail());
        p.setTel(r.get(i).getTel());
        p.setMdp(r.get(i).getMdp());
        p.setId_org(r.get(i).getId_org());
      
             p.getModifier().setOnAction((ActionEvent event) -> {
           
            try {
                
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/modiforg.fxml"));
                Parent root = (Parent)Loader.load();
                 modiforgController display = Loader.getController();
         
                display.setText( p.getNom(), p.getPrenom(),p.getEmail(),p.getId_org(),p.getTel(),p.getMdp());
                       
                
                Stage st= new Stage();
                st.setScene(new Scene(root));
                st.show();
       
              
  Stage stage = (Stage) p.getModifier().getScene().getWindow();
              stage.close();
            } catch (IOException ex) {
                Logger.getLogger(OrganisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
});
             
             
           
             
           
             p.getSupprimer().setOnAction((ActionEvent event) -> {
                 
                      try {
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/verif_1.fxml"));
                Parent root = (Parent)Loader.load();
                
                Stage st= new Stage();
                st.setScene(new Scene(root));
                st.show();
                                
                verif_1Controller display = Loader.getController();
                display.setText1( p.getId_org(),p.getNom(),p.getPrenom(),p.getEmail(),p.getMdp());
                         
                            Stage stage = (Stage) p.getSupprimer().getScene().getWindow();
        stage.close();

            } catch (IOException ex) {
                Logger.getLogger(OrganisateurService.class.getName()).log(Level.SEVERE, null, ex);
            }
      
});      
             
        //p.setButton(b);
           data1.add(p);
           
       
           
           
    
        
    } 
        
        
        
        
        
            
        
        
        
        
        /***********************/
        nom_or.setCellValueFactory(new PropertyValueFactory<Organisateurs, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Organisateurs, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<Organisateurs, String>("email"));
        tel.setCellValueFactory(new PropertyValueFactory<Organisateurs, String>("tel"));
         modifcol.setCellValueFactory(new PropertyValueFactory<Organisateurs,Button>("modifier"));
        suppcol.setCellValueFactory(new PropertyValueFactory<Organisateurs,Button>("supprimer"));


        table_org.setItems(data1);
        
         
        // TODO
    }    

    @FXML
    private void bt_aj(ActionEvent event) {
              
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/ajoutorg.fxml"));
            Parent root = (Parent)Loader.load();
            
           
            Stage st= new Stage();
            st.setScene(new Scene(root));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterParController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       Stage stage = (Stage) ajout.getScene().getWindow(); 
          stage.close();   
        
        
    }


    private void search(KeyEvent event) {
        
        
    }

    @FXML
    private void retour(ActionEvent event) {
           try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
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
    private void tfsearch(KeyEvent event) {
    }
    
}
