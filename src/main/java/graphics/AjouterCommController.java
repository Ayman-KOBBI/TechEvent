/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import entity.Forum;
import entity.Commentaire;
import service.forumService;
import service.commentaireService;

/**
 * FXML Controller class
 *
 * @author oussama
 */
public class AjouterCommController implements Initializable {

    @FXML
    private JFXTextArea contenu;
    @FXML
    private JFXButton button;
    @FXML
    private JFXTextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Ajouter(ActionEvent event) {
          String st=id.getText();
        int article = Integer.parseInt(st);
           Commentaire c= new Commentaire(article,11,0,contenu.getText());
           commentaireService a = new commentaireService();
          a.ajoutercomm(c);
    }
   
public void setText(String id)    
{

this.id.setText(id);

}
}
