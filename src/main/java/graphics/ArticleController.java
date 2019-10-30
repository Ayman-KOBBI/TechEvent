package graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entity.Commentaire;
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
import service.forumService;
import service.commentaireService;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class ArticleController implements Initializable {

    @FXML
    private JFXTextArea contenu;
    @FXML
    private JFXTextArea titre;
    @FXML
    private JFXTextField date;
    @FXML
        private TableView<Commentaire> table;
    @FXML
     private TableColumn<Commentaire,String> commentaire;
    @FXML
    private TableColumn<Commentaire,Integer> score;
    @FXML
    private TableColumn<Commentaire,Button> like;
    
    @FXML
      private TableColumn<Commentaire,Button> dislike;
    @FXML
    private TableColumn<Commentaire, String> date1;
    @FXML
    private Button btn;
    @FXML
    private JFXButton boutonA;
    @FXML
    private JFXTextField id;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                btn.setOnAction((event) -> {
            try {
                FXMLLoader loader=new FXMLLoader (getClass().getResource("/fxml/AjouterComm.fxml")) ;
                Parent root=loader.load();
                 AjouterCommController display = loader.getController();
                 display.setText(id.getText());
                 
                 
                
                //AjoutController irc=loader.getController();
                
                
                Stage primaryStage=new Stage();
                Scene scene=new Scene(root);
                primaryStage.setTitle("Publications");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
            }
   
});
               boutonA.setOnAction((event) -> {
             forumService a = new forumService();
        // Post p = a.afficherunpost(123);
         //titre.setText(p.getTitre());
       //  date.setText(p.getDate());
        // contenu.setText(p.getContenu());
        Forum p = new Forum ();
        String mystring= id.getText();
        int article = Integer.parseInt(mystring);
        p.setId_article(article);
         commentaireService crud = new commentaireService();
         
    ArrayList<Commentaire> r = crud.affichercomm(p);
     ObservableList<Commentaire> list =FXCollections.observableArrayList();
    for (int i=0 ;i<r.size();i++)
    {
        Commentaire c = new Commentaire( article,r.get(i).getId_user(), r.get(i).getScore(), r.get(i).getText(),r.get(i).getDate());
        c.setId_comm(r.get(i).getId_comm());
        System.out.println(c.getId_comm());
     
        c.getButton1().setOnAction((event1) -> {
            crud.like(c);    table.refresh();  boutonA.fire();
                
   
});
                c.getButton2().setOnAction((event2) -> {
            crud.dislike(c); table.refresh(); boutonA.fire();
   
});
                
        list.add(c);
        
    
        }
    System.out.println(list);
   commentaire.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("Text"));
   dislike.setCellValueFactory(new PropertyValueFactory<Commentaire,Button>("button2"));
   score.setCellValueFactory(new PropertyValueFactory<Commentaire,Integer>("score"));
   like.setCellValueFactory(new PropertyValueFactory<Commentaire,Button>("button1"));
   date1.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("date"));
   table.setItems(list);
   table.refresh();
           
   
}); 
}
  
    public void setText(String contenu,String titre, String date ,int id)    
{
this.contenu.setText(contenu);
this.titre.setText(titre);
this.date.setText(date);
String str=""+id;
this.id.setText(str);

}

    @FXML
    private void modifier(ActionEvent event) {
        forumService a = new forumService();
        String st=id.getText();
        int test = Integer.parseInt(st);
        a.modifierarticle(test, titre.getText(),contenu.getText());
        Parent PageParent = null;
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        forumService a = new forumService();
        String st=id.getText();
        int test = Integer.parseInt(st);
        a.supprimerarticle(test);
            
        
        
    }
 
}
