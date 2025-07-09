package com.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.model.Customer;

import com.example.HelloApplication;

public class CustomerListController {

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private Label messageLabel; // Bind this in your FXML if needed

    private static final String DB_URL = "jdbc:sqlite:pos.db";

    @FXML
    private void initialize() {
        // Map table columns to Customer properties
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Load customers into table
        loadCustomers();
    }

    private void loadCustomers() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, email FROM customers");

            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }

        } catch (Exception e) {
            if (messageLabel != null) {
                messageLabel.setText("Error loading customers: " + e.getMessage());
            } else {
                System.err.println("Error loading customers: " + e.getMessage());
            }
        }

        customerTable.setItems(customers);
    }

    @FXML
    private void goToControlPanel(ActionEvent event) {
        try {
            HelloApplication.setRoot("control-panel");
            HelloApplication.setTitle("Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
            if (messageLabel != null) {
                messageLabel.setText("Failed to load dashboard: " + e.getMessage());
            }
        }
    }

}
