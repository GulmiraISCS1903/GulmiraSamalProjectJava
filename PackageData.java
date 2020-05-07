package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;// ADD, LIST
    private User user;
    private ArrayList<User> users;
    private Products product;
    private ArrayList<Products> products;


    public PackageData(String operationType, Products product) {////Send to server info about one student
        this.operationType = operationType;
        this.product = product;
    }
    public PackageData(String operationType, User user) {////Send to server info about one student
        this.operationType = operationType;
        this.user = user;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(ArrayList<Products> products) {
        this.products = products;
    }
    public PackageData(String operationType, ArrayList<Products> products) {
        this.operationType=operationType;
        this.products = products;
    }
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
}
