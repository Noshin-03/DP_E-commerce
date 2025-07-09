package com.example.controller;

import com.example.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {

    private void openScene(String fxmlFile, ActionEvent event, String title) {
        try {
            HelloApplication.setRoot(fxmlFile);
            HelloApplication.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewProfile(ActionEvent event) {
        loadScene(event, "profile-view", "Profile");
    }

    @FXML
    private void handleViewProducts(ActionEvent event) {
        loadScene(event, "product-list", "Product List");
    }

    @FXML
    private void handleOrders(ActionEvent event) {
        loadScene(event, "order-list", "Orders");
    }

    @FXML
    private void handleSettings(ActionEvent event) {
        loadScene(event, "settings-view", "Settings");
    }

    @FXML
    private void handleControlPanel(ActionEvent event) {
        loadScene(event, "control-panel", "Control Panel");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
//        loadScene(event, "login-view", "Login Page");
        openScene("login-view", event, "Login Page");
    }

    // Utility method to load FXML scenes consistently
    private void loadScene(ActionEvent event, String fxmlName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                    getClass().getResource("/com/example/view/" + fxmlName + ".fxml")
            ));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
