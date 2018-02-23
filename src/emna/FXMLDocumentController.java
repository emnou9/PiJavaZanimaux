/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;
import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.produitservice;

/**
 *
 * @author Sofiene Laouini
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TableView<produit> table;
    @FXML
    private TableColumn<produit, String> id;
    @FXML
    private TableColumn<produit, String> nomProduit;
    @FXML
    private TableColumn<produit, String> type;
    @FXML
    private TableColumn<produit, String> quantite;
    @FXML
    private TableColumn<produit, String> prix;
    @FXML
    private TableColumn<produit, String> description;
    @FXML
    private JFXButton AfficherProduitPB;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        produitservice Service = new produitservice();
        
        ObservableList<produit> listeProduit = FXCollections.observableArrayList(Service.selectProduit());
        table.setItems(listeProduit);
        id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<produit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<produit, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getId());
            }
        });
        nomProduit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<produit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<produit, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNomProduit());
            }
        });
        type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<produit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<produit, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType());
            }
        });
        quantite.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<produit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<produit, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getQuantite());
            }
        });
        prix.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<produit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<produit, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix());
            }
        });
        description.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<produit, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<produit, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDescription());
            }
        });
        
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ajouter.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage) this.table.getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Ajout Produit");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @FXML
    private void supprimer(ActionEvent event) {
        
        try {
            int id = table.getSelectionModel().getSelectedItem().getId();
            produitservice p = new produitservice();
            p.DeletProduitByID(id);
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage x = (Stage) this.table.getScene().getWindow();
            x.setTitle("liste");
            x.setScene(scene);
            x.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void modifier(ActionEvent event) {
            try {
            
            ModifierController cont = new ModifierController(table.getSelectionModel().getSelectedItem());
            final FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("Modifier.fxml"));
            loader.setController(cont);
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(table.getScene().getWindow());
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AfficherProduit(ActionEvent event) throws IOException {
      
            Parent root = FXMLLoader.load(getClass().getResource("productDetails.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage) this.table.getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Produit");
            s.setScene(scene);
            s.show();
            
        
    }
}