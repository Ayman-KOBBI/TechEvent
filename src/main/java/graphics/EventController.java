/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Events;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EventService;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class EventController implements Initializable {

    @FXML
    private Label prix;
    @FXML
    private Label dt_event;
    @FXML
    private Label nb_place;
    @FXML
    private Label lieu;
    @FXML
    private Label description;

    @FXML
    private TextField lie;
    @FXML
    private TextField nb;
    @FXML
    private TextField desc;
   
    @FXML
    private TextField px;
    private TextField h_e;
    @FXML
    private DatePicker date;
    @FXML
    private Label nom_org;
    @FXML
    private Label nom_event;
    @FXML
    private TextField nom_or;
    @FXML
    private TextField nom_e;
    private TextField et;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO

      
        
    }    

    @FXML
    private void ajout1(ActionEvent event) throws SQLException {
        
        if(date.getValue() == null ||desc.getText().equals("") || lie.getText().equals("") || px.getText().equals("")|| nom_e.getText().equals("") || nom_or.getText().equals("")|| nb.getText().equals("") ){ 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("OPPS");
                alert.setHeaderText("Erreur !!");
                alert.setContentText("svp remplir les champs");
                 alert.showAndWait();
}
       
                
        else{
            String nom_org = nom_or.getText();
            String nom_event = nom_e.getText();
            String lieu= lie.getText();
            int nb_place = Integer.parseInt(nb.getText());
            LocalDate locald = date.getValue();
            Date dt_event = Date.valueOf(locald);
            String etat= "En attent";
            int prix= Integer.parseInt(px.getText());
            
            String description= desc.getText();
            
            Events E1= new Events(nom_org, nom_event, lieu, nb_place, dt_event, prix, description, etat);
            EventService p = new EventService();
            p.creerEvent(E1);
            
            JOptionPane.showMessageDialog(null, "Event créer");
           
        }
        
    }

    @FXML
    private void bt_Retour(ActionEvent event) {
        
      Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ConsulterEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bt_annuler(ActionEvent event) throws DocumentException, IOException {
        
       Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 29,
      Font.BOLD, BaseColor.RED);
     Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
      Font.BOLD,BaseColor.BLUE);
      Font sedFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD,BaseColor.GRAY);
      FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*.pdf"));
        fc.setTitle("save tp pdf");
        fc.setInitialFileName("events.pdf");
        Stage window = new Stage();

           
            File file=fc.showSaveDialog(window);
            String str = file.getAbsolutePath();
            if(file!=null)
            {
                OutputStream fil = new FileOutputStream(new File(str));


            Document document = new Document();

            PdfWriter.getInstance(document, fil);


            document.open();
    document.add(new Paragraph( "                             Expo'Tech ", catFont));
         document.add(new Paragraph( " \n \n  Votre evenement créer : ", subFont));

    String para1="        \n \n             Nom organisateur : "+nom_or.getText()
                  //  + "\n \n               : "+nom_or.getText()
                    + "\n \n              Nom evenement :  "+nom_e.getText()
                    + "\n \n              lieu evenement : "+lie.getText()
                    + "\n \n              nombre de place :      "+nb.getText()
                    + "\n \n              date evenement : "+ date.getValue()
                    + "\n \n              prix(dt) :    "+px.getText()
                   
                    + "\n \n              decription :      "+desc.getText();
                    
        

            Paragraph paragraph = new Paragraph(para1);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
            document.add(new Paragraph(" \n \n Merci ATTENT LA RESPONSE JE VEUX ENVOIE UN MAIL OU SMS",
        sedFont));

   
   
     document.close();
            fil.close();
       
    }
    }

    
}
