package com.example.controller;

import com.example.HelloApplication;
import com.example.util.DatabaseHelper;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class AuthController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButton(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        boolean isValid = DatabaseHelper.verifyUser(email, password);
        System.out.println("Valid user? " + isValid); // debug

        if (isValid) {
            try {
                HelloApplication.setRoot("home-view");
                HelloApplication.setTitle("Home Page");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    @FXML
    private void handleGoToHomePageButton(ActionEvent event) {
        try {
            HelloApplication.setRoot("home-view");
            HelloApplication.setTitle("Home Page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
