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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/*import java.awt.Label;
import java.awt.TextField;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;*/

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable {
    @FXML 
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnConnexion;
    
    @FXML
    private Label lblMsg;
    @FXML
    private Button signup;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
            signup.setOnAction((ActionEvent event) -> {
                FXMLLoader loader = new FXMLLoader(LoginController.this.getClass().getResource("/fxml/inscription.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    signup.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        
        
    
        
        
        

   /* @FXML
    private void btnConnexionAction(javafx.event.ActionEvent event) throws IOException{
        String password= txtPassword.getText();
        String username= txtUsername.getText();
        String role;
     PosteurService p = new PosteurService();
    role=p.login(username, password);
    if( "fault".equals(role))
    {
        JOptionPane.showMessageDialog(null, "Please check your Username and Password");
    }
    else
    {
        Parent root=FXMLLoader.load(getClass().getResource("/fxml/"+role+".fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
        
    }

    @FXML
    private void btnSignupAction(javafx.event.ActionEvent event) throws IOException {
        Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/inscription.fxml"));
        Scene scene = new Scene (signUpPage);
        stage = (Stage)btnSignup.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();*/
        
    }
}
    

