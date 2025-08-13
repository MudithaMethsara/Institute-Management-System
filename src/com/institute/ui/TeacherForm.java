package com.institute.ui;

import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class TeacherForm extends JFrame {

    public TeacherForm() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teacher Management");
        getContentPane().setLayout(new AbsoluteLayout());

        // Add components here

        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
}
