package ui.components;

import models.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginGUI implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel cards;

    public enum GUI_NAMES {
        LOGIN,
        WAITER_DRINK_MENU,
        WAITER_TABLE,
        WAITER_STARTER_MENU
    }

    public LoginGUI(Font loginFont) {
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(255, 246, 242));
        GridBagConstraints constraints = new GridBagConstraints();
        Insets defaultInsets = new Insets(5, 5, 5, 5); // Default padding
        // Logo
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // Span two columns
        constraints.insets = new Insets(5, 5, 10, 5); // Adjust padding
        JLabel logoLabel = new JLabel(new ImageIcon("assets/J's Restaurant Logo.png")); // Replace with the actual path
        loginPanel.add(logoLabel, constraints);

        // Username Field
        initUsernameField(constraints, loginFont);

        // Password Field
        initPasswordField(constraints, loginFont, defaultInsets);

        // Login Button
        initLoginButton(constraints, loginFont);

        cards = new JPanel(new CardLayout());
        // 1st view added becomes the default view
        cards.add(GUI_NAMES.LOGIN.name(), loginPanel);

        // WAITER
        cards.add(GUI_NAMES.WAITER_TABLE.name(), new WaiterTable());
//        JPanel waiterGUI = new JPanel();
////        waiterGUI.add(new JLabel("WAITER"));
//        cards.add(GUI_NAMES.WAITER_TABLE.name(), waiterGUI);
    }

    /**
     * Get the root panel everything is drawn on
     */
    public JPanel getPanel() {
        return cards;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginButton)) {
            CardLayout cl = (CardLayout) cards.getLayout();
            // 1: Check the input fields - do they have stuff?
            if (usernameField.getText().trim().isEmpty() || passwordField.getPassword().length == 0) {
                return;
            }

            String userName = usernameField.getText().trim();
            char[] password = passwordField.getPassword();

            // 2: connect to db to check user credentials
            Employee user = Employee.getByUsername(userName);
            if (user != null) {
                if (Arrays.equals(user.getPassword().toCharArray(), password)) {
                    // credentials match, proceed
                    switch (user.getRole()) {
                        case "manager":
                            System.out.println("Switching to manager view");
                            break;
                        case "host":
                            System.out.println("Switching to host view");
                            break;
                        case "waiter":
                            cl.show(cards, GUI_NAMES.WAITER_TABLE.name());
                            break;
                        case "cook":
                            System.out.println("Switching to cook view");
                            break;
                        case "busboy":
                            System.out.println("Switching to busboy view");
                    }
                } else {
                    // TODO: show invalid credentials dialog
                    System.err.println("Invalid credentials. Please check username/password");
                }
            } else {
                // TODO: show invalid credentials dialog
                System.err.println("Invalid credentials. Please check username/password");
            }
        }
    }

    private void initUsernameField(GridBagConstraints constraints, Font font) {
        // Username Label
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1; // Reset to default
        constraints.insets = new Insets(5, 5, 5, 5); // Reset padding
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(font.deriveFont(Font.BOLD, 16));
        usernameLabel.setFont(font);
        usernameLabel.setForeground(new Color(119, 11, 3)); // Set the desired font color
        loginPanel.add(usernameLabel, constraints);

        // Username Field
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 20); // Adjust right padding for the username field
        constraints.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        usernameField.setFont(font);
        usernameField.setBorder(BorderFactory.createEmptyBorder());
        usernameField.setOpaque(true);
        loginPanel.add(usernameField, constraints);
    }

    private void initPasswordField(GridBagConstraints constraints, Font font, Insets insets) {
        // Password Label
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = insets;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(font.deriveFont(Font.BOLD, 16));
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(119, 11, 3)); // Set the desired font color
        loginPanel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 20); // Adjust right padding for the password field
        constraints.fill = GridBagConstraints.HORIZONTAL;
        passwordField = new JPasswordField(20);
        passwordField.setFont(font);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setOpaque(true);
        loginPanel.add(passwordField, constraints);
    }

    private void initLoginButton(GridBagConstraints constraints, Font font) {
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5); // Adjust top and bottom padding for the login button
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        loginButton = new JButton("Login");
        loginButton.setFont(font);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
//        loginButton.setForeground(new Color(0, 128, 0));
        loginButton.setBackground(new Color(0, 128, 0)); // Set the desired green color
        loginPanel.add(loginButton, constraints);
        // event listener for when someone presses the button
        loginButton.addActionListener(this);
    }
}
