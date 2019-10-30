/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import static com.itextpdf.text.Annotation.FILE;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Events;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.management.Notification;
import javax.swing.JOptionPane;
import service.EventService;
import utils.Mail;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.rmi.PortableRemoteObject.connect;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;//mochkel ta3 library 3andek rahou !  slaey7e ha 
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import utils.ConnexionBD;
import static utils.SmsSender.sendSms;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AdminEventController implements Initializable {

    @FXML
    private TableView table_event;
    @FXML
    private TableColumn<?, ?> nom_or;
    @FXML
    private TableColumn<?, ?> nom_e;
    @FXML
    private TableColumn<?, ?> lie;
    @FXML
    private TableColumn<?, ?> nb;
    @FXML
    private TableColumn<?, ?> dt_e;
    private TableColumn<?, ?> h_e;
    @FXML
    private TableColumn<?, ?> px;
    @FXML
    private TableColumn<?, ?> desc;
    @FXML
    private TextField nom_or1;
    @FXML
    private TextField nom_e1;
    @FXML
    private TextField lie1;
    @FXML
    private TextField nb1;
    @FXML
    private DatePicker date1;
    private TextField h_e1;
    @FXML
    private TextField px1;
    @FXML
    private TextField desc1;
    @FXML
    private TextField tfserach;
    @FXML
    private TableColumn<?, ?> et;
    @FXML
    private TextField et1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          EventService p= new EventService();
        ArrayList<Events> e = (ArrayList<Events>) p.affichierEvent(); 
        ObservableList<Events> obs=FXCollections.observableArrayList(e);
        table_event.setItems(obs);
        nom_or.setCellValueFactory(new PropertyValueFactory<>("nom_org") );
        nom_e.setCellValueFactory(new PropertyValueFactory<>("nom_event") );
        lie.setCellValueFactory(new PropertyValueFactory<>("lieu") );
        nb.setCellValueFactory(new PropertyValueFactory<>("nb_place") );
        dt_e.setCellValueFactory(new PropertyValueFactory<>("dt_event") );
        et.setCellValueFactory(new PropertyValueFactory<>("etat") );
        px.setCellValueFactory(new PropertyValueFactory<>("prix") );
        desc.setCellValueFactory(new PropertyValueFactory<>("description") );
        
         EventService ps=new EventService();
        ////////////
        table_event.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    Events e=(Events) table_event.getItems().get(table_event.getSelectionModel().getSelectedIndex());
                    nom_or1.setText(e.getNom_org());
                nom_e1.setText(e.getNom_event());
                     String date=String.valueOf(e.getDt_event()); 
                   LocalDate date2 = LocalDate.parse(date);
                   date1.setValue(date2);
               et1.setText(e.getEtat());
                lie1.setText(e.getLieu());
                px1.setText(Integer.toString(e.getPrix()));
                nb1.setText(Integer.toString(e.getNb_place()));
                desc1.setText(e.getDescription());
                    
                }
            }
        });
 
    }    

    @FXML
    private void retour(ActionEvent event) {
          Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ModifEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void refrech(ActionEvent event) {
           if(date1.getValue() == null ||desc1.getText().equals("") || lie1.getText().equals("") || px1.getText().equals("")|| nom_e1.getText().equals("")|| nom_or1.getText().equals("")|| nb1.getText().equals("") ){ 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("OPPS");
                alert.setHeaderText("Erreur !!");
                alert.setContentText("svp remplir les champs");
                 alert.showAndWait();
}else{
        String nom_org = nom_or1.getText();
        String nom_event = nom_e1.getText();
        String lieu= lie1.getText();
        int nb_place = Integer.parseInt(nb1.getText());
        LocalDate locald = date1.getValue();
        Date dt_event = Date.valueOf(locald);  
        String etat= et1.getText();
        int prix= Integer.parseInt(px1.getText());
        String description= desc1.getText();
        Events E1= new Events(nom_org, nom_event, lieu, nb_place, dt_event, prix, description, etat);
        EventService p = new EventService();
        p.modifEvent(E1);
        JOptionPane.showMessageDialog(null, "Event modifier");}
     
        
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
          nom_or1.setText("");
       nom_e1.setText("");
        lie1.setText("");
       nb1.setText(null);
        date1.setValue(null);
        et1.setText("");
        px1.setText("");
        
        desc1.setText("");
    }

    @FXML
    private void search(KeyEvent event) {
           EventService p = new EventService();
            String m = tfserach.getText().concat("%");
            ArrayList<Events> e= (ArrayList<Events>) p.chercher(m);
            ObservableList<Events> obs=FXCollections.observableArrayList(e);
            table_event.setItems(obs);
    }

    @FXML
    private void bt_sup(ActionEvent event) {
        EventService cs = new EventService();
      
        Events a = (Events) table_event.getSelectionModel().getSelectedItem();
        cs.supprEvent(a);
        JOptionPane.showMessageDialog(null, "Events supprimer ");

        
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bt_aj(ActionEvent event) {
        Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/ModifEvent.fxml"));
            
        
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bt_acc(ActionEvent event) throws IOException, MessagingException  {
        EventService e = new EventService();
        Events e1=(Events) table_event.getItems().get(table_event.getSelectionModel().getSelectedIndex());
            e.AccepterEvent(e1);

            
            
           // sendSms();
           //     Mail.sendMail("khayatmed@aol.com", "vrladxidydchjwzs", "Events", "votre evenement est accepter");
JOptionPane.showMessageDialog(null, "Events accepter ");
    Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    @FXML
    private void bt_ref(ActionEvent event) throws IOException, MessagingException  {
       
        EventService e = new EventService();
      
        Events e1=(Events) table_event.getItems().get(table_event.getSelectionModel().getSelectedIndex());
            e.RefuserEvent(e1);
        // Mail.sendMail("khayatmed@aol.com", "vrladxidydchjwzs", "Event", "votre evenement est refuser");
JOptionPane.showMessageDialog(null, "Events refuser ");
 Parent PageParent = null;
        try {
            PageParent = FXMLLoader.load(getClass().getResource("/fxml/AdminEvent.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene PageScene = new Scene(PageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(PageScene);
        window.show();
    }

    
   
    
    @FXML
    private void bt_im(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
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
       PdfPTable table = new PdfPTable(8);
    
     
  //  t.setBorderColor(BaseColor.GRAY);
    // t.setPadding(4);
    // t.setSpacing(4);
    // t.setBorderWidth(1);

    PdfPCell c1 = new PdfPCell(new Phrase("Nom_org"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Nom_event"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Lieu"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    c1 = new PdfPCell(new Phrase("nb_palce"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    c1 = new PdfPCell(new Phrase("dt_event"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    c1 = new PdfPCell(new Phrase("Etat"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    c1 = new PdfPCell(new Phrase("Prix"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    c1 = new PdfPCell(new Phrase("Description"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    table.setHeaderRows(1);
     table.addCell( nom_or1.getText());
    table.addCell(nom_e1.getText());
    table.addCell(lie1.getText());
    table.addCell(nb1.getText());
  
    table.addCell(dt_e.getText());
    table.addCell(et1.getText());
    table.addCell(px1.getText());
    table.addCell(desc1.getText());
    
    
    document.add(table);
     document.close();
            fil.close();
            }
    }
    
}
