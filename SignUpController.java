package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.User;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLogin_Field;

    @FXML
    private PasswordField signUpPassword_Field;

    @FXML
    private TextField signUpLocation_Field;

    @FXML
    private TextField signUpLastName_Field;

    @FXML
    private TextField signUpFirstName_Field;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private Button signUpAuthSignInButton;

    @FXML
    void initialize() {

        signUpAuthSignInButton.setOnAction(event ->{
            signUpNewUser();
        });
    }

    private void signUpNewUser() {

        signUpAuthSignInButton.setOnAction(event -> {
            String firstNameText = signUpFirstName_Field.getText().trim();
            String lastNameText = signUpLastName_Field.getText().trim();
            String locationText = signUpLocation_Field.getText().trim();
            String maleBox = signUpCheckBoxMale.getText().trim();
            String femaleBox = signUpCheckBoxFemale.getText().trim();
            String loginText = signUpLogin_Field.getText().trim();
            String loginPassword = signUpPassword_Field.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals("") && !firstNameText.equals("") && !lastNameText.equals("") && !locationText.equals("") && (!maleBox.equals("") || !femaleBox.equals(""))){
                if(loginText.equals("admin") && loginPassword.equals("12345")){
                signUpAuthSignInButton.getScene().getWindow().hide();
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
                stage.show();}
                else {
                    signUpAuthSignInButton.getScene().getWindow().hide();
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
                    stage.show();}
                }
            else
                System.out.println("Error");
        });


        String firstName = signUpFirstName_Field.getText();
        String lastName = signUpLastName_Field.getText();
        String userName = signUpLogin_Field.getText();
        String password = signUpPassword_Field.getText();
        String location = signUpLocation_Field.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected())
            gender = "Male";
        else
            gender = "Female";

        User user = new User(firstName, lastName, userName, password, location, gender);
        PackageData pd = new PackageData("ADDUser", user);
        Main.connect(pd);

    }
}
