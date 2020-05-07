package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuyController extends Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField phonenumber_field;

    @FXML
    private TextField card_field;

    @FXML
    private TextField address_field;

    @FXML
    private Label balance_label;

    @FXML
    private Label price_label;

    @FXML
    private TextField email_field;

    @FXML
    private Button buy_button;

    @FXML
    private Button back_button;

    @FXML
    void buy(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        buy_button.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/sample/Cheque.fxml"));
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
    void back(ActionEvent event) {
        back_button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        if (admin) {
            loader.setLocation(getClass().getResource("/sample/adminsample.fxml"));
            System.out.println("yes");
        } else {
            loader.setLocation(getClass().getResource("/sample/signIn.fxml"));
        }
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
    void initialize() {
    }
}
