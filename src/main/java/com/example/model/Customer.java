package com.example.model;

public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters (and optionally setters if needed)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
