/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Mail;
import entities.animal;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import services.animalservice;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Firas Ammar
 */
public class AfficherAnimalController implements Initializable {

    @FXML
    private TableColumn<animal, String> id;
    @FXML
    private TableColumn<animal, String> espece;
    @FXML
    private TableColumn<animal, String> race;
    @FXML
    private TableColumn<animal, String> age;
    @FXML
    private TableColumn<animal, String> prix;
    @FXML
    private TableColumn<animal, String> sexe;
    @FXML
    private TableView<animal> table;
    @FXML
    private JFXButton AjouterBT;
    @FXML
    private JFXButton suppromerBT;
    @FXML
    private JFXButton AjouterBT1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // TODO
         animalservice Service = new animalservice();
        
        ObservableList<animal> list = FXCollections.observableArrayList(Service.selectAnimal());
        table.setItems(list);
        id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<animal, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<animal, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getId());
            }
        });
        espece.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<animal, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<animal, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getEspece());
            }
        });
        race.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<animal, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<animal, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getRace());
            }
        });
        age.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<animal, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<animal, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getAge());
            }
        });
        prix.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<animal, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<animal, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix());
            }
        });
        sexe.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<animal, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<animal, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getSexe());
            }
        });
       
        
    }    

    @FXML
    private void ajouterAnimal(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterAnimal.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage) this.table.getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Ajout Animal");
            s.setScene(scene);
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimerAnimal(ActionEvent event) {
         try {
            int id = table.getSelectionModel().getSelectedItem().getId();
            animalservice a = new animalservice();
            a.DeletAnimalByID(id);
            Parent root = FXMLLoader.load(getClass().getResource("AfficherAnimal.fxml"));
            Scene scene = new Scene(root);
            Stage x = (Stage) this.table.getScene().getWindow();
            x.setTitle("Afficher Animal");
            x.setScene(scene);
            x.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Produit");
            s.setScene(scene);
            s.show();
    }


    
    
}
