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
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;


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
    private Button btAdmin, btCoAdmin, btSignInAd, btSignInCo, go, btDosen, btKaryawan, keluar, btKembaliJ, btKembaliMenuT, btTambah, btLihat, btKembaliDataDL, btKembaliDDF;
    
    @FXML
    private Group g1, g2;
    
    @FXML
    private ScrollPane DataDiriF;
    
    @FXML
    private AnchorPane loginForm , menuUtama, JurusanList, MenuTampil, DataList, DataDiriForm;
    
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
            go.setVisible(true);
        } else {
            label.setText("username/password anda salah");
        }
    }
    @FXML
    public void goOnClick(ActionEvent event){
        loginForm.setVisible(false);
        menuUtama.setVisible(true);
        JurusanList.setVisible(false);
        MenuTampil.setVisible(false);
        DataList.setVisible(false);
        DataDiriForm.setVisible(false);
        
        
    }
    
    @FXML
    public void DosenOnClick(ActionEvent event){
        JurusanList.setVisible(true);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        MenuTampil.setVisible(false);
        DataList.setVisible(false);
        DataDiriForm.setVisible(false);
        
    }
    
    @FXML
    public void backJurusan(ActionEvent event){
        menuUtama.setVisible(true);
        JurusanList.setVisible(false);
        loginForm.setVisible(false);
        MenuTampil.setVisible(false);
        DataList.setVisible(false);
        DataDiriForm.setVisible(false);
        
    }
    
    @FXML
    public void backMenuTampil(ActionEvent event){
        MenuTampil.setVisible(false);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        JurusanList.setVisible(true);
        DataList.setVisible(false);
        DataDiriForm.setVisible(false);
    }
    
    @FXML
    public void keluar(ActionEvent event){
        loginForm.setVisible(true);
        menuUtama.setVisible(false);
        JurusanList.setVisible(false);
        MenuTampil.setVisible(false);
        DataList.setVisible(false);
        DataDiriForm.setVisible(false);
    }
    
    @FXML
    public void TIFonCLick(ActionEvent event){
        MenuTampil.setVisible(true);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        JurusanList.setVisible(false);
        DataList.setVisible(false);
        DataDiriForm.setVisible(false);
    }
    
    @FXML
    public void tampilkanDataOnClick(ActionEvent event){
        DataList.setVisible(true);
        MenuTampil.setVisible(false);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        JurusanList.setVisible(false);
        DataDiriForm.setVisible(false);
    }
    
    @FXML
    public void backDataD(ActionEvent event){
        DataList.setVisible(false);
        MenuTampil.setVisible(true);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        JurusanList.setVisible(false);
        DataDiriForm.setVisible(false);
    }
    
    @FXML
    public void tambahOnClick(ActionEvent event){
        DataDiriForm.setVisible(true);
        DataList.setVisible(false);
        MenuTampil.setVisible(false);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        JurusanList.setVisible(false);
    }
    
    @FXML
    public void backDDF(ActionEvent event){
        DataDiriForm.setVisible(false);
        DataList.setVisible(true);
        MenuTampil.setVisible(false);
        loginForm.setVisible(false);
        menuUtama.setVisible(false);
        JurusanList.setVisible(false);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
