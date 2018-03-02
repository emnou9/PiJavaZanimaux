/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomepannelController implements Initializable {

    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton logoutPB;
    @FXML
    private JFXButton emna;
    @FXML
    private JFXButton aff;

    @FXML
    private JFXButton firas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    


    @FXML
    private void HomeClick(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
        app_stage.show();
    }



   



    @FXML
    private void Logout(ActionEvent event) {
        exit(0);
    }



   


    @FXML
    private void addproduit(ActionEvent event) throws IOException {
           Parent homePage = FXMLLoader.load(getClass().getResource("ajouter.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
        app_stage.show();
    }

    @FXML
    private void afficherprod(ActionEvent event) throws IOException {
           Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
        app_stage.show();
    }

    @FXML
    private void ajoutanimal(ActionEvent event) throws IOException {
             Parent homePage = FXMLLoader.load(getClass().getResource("AjouterAnimal.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
        app_stage.show();
    }

    @FXML
    private void afficheranimal(ActionEvent event) throws IOException {
                   Parent homePage = FXMLLoader.load(getClass().getResource("AfficherAnimal.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
        app_stage.show();
    }
    
}
