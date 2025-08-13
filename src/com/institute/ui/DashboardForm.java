package com.institute.ui;

import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class DashboardForm extends JFrame {

    private JLabel welcomeLabel;

    public DashboardForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        getContentPane().setLayout(new AbsoluteLayout());

        welcomeLabel = new JLabel("Welcome to the Institute Management System!");
        getContentPane().add(welcomeLabel, new AbsoluteConstraints(50, 50, -1, -1));

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
