package com.institute.ui;

import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class StudentForm extends JFrame {

    public StudentForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management");
        getContentPane().setLayout(new AbsoluteLayout());

        // Add components here

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
