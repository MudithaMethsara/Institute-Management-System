package com.institute.ui;

import com.institute.app.AppLauncher;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class LoginForm extends JFrame {

    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new AbsoluteLayout());

        userLabel = new JLabel("Username:");
        getContentPane().add(userLabel, new AbsoluteConstraints(30, 40, -1, -1));

        userTextField = new JTextField(20);
        getContentPane().add(userTextField, new AbsoluteConstraints(120, 40, 150, -1));

        passwordLabel = new JLabel("Password:");
        getContentPane().add(passwordLabel, new AbsoluteConstraints(30, 80, -1, -1));

        passwordField = new JPasswordField(20);
        getContentPane().add(passwordField, new AbsoluteConstraints(120, 80, 150, -1));

        loginButton = new JButton("Login");
        getContentPane().add(loginButton, new AbsoluteConstraints(120, 120, -1, -1));

        loginButton.addActionListener(e -> {
            // Dummy authentication
            String username = userTextField.getText();
            String password = new String(passwordField.getPassword());
            if ("admin".equals(username) && "admin".equals(password)) {
                this.dispose();
                DashboardForm dashboard = new DashboardForm();
                dashboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        pack();
        setSize(350, 220);
        setLocationRelativeTo(null);
    }
}
