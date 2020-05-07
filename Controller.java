package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller  {

    public static boolean admin = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    protected TextField login_Field;

    @FXML
    protected PasswordField password_Field;

    @FXML
    void initialize() {
    }

    @FXML
    public void signInAction(ActionEvent actionEvent) throws SQLException {
        String loginText = login_Field.getText().trim();
        String loginPassword = password_Field.getText().trim();
        if (!loginText.equals("") && !loginPassword.equals("")) {
            DBManager dbManager = new DBManager();
            if(dbManager.Authorization(login_Field.getText(),password_Field.getText())){
                authSignInButton.setOnAction(event -> {
                    if (login_Field.getText().equals("admin") && password_Field.getText().equals("12345")) {
                        authSignInButton.getScene().getWindow().hide();
                        admin = true;
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/adminsample.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    } else {
                        authSignInButton.getScene().getWindow().hide();
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
                });
            } else{
                authSignInButton.setOnAction(event -> {
                    authSignInButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/incorrect.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                });
            }
        } else {
            Shake userLoginAnim = new Shake(login_Field);
            Shake userPassAnim = new Shake(password_Field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
            authSignInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/empty.fxml"));

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
        String userName = login_Field.getText();
        String password = password_Field.getText();
        User user = new User(userName, password);
        PackageData pd = new PackageData("LogIn", user);
        Main.connect(pd);
    }
    public void SignUpAction(ActionEvent actionEvent) {
        loginSignUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/SignUp.fxml"));
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
}

