package com.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

import java.sql.*;

import com.example.model.Order;

import com.example.HelloApplication;

public class OrderListController {

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, Integer> orderIdColumn;

    @FXML
    private TableColumn<Order, String> customerNameColumn;

    @FXML
    private TableColumn<Order, String> dateColumn;

    @FXML
    private TableColumn<Order, String> statusColumn;

    @FXML
    private Label messageLabel; // Bind this in your FXML if needed

    @FXML
    public void initialize() {
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadOrdersFromDatabase();
    }

    private void loadOrdersFromDatabase() {
        ObservableList<Order> orders = FXCollections.observableArrayList();

        String sql = "SELECT orders.id, customers.name, orders.date, orders.status FROM orders JOIN customers ON orders.customer_id = customers.id ORDER BY orders.id";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:pos.db");
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String customerName = rs.getString("name");
                String date = rs.getString("date");
                String status = rs.getString("status");

                orders.add(new Order(id, customerName, date, status));
            }

            orderTable.setItems(orders);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
