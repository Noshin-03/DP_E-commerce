package com.example.model;

public class Order {
    private int id;
    private String customerName;
    private String date;
    private String status;

    public Order(int id, String customerName, String date, String status) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.status = status;
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}
