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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProducts {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clearButton;

    @FXML
    private Button AddNewProduct;

    @FXML
    private TextField pname_Field;

    @FXML
    private TextField pprice_Field1;

    @FXML
    private TextField pdate_Field2;

    @FXML
    private TextField pquality_Field3;

    @FXML
    private TextField pweight_Field4;

    @FXML
    private MenuButton menu;

    @FXML
    private void my_profile(ActionEvent event){
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
    private MenuItem settings;

    @FXML
    private MenuItem korzina;

    @FXML
    private MenuItem sign_out_profile;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void clear(ActionEvent event) {
        pname_Field.setText(null);
        pquality_Field3.setText(null);
        pdate_Field2.setText(null);
        pprice_Field1.setText(null);
        pweight_Field4.setText(null);
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
    void initialize() {
        AddNewProduct.setOnAction( event -> {
            String name = pname_Field.getText();
            String quality = pquality_Field3.getText();
            String date = pdate_Field2.getText();
            double price = Double.parseDouble(pprice_Field1.getText());
            double weight = Double.parseDouble(pweight_Field4.getText());

            Products products = new Products( name, quality, date, price, weight);
            PackageData pd = new PackageData("ADDProduct", products);
            Main.connect(pd);
        });

    }
}
