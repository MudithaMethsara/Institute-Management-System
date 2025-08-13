package com.institute.dao;

import com.institute.config.DBConnection;
import com.institute.models.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    private Connection connection;

    public PaymentDAOImpl() {
        this.connection = DBConnection.getConnection();
    }

    @Override
    public void addPayment(Payment payment) {
        try {
            String query = "INSERT INTO payments (student_id, amount, payment_date, description) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, payment.getStudentId());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            ps.setString(4, payment.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        try {
            String query = "UPDATE payments SET student_id=?, amount=?, payment_date=?, description=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, payment.getStudentId());
            ps.setDouble(2, payment.getAmount());
            ps.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            ps.setString(4, payment.getDescription());
            ps.setInt(5, payment.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayment(int paymentId) {
        try {
            String query = "DELETE FROM payments WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, paymentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPayment(int paymentId) {
        Payment payment = null;
        try {
            String query = "SELECT * FROM payments WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, paymentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setStudentId(rs.getInt("student_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public List<Payment> getPaymentsForStudent(int studentId) {
        List<Payment> payments = new ArrayList<>();
        try {
            String query = "SELECT * FROM payments WHERE student_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setStudentId(rs.getInt("student_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
