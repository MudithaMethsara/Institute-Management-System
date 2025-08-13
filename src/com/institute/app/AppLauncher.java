package com.institute.app;

import com.formdev.flatlaf.FlatDarkLaf;
import com.institute.ui.LoginForm;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class AppLauncher {
    public static void launch() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
    }
}
