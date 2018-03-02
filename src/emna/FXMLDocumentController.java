/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.produit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.produitservice;
import util.DataSource;

/**
 *
 * @author Sofiene Laouini
 */
public class FXMLDocumentController implements Initializable {
    int index;
    produit selectedProduct;
        private PreparedStatement preparedStatement;
        produitservice Service = new produitservice();
        List<produit> MyList=Service.selectProduit1();
        ObservableList<produit> listeProduit = FXCollections.observableArrayList(Service.selectProduit1());
    ResultSet rs;
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
    @FXML
    private JFXButton btnmod;
    @FXML
    private JFXButton closebutton;
    @FXML
    private JFXButton exportBT;
    @FXML
    private JFXButton commanderBT;
    @FXML
    private JFXTextField IdProduit;
    @FXML
    private JFXTextField NomProduitTextField;

    @FXML
    private JFXTextField QuantiteProduitTextField;
    @FXML
    private JFXTextField PrixProduitTextField;
    @FXML
    private JFXTextField DescriptionProduitTextField;
    @FXML
    private ChoiceBox<String> tchoice;
    @FXML
    private JFXButton stat;
    @FXML
    private Label user;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
      
               ObservableList<String> c = FXCollections.observableArrayList("Accesoires","produits de lavage ","niches");
                tchoice.setItems(c);
        IdProduit.setVisible(false);
        NomProduitTextField.setVisible(false);
        
        QuantiteProduitTextField.setVisible(false);
        PrixProduitTextField.setVisible(false);
        DescriptionProduitTextField.setVisible(false);
          tchoice.setVisible(false);
        
        
        
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
    private void modifier(ActionEvent event) throws IOException {

        produit newProduit = new produit(NomProduitTextField.getText(),tchoice.getValue(),Integer.parseInt(QuantiteProduitTextField.getText())
                , Integer.parseInt(PrixProduitTextField.getText()),DescriptionProduitTextField.getText());
               
                Service.updateProduit(newProduit,selectedProduct.getId());
                 Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Produit");
            s.setScene(scene);
            s.show();
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

    @FXML
    private void closeButtonAction(ActionEvent event) {
        exit(0);
    }


    @FXML
    private void commander(ActionEvent event) throws IOException {
       
    }

    @FXML
    private void RecupererProduit(MouseEvent event) {
        IdProduit.setVisible(true);
        NomProduitTextField.setVisible(true);
        tchoice.setVisible(true);
        QuantiteProduitTextField.setVisible(true);
        PrixProduitTextField.setVisible(true);
        DescriptionProduitTextField.setVisible(true);
         selectedProduct=table.getSelectionModel().getSelectedItem();
         
        IdProduit.setText(""+selectedProduct.getId());
        NomProduitTextField.setText(selectedProduct.getNomProduit());
        tchoice.setValue(selectedProduct.getType());
       
        QuantiteProduitTextField.setText(""+selectedProduct.getQuantite());
        PrixProduitTextField.setText(""+selectedProduct.getPrix());
        DescriptionProduitTextField.setText(selectedProduct.getDescription());
    }

    @FXML
    private void statistique(ActionEvent event) {
        Scene scene = new Scene(new Group());
        Stage mainStage = new Stage();
        mainStage.setWidth(500);
        mainStage.setHeight(500);
 
        List<produit> liste = new ArrayList<produit>();
     
        liste = new produitservice().getStatCat();
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList();
        for (int i = 0; i < liste.size(); i++) {
            pieChartData.add(new PieChart.Data(liste.get(i).getType(), liste.get(i).getStat()));

        }
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Produit Par type");

        ((Group) scene.getRoot()).getChildren().add(chart);
        mainStage.setScene(scene);
        mainStage.show();

    }

    @FXML
    private void exportToExcel(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
                DataSource ds =DataSource.getInstance();
        String query ="SELECT * from produit";
        preparedStatement = ds.getConnection().prepareStatement(query);
             rs=preparedStatement.executeQuery();
            
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("Liste Produit");
                HSSFRow header = sheet.createRow(0);
                header.createCell(0).setCellValue("ID");
                header.createCell(1).setCellValue("Nom Produit");
                header.createCell(2).setCellValue("Type");
                header.createCell(3).setCellValue("Quantité");
                header.createCell(4).setCellValue("Prix");
                header.createCell(5).setCellValue("Description");
                int index =1;
                while(rs.next()){
                    HSSFRow row = sheet.createRow(index);
                    row.createCell(0).setCellValue(rs.getString("ID"));
                    row.createCell(1).setCellValue(rs.getString("Nom_Produit"));
                    row.createCell(2).setCellValue(rs.getString("Type"));
                    row.createCell(3).setCellValue(rs.getString("Quantite"));
                    row.createCell(4).setCellValue(rs.getString("Prix"));
                    row.createCell(5).setCellValue(rs.getString("Description"));
                    index++;
                    
                }
                FileOutputStream fileOut = new FileOutputStream("ProductDetail.xls");
                wb.write(fileOut);
                fileOut.close();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Excel export");
                alert.setHeaderText(null);
                alert.setContentText("Fichier Excel créé");
                alert.showAndWait();
                preparedStatement.close();
                rs.close();
    }
}