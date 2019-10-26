/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ParticipantEventController implements Initializable {

    @FXML
    private TableView<?> table_event;
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
    @FXML
    private TableColumn<?, ?> h_e;
    @FXML
    private TableColumn<?, ?> px;
    @FXML
    private TableColumn<?, ?> desc;
    @FXML
    private TextField tfserach;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void search(KeyEvent event) {
    }
    
}
