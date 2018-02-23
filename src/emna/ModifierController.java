/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.produitservice;

/**
 * FXML Controller class
 *
 * @author Sofiene Laouini
 */
public class ModifierController implements Initializable {
private String path="";
    @FXML
    private JFXTextField nom_produit;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField quantite;
    @FXML
    private JFXTextArea description;
    
    private produit p;
    @FXML
    private ImageView image;
    @FXML
    private Label a;

    /**
     * Initializes the controller class.
     */
    public ModifierController(produit p){
        this.p=p;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nom_produit.setText(p.getNomProduit());
        type.setText(p.getType());
        prix.setText(String.valueOf(p.getPrix()));
        quantite.setText(String.valueOf(p.getQuantite()));
        description.setText(p.getDescription());
       
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        
                p.setNomProduit(nom_produit.getText());
                p.setType(type.getText());
                p.setQuantite(Integer.parseInt(quantite.getText()));
                p.setPrix(Integer.parseInt(prix.getText()));
                p.setDescription(description.getText());
                
                
                

                
                produitservice pv=new produitservice();
                pv.updateProduit(p);
            try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("Liste");
            s.setScene(scene);
            s.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Produit");
            s.setScene(scene);
            s.show();
    }
    }
    

