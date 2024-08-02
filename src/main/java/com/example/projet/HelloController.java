package com.example.projet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class HelloController {

    @FXML
     private TextField idVehicule,nomvehicule,type,attribut;

    Management management=new Management();
    public void ajouter(ActionEvent actionEvent) throws SQLException {
        Management management=new Management();
        management.inserer(idVehicule.getText(), nomvehicule.getText(), type.getText(), attribut.getText());
        Stage stage=(Stage) ((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}