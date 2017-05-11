/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myidentity1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.Group;


/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField tfUserAd, tfUserCo;
    
    @FXML
    private PasswordField tfPassAd, tfPassCo;
    
    @FXML
    private Button btAdmin, btCoAdmin, btSignInAd, btSignInCo;
    
    @FXML
    private Group g1, g2;
    
    
    @FXML
    public void AdminOnClick(ActionEvent event){
        g1.setVisible(true);
        g2.setVisible(false);
    }
    
    @FXML
    public void CoAdminOnClick(ActionEvent event){
        g1.setVisible(false);
        g2.setVisible(true);
    }
    
    @FXML
    public void SignInAdminOnClick(ActionEvent event){
        if(tfUserAd.getText().equalsIgnoreCase("erna") && tfPassAd.getText().equalsIgnoreCase("12345")){
            label.setText("Silahkan masuk");
        } else {
            label.setText("username/password anda salah");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
