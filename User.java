package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.Serializable;

public class User implements Serializable {
    private Integer idusers;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String location;
    private String gender;

    public User(Integer idusers, String firstName, String lastName, String userName, String password, String location, String gender) {
        this.idusers = idusers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User(String firstName, String lastName, String userName, String password, String location, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
