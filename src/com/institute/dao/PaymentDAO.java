package com.institute.dao;

import com.institute.models.Payment;
import java.util.List;

public interface PaymentDAO {
    void addPayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(int paymentId);
    Payment getPayment(int paymentId);
    List<Payment> getPaymentsForStudent(int studentId);
}
