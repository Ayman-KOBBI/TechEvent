/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.webkit.graphics.WCGraphicsManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import entity.Forum;
import entity.Commentaire;
import javafx.scene.Node;
import service.forumService;
import service.commentaireService;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class ForumController implements Initializable {

    @FXML
    private TableView<Forum> table;
    @FXML
    private TableColumn<Forum, String> titre;
    @FXML
    private TableColumn<Forum, String> id_user;
    @FXML
    private TableColumn<Forum, Integer> score;
    @FXML
    private TableColumn<Forum, Button> button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    forumService a = new forumService();
    ArrayList<Forum> r = a.afficherarticles();
   ObservableList<Forum> list =FXCollections.observableArrayList();
    for (int i=0 ;i<r.size();i++)
    {
                 
        //Button b = new Button("Consulter");
        Forum p = new Forum();
        p.setTitre(r.get(i).getTitre());
        p.setId_user(r.get(i).getId_user());
        p.setScore(a.nbreponse(r.get(i).getId_article()));
        p.setId_article(r.get(i).getId_article());
        p.setDescription(r.get(i).getDescription());
        p.setDate(r.get(i).getDate());
        try {
            p.setU(a.getUsername(p.getId_user()));
        } catch (SQLException ex) {
            Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
        }
             p.getButton().setOnAction((ActionEvent event) -> {
           
                 FXMLLoader loader=new FXMLLoader (getClass().getResource("/fxml/Article.fxml")) ;
                 //Parent root = null;
            try {
                loader.load();
                //AjoutController irc=loader.getController();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                 ArticleController display = loader.getController();
                 display.setText(p.getDescription(), p.getTitre(), p.getDate(),p.getId_article());
                 
                 Parent p1=loader.getRoot();
                // String str=""+p.getId();
                 Stage primaryStage=new Stage();
                 Scene scene=new Scene(p1);
                // primaryStage.setTitle(str);
                 primaryStage.setScene(scene);
                 primaryStage.showAndWait();
});
        //p.setButton(b);
        list.add(p);
        System.out.println(list);
        
    }
    
    titre.setCellValueFactory(new PropertyValueFactory<Forum,String>("titre"));
    id_user.setCellValueFactory(new PropertyValueFactory<Forum,String> ("u"));
    score.setCellValueFactory(new PropertyValueFactory<Forum,Integer>("score"));
    button.setCellValueFactory(new PropertyValueFactory<Forum,Button>("button"));
       
    table.setItems(list); 
        
        
        // TODO
    }    

    private void actualiser(ActionEvent event) {
        table.refresh();
    }

    @FXML
    private void Stat(ActionEvent event) {
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/Stat.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
        
    }

    @FXML
    private void forum1(ActionEvent event) {
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/Forum.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void article1(ActionEvent event) {
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/CreerArticle.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }
    
}
