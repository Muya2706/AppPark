package com.example.projet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddControler implements Initializable {

    @FXML
    private TableView<Ligne>tab;

    @FXML
    private TableColumn<Ligne, String> Id;
    @FXML
    private TableColumn<Ligne, String> name;
    @FXML
    private TableColumn<Ligne, String> type;
    @FXML
    private TableColumn<Ligne, String> att;
    @FXML
    public void Accueil(ActionEvent actionEvent) {charger();
    }
    @FXML
    public void Suipprimer(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("My Interface");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Modifier(ActionEvent actionEvent) {
    }
    @FXML
    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private Button ajout,quitter,Supprimer,Modifier,Acceuil;
    @FXML
    public void ajouter(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("world.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("My Interface");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {charger();
    }
    public  void charger(){
        ObservableList<Ligne> ligne= FXCollections.observableArrayList();
        DBConnection con=new DBConnection();

        ResultSet rs = null;
        try {
            Connection conn=con.getConnection();
            rs = conn.createStatement().executeQuery("SELECT * FROM vehicules");

            while (rs.next()) {
                String idList=rs.getString("id");
                String nomList=rs.getString("nom");
                String typeList=rs.getString("type");
                String attributs =rs.getString("attributs");
                ligne.add(new Ligne(idList,nomList,typeList,attributs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        att.setCellValueFactory(new PropertyValueFactory<>("attributs"));
        tab.setItems(ligne);
    }

}
