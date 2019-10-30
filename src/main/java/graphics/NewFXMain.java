/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import utils.Mail;

/**
 *
 * @author Amir
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException, MessagingException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Forum.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
        
        
      // Mail.sendMail("khayatmed@aol.com", "vrladxidydchjwzs", "Events", "votre evenement est accepter");

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
