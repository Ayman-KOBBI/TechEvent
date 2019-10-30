/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import entity.Participants;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import service.ParticipantService;
import entity.Organisateurs;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ConsulterParController implements Initializable {

    @FXML
    private TableView<Participants> table_par;
    @FXML
    private TableColumn<Participants, String> nom_or;
    @FXML
    private TableColumn<Participants, String> prenom;
    @FXML
    private TableColumn<Participants, String> email;
    @FXML
    private TableColumn<Participants, String> tel;
    @FXML
    private TableColumn<Participants, Integer> solde;
    @FXML
    private TextField tfserach;

    /**
     * Initializes the controller class.
     */
       ObservableList<Participants> data1 = FXCollections.observableArrayList();
    @FXML
    private Button retour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           ParticipantService rc = new ParticipantService();
        data1 = FXCollections.observableArrayList(rc.aaficherPart());
        nom_or.setCellValueFactory(new PropertyValueFactory<Participants, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Participants, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<Participants, String>("email"));
        tel.setCellValueFactory(new PropertyValueFactory<Participants, String>("tel"));
        solde.setCellValueFactory(new PropertyValueFactory<Participants, Integer>("solde"));

        table_par.setItems(data1);
         
        
        
        table_par.setRowFactory( tv -> {
    TableRow<Participants> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (! row.isEmpty()) ) 
            { 
               
               
            try {
                Participants rowData = row.getItem();
                rowData.getId_par();
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("/fxml/verif.fxml"));
                Parent root = (Parent)Loader.load();
                
                verifController tr = Loader.getController();
               
                tr.setIdrecla(rowData.getId_par(), rowData.getNom(),rowData.getPrenom(),rowData.getEmail(),rowData.getMdp());
                //System.out.println("id listtt"+tr.getIdCl());
                //System.out.println("id l"+rowData.getId());
                Stage st= new Stage();
                st.setScene(new Scene(root));
                st.show();
                 
 
            } catch (IOException ex) {
                Logger.getLogger(ConsulterParController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    return row ;
    }); 
     
       
        // TODO
    }    
                

    @FXML
    private void search(KeyEvent event) {
        
        
                  FilteredList<Participants> filterData = new FilteredList<>(data1, p -> true);
        tfserach.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
           
            filterData.setPredicate(pers -> {

                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (pers.getPrenom().toLowerCase().startsWith(typedText)) {

                    return true;
                }
              

                return false;
            });
            SortedList<Participants> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(table_par.comparatorProperty());
            table_par.setItems(sortedList);
                       
            
        });
        
        
        
        
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
    
}
