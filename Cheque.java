package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Cheque extends SignInController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label totalLabel;

    @FXML
    private Label date_label;

    @FXML
    private TableView<Products> check;

    @FXML
    private TableColumn<Products, String> products_table;

    @FXML
    private TableColumn<Products, Double> price_table;

    @FXML
    private Label name_label;

    @FXML
    private Button sendButton;

    @FXML
    private Button backButton;

    public void total_price(ObservableList datalist) {
        int totalPrice = 0;
        for (int i = 0; i < datalist.size(); i++) {
            totalPrice += check.getItems().get(i).getPrice();
        }
        totalLabel.setText("  " + String.valueOf(totalPrice));
    }

    @FXML
    void back(ActionEvent event) {
        backButton.getScene().getWindow().hide();
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
    void send(ActionEvent event) {

    }

    @FXML
  public void initialize(URL url, ResourceBundle rb) {
        products_table.setCellValueFactory(new PropertyValueFactory<>("name"));
        price_table.setCellValueFactory(new PropertyValueFactory<>("price"));
        check.setItems(cheque_list);
        total_price(check.getItems());
    }
}
