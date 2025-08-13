package com.institute.ui;

import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class PaymentForm extends JFrame {

    public PaymentForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payment Tracking");
        getContentPane().setLayout(new AbsoluteLayout());

        // Add components here

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
