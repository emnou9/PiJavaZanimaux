/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import services.produitservice;

/**
 * FXML Controller class
 *
 * @author Emna
 */
public class ProductDetailsController implements Initializable {
    Stage mainStage;
    private produit selectedProduct;
    produitservice prod = new produitservice();
    List<produit> MyList = new ArrayList<>();
    List<produit> listData;
    @FXML
    private ListView<Label> ProductListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyList=prod.selectProduit();
        RemplirListView();
        listData = prod.selectProduit1();
    }    

    private void RemplirListView() {
      ProductListView.getItems().clear();
        for (produit produit : MyList) {
            Label lbl = new Label("Nom produit :"+produit.getNomProduit()+"\n Type :"+produit.getType()+"\n Description :"+produit.getDescription()+"\n Quantite :"+produit.getQuantite()
            );
            
            String img=produit.getImage();
            Image image=new Image(img,150,100,true,true);
            
            lbl.setPrefSize(500, 100);
            
                
                ImageView imageView = new ImageView();
                imageView.imageProperty().unbind();
                imageView.setImage(image);
                imageView.setFitWidth(150);
                imageView.setFitHeight(100);
                ProductListView.getItems().add(lbl);
                lbl.setGraphic(imageView);
            } 
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Produit");
            s.setScene(scene);
            s.show();
    }

    @FXML
    private void Commander(ActionEvent event) throws IOException {
            int x=ProductListView.getSelectionModel().getSelectedIndex();
            selectedProduct=listData.get(x);
            if (selectedProduct.getQuantite()>=1)
            { 
            System.out.println("haha"+selectedProduct.getId());
            
                  produitservice p = new produitservice();
            produitservice.commanderProduit(selectedProduct);
              Parent root = FXMLLoader.load(getClass().getResource("productDetails.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Produit");
            s.setScene(scene);
            s.show(); }  
            else
            {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainStage);
            alert.setTitle("stock épuisé ");
            alert.setHeaderText("Nous sommes désolés");
            alert.setContentText("");
            alert.showAndWait();
            }
    
    
    
}
   
    
   
}
