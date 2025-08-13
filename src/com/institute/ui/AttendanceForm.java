package com.institute.ui;

import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class AttendanceForm extends JFrame {

    public AttendanceForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance Tracking");
        getContentPane().setLayout(new AbsoluteLayout());

        // Add components here

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
