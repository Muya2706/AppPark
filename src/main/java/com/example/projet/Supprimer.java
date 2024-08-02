package com.example.projet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Supprimer {
    @FXML
    private TextField supprime;

    public void supprimer(ActionEvent actionEvent) throws SQLException {

        Management management=new Management();
        management.supprimer(supprime.getText());
        Stage stage=(Stage) ((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
