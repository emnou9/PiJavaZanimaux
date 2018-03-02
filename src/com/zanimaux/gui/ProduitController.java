/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanimaux.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Emna
 */
public class ProduitController implements Initializable {

    @FXML
    private JFXListView<?> listproduit;
    @FXML
    private JFXTextField nomprod;
    @FXML
    private ImageView ivModif;
    @FXML
    private JFXButton btnModifier;
    @FXML
    private JFXButton btnImagemodifier;
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
    private JFXTextField prixprod;
    @FXML
    private JFXTextField quantiteprod;
    @FXML
    private ChoiceBox<?> tchoice;
    @FXML
    private JFXHamburger Hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXTextField lasto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void remplirInputs(MouseEvent event) {
    }

    @FXML
    private void modifierBug(ActionEvent event) {
    }

    @FXML
    private void uploadModifier(MouseEvent event) {
    }
    
}
