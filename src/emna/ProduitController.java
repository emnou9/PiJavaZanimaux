/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entities.animal;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.animalservice;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProduitController implements Initializable {
    animalservice ian = new animalservice();
   Stage mainStage;
     public  animal selectedProd;
    private List<animal> listData;
    private String path = "";
    private int id_produit;

    private String url_uploads;
    @FXML
    private JFXListView<Label> listproduit;
  
    @FXML
    private ImageView ivModif;
    @FXML
    private JFXButton btnModifier;
    @FXML
    private JFXButton btnImagemodifier;
  
    @FXML
    private JFXTextField prixprod;
    @FXML
    private JFXTextField quantiteprod;
      @FXML
    private JFXTextField nomprod;
    @FXML
    private ChoiceBox<String> tchoice;
    @FXML
    private Label ab;
    @FXML
    private Label ab1;
    @FXML
    private Label ab2;
    @FXML
    private Label ab3;
    @FXML
    private Label ab4;
    @FXML
    private JFXHamburger Hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXTextField lastone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
                VBox box = FXMLLoader.load(getClass().getResource("homepannel.fxml"));
                drawer.setSidePane(box);
                } catch (IOException ex) {
                Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
                //Hamburger
                
                HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(Hamburger);
                burgerTask.setRate(-1);
                
                Hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, e ->
                {
                    burgerTask.setRate(burgerTask.getRate() * -1);
                    burgerTask.play();
                    
                    if(drawer.isShown()) drawer.close();
                    else drawer.open();
                });
        // TODO
       ab.setVisible(false);
       ab1.setVisible(false);
       ab2.setVisible(false);
       ab3.setVisible(false);
       ab4.setVisible(false);
     
        btnImagemodifier.setVisible(false);
        btnModifier.setVisible(false);
        lastone.setVisible(false);
         
    
   prixprod.setVisible(false);
    quantiteprod.setVisible(false);
    
     nomprod.setVisible(false);
     ivModif.setVisible(false);
     tchoice.setVisible(false);
        
     
        listData = ian.getAll();

        remplirListView();

    }    

       private void remplirListView() {
        listproduit.getItems().clear();
        for (animal p : listData) {
            Label lbl = new Label(
                    "espece :  "+p.getEspece() + "\n"+
                    "race :  "+p.getRace() + "\n"+
                    "sexe :  "+p.getSexe() + "\n"+
                    "age :  "+p.getAge()+ "\n"+
                    "prix :  "+p.getPrix() + "\n"
            );
            
           /* String img=p.getImage();
            Image image=new Image(img,150,100,true,true);
            
            lbl.setPrefSize(500, 100);
            
                
                ImageView imageView = new ImageView();
                imageView.imageProperty().unbind();
                imageView.setImage(image);
                imageView.setFitWidth(150);
                imageView.setFitHeight(100);
                listproduit.getItems().add(lbl);
                lbl.setGraphic(imageView);*/
            } 
        }
    @FXML
    private void remplirInputs(MouseEvent event) {
      
        btnImagemodifier.setVisible(true);
        btnModifier.setVisible(true);
        nomprod.setVisible(true);
    
        tchoice.setVisible(true);
    
   prixprod.setVisible(true);
    quantiteprod.setVisible(true);
    
     
     ivModif.setVisible(true);
         ab.setVisible(true);
       ab1.setVisible(true);
       ab2.setVisible(true);
       ab3.setVisible(true);
       ab4.setVisible(true);
        lastone.setVisible(true);
        int index = listproduit.getSelectionModel().getSelectedIndex();
        selectedProd = listData.get(index);
        
        
      
        nomprod.setText(selectedProd.getEspece());

        prixprod.setText(selectedProd.getRace());
     ObservableList<String> cursors = FXCollections.observableArrayList("Femelle","Male"); 
    tchoice.setItems(cursors);

        quantiteprod.setText(""+selectedProd.getAge());
        lastone.setText(""+selectedProd.getPrix());
        
      
       /*Image img = new Image(selectedProd.getImage(), 388 , 309, true, true);
            ivModif.imageProperty().unbind();
            ivModif.setImage(img);
            path=selectedProd.getImage();*/
            
    }
   
    @FXML
    private void modifierBug(ActionEvent event) throws IOException {
        animalservice ian = new animalservice();

        animal p = new animal(nomprod.getText(),prixprod.getText(),tchoice.getValue(), path);
        ian.modifier_animal(p,selectedProd.getId()) ;
        Parent homePage = FXMLLoader.load(getClass().getResource("Produit.fxml"));
        
        Scene homePage_scene=new Scene(homePage);
        
        Stage app_stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        
        app_stage.setScene(homePage_scene);
        
        app_stage.show();
    }

    @FXML
    private void uploadModifier(MouseEvent event) throws MalformedURLException {
                FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(ivModif.getScene().getWindow());
        if (file != null) {
            Image img = new Image(file.toURI().toString(), 388 , 309, true, true);
            ivModif.imageProperty().unbind();
            ivModif.setImage(img);
            
        }
        path = file.toURI().toURL().toString();
    }

    

    
}
