package com.institute.services;

import com.institute.dao.PaymentDAO;
import com.institute.dao.PaymentDAOImpl;
import com.institute.models.Payment;
import java.util.List;

public class PaymentService {
    private PaymentDAO paymentDAO;

    public PaymentService() {
        this.paymentDAO = new PaymentDAOImpl();
    }

    public void addPayment(Payment payment) {
        // Add business logic here, e.g., validation
        paymentDAO.addPayment(payment);
    }

    public void updatePayment(Payment payment) {
        // Add business logic here
        paymentDAO.updatePayment(payment);
    }

    public void deletePayment(int paymentId) {
        // Add business logic here
        paymentDAO.deletePayment(paymentId);
    }

    public Payment getPayment(int paymentId) {
        return paymentDAO.getPayment(paymentId);
    }

    public List<Payment> getPaymentsForStudent(int studentId) {
        return paymentDAO.getPaymentsForStudent(studentId);
    }
}
