package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Online Fruits & Vagetables");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }
    static ObservableList<Products> productsObservableList;
    public static void connect(PackageData pd) {
        try {
            Socket socket = new Socket("127.0.0.1", 1006);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if (pd.getOperationType().equals("ADDUser")) {
                outputStream.writeObject(pd);/// ADD, Student
            } else if (pd.getOperationType().equals("ADDProduct")) {
                outputStream.writeObject(pd);/// ADD, Product
            } else if (pd.getOperationType().equals("getAllProducts")) {
                DBManager manager = new DBManager();
                ArrayList<Products> arrayListFromServer = manager.getAllProducts();
                productsObservableList = FXCollections.observableArrayList(arrayListFromServer);
            } else if (pd.getOperationType().equalsIgnoreCase("LogIn")) {
                outputStream.writeObject(pd);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
