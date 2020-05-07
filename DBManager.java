package sample;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class DBManager extends SignInController {

    private Connection conn = null;

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");///
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void AddProducts(Products product) {
        String in = "INSERT INTO " + "`" + "onlineshop" + "`.`products` (`name`, `quality`, `date`, `price`, `weight`) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement prst = connect().prepareStatement(in);
            prst.setString(1, product.getName());
            prst.setString(2, product.getQuality());
            prst.setString(3, product.getDate());
            prst.setDouble(4, product.getPrice());
            prst.setDouble(5, product.getWeight());

            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        String insert = "INSERT INTO " + "`" + "onlineshop" + "`.`" + Const.USER_TABLE + "` (`" + Const.USER_FIRSTNAME + "`, `" +
                Const.USER_LASTNAME + "`, `" + Const.USER_USERNAME + "`, `" + Const.USER_PASSWORD + "`, `" +
                Const.USER_LOCATION + "`, `" + Const.USER_GENDER + "`) VALUES (?,?,?,?,?,?);";
        try {

            PreparedStatement prSt = connect().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());
            prSt.execute();
            prSt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean Authorization(String login, String password) throws SQLException {  ////SUCCESS or FAIL
        Boolean isLogin = false;
        ResultSet resSet = null;
        PreparedStatement prSt = null;
        String select = "SELECT * FROM `" + "onlineshop" + "`.`" + Const.USER_TABLE + "` WHERE (`" + Const.USER_USERNAME + "` = ?) AND (`" + Const.USER_PASSWORD + "` = ?);";
        try {
            prSt = connect().prepareStatement(select);
            prSt.setString(1, login);
            prSt.setString(2, password);

            resSet = prSt.executeQuery();
            if (resSet.next()) {
                isLogin = true;
            } else isLogin = false;
        } catch (SQLException e) {
            isLogin = false;
        } finally {
            prSt.close();
            resSet.close();
        }
        return isLogin;
    }


    public ArrayList<Products> getAllProducts() {
        ArrayList<Products> productsArrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connect().prepareStatement("SELECT * FROM onlineshop.products");
            ResultSet resultSet = statement.executeQuery();/// Select

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String quality = resultSet.getString("quality");
                String date = resultSet.getString("date");
                Integer price = resultSet.getInt("price");
                Integer weight = resultSet.getInt("weight");

                productsArrayList.add(new Products(name, quality, date, price, weight));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsArrayList;
    }


}
