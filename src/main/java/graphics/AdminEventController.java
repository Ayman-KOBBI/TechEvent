/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AdminEventController implements Initializable {

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
    private TextField nom_or1;
    @FXML
    private TextField nom_e1;
    @FXML
    private TextField lie1;
    @FXML
    private TextField nb1;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField h_e1;
    @FXML
    private TextField px1;
    @FXML
    private TextField desc1;
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
    private void retour(ActionEvent event) {
    }

    @FXML
    private void refrech(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void search(KeyEvent event) {
    }

    @FXML
    private void bt_sup(ActionEvent event) {
    }

    @FXML
    private void bt_aj(ActionEvent event) {
    }
    
}
