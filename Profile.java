package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Profile extends SignInController implements Initializable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Products> products;

    @FXML
    private TableColumn<Products, String> name;

    @FXML
    private TableColumn<Products, String> weight;

    @FXML
    private TableColumn<Products, Double> price;

    @FXML
    private Label card;

    @FXML
    private Button buy;

    @FXML
    private Button edit;

    @FXML
    private Label surname;

    @FXML
    private MenuButton menu;

    @FXML
    private MenuItem my_profile;

    @FXML
    private MenuItem settings;

    @FXML
    private MenuItem korzina;

    @FXML
    private MenuItem sign_out_profile;

    @FXML
    void delete(MouseEvent event) {

    }
    @FXML
    void buy(ActionEvent event) {
        menu.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/signIn.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void sign_out_menu(ActionEvent event) {
        menu.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/sample.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void basket(ActionEvent event) {
        menu.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/basket.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        weight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        products.setItems(saved_list);
    }
}
