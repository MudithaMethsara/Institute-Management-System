package com.institute.models;

import java.util.Date;

public class Payment {
    private int id;
    private int studentId;
    private double amount;
    private Date paymentDate;
    private String description;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
