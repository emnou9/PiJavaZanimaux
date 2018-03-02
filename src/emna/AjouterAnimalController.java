/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.animal;
import entities.produit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.animalservice;
import services.produitservice;

/**
 * FXML Controller class
 *
 * @author Firas Ammar
 */
public class AjouterAnimalController implements Initializable {
        private String path="";
        Stage mainStage;

    @FXML
    private JFXTextField EspeceTF;
    @FXML
    private JFXTextField RaceTF;
    @FXML
    private JFXTextField AgeTF;
    @FXML
    private JFXTextField PrixTF;
    
    @FXML
    private JFXButton ajouterAnimalBT;
    @FXML
    private JFXButton uploadimageAnimalBT;
    @FXML
    private ImageView photoAnimal;
    @FXML
    private ChoiceBox<String> tchoice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              ObservableList<String> c = FXCollections.observableArrayList("Femelle","Male");
                tchoice.setItems(c);
        // TODO
    }    
    @FXML
    private void ajouterAnimal(ActionEvent event) throws IOException, MessagingException {
        

        animal a;
        a = new animal(EspeceTF.getText(),RaceTF.getText(),Integer.parseInt(AgeTF.getText()),Float.parseFloat(PrixTF.getText()),tchoice.getValue(),path);
        animalservice as = new animalservice();
        if (Integer.parseInt(AgeTF.getText())>0&&Integer.parseInt(AgeTF.getText())<19)
        {
        animalservice.insererAnimal(a);
        Parent root = FXMLLoader.load(getClass().getResource("AfficherAnimal.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//            s.initStyle(StageStyle.TRANSPARENT);
            s.setTitle("Afficher Animal");
            s.setScene(scene);
            s.show();
            String mail="emna.khalfa@esprit.tn";
            sendMail("omrane.jalled@esprit.tn","jalled44","Ajout D'animal","votre animal a ete ajouté avec succès",mail);
        }  
          else
            {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainStage);
            alert.setTitle("Verifier vos champs ");
            alert.setHeaderText("le prix doit etre strictement positif");
            alert.setContentText("l'age doit etre etre positive et inf a 19");
            alert.showAndWait();
            }
    }

    @FXML
    private void linkImage(ActionEvent event) {
   
          FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
             
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
                      
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                photoAnimal.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            path=file.toURI().toString();
    }
     public void sendMail(String userMail,String pass,String sujet,String contenu, String send) throws MessagingException{
    
        
        String to = send;
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put( "mail.smtp.host", host );
        prop.put("mail.smtp.user", userMail);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userMail));
         
        InternetAddress toAdresse = new InternetAddress(to);
                
        msg.setRecipient(Message.RecipientType.TO, toAdresse);
        msg.setSubject(sujet);
        msg.setContent(contenu,"text/html; charset=utf-8");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, userMail, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    
          
        
        
    }
    
}
