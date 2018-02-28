/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emna;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.DataSource;

/**
 * FXML Controller class
 *
 * @author Emna
 */
public class LoginController implements Initializable {
    private PreparedStatement preparedStatement;

    @FXML
    private JFXTextField usernameTF;
    @FXML
    private JFXPasswordField passwordTF;
    @FXML
    private JFXButton loginBT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void LogIn(ActionEvent event) throws SQLException, IOException {

DataSource ds =DataSource.getInstance(); 
       String sql_query = "SELECT * from utilisateur WHERE login='"+usernameTF.getText()+"'AND password='"+passwordTF.getText()+"'";
       
            preparedStatement = ds.getConnection().prepareStatement(sql_query);
            boolean status =preparedStatement.execute();
            System.out.println("achraf");
            if(status){
                System.out.println("Login success");
               Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage s = new Stage();
            s.setTitle("Login");
            s.setScene(scene);
            s.show();
                Stage stage = (Stage) loginBT.getScene().getWindow();
    stage.close();

            }else
                System.out.println("Login failed");//  
    }

   
}
