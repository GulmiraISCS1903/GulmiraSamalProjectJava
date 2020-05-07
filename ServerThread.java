package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;

            while ((packageData = (PackageData) inputStream.readObject()) != null) {
                if (packageData.getOperationType().equals("ADDUser")) {/// "ADD", Student
                    User userFromClient = packageData.getUser();
                    manager.addUser(userFromClient);
                    break;
                } else if (packageData.getOperationType().equals("ADDProduct")) {/// "ADD", Student
                    Products productFromClient = packageData.getProduct();
                    manager.AddProducts(productFromClient);
                    break;
                } else if (packageData.getOperationType().equals("getAllProducts")) {
                    ArrayList<Products> infoForClient = manager.getAllProducts();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                    break;
                } else if (packageData.getOperationType().equals("LogIn")) {
                    User user = packageData.getUser();
                    manager.Authorization(user.getUserName(), user.getPassword());
                    break;
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
