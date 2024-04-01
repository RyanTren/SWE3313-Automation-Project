package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsrestaurant.DatabaseConnection;

public class LoginGUI implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel panel;

    public LoginGUI(Font loginFont) {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 246, 242));
        GridBagConstraints constraints = new GridBagConstraints();
        Insets defaultInsets = new Insets(5, 5, 5, 5); // Default padding
        // Logo
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // Span two columns
        constraints.insets = new Insets(5, 5, 10, 5); // Adjust padding
        JLabel logoLabel = new JLabel(new ImageIcon("assets/J's Restaurant Logo.png")); // Replace with the actual path
        panel.add(logoLabel, constraints);

        // Username Field
        initUsernameField(constraints, loginFont);

        // Password Field
        initPasswordField(constraints, loginFont, defaultInsets);

        // Login Button
        initLoginButton(constraints, loginFont);
    }

    /**
     * Get the root panel everything is drawn on
     */
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginButton)) {
            // 1: Check the input fields - do they have stuff?
            if (usernameField.getText().trim().isEmpty() || passwordField.getPassword().length == 0) {
                return;
            }

            // 2: connect to db to check user credentials
            Connection db = DatabaseConnection.getConnection();
            try (Statement statement = db.createStatement()) {
                String userName = usernameField.getText().trim();
                String sql = "select password from User where name = '" + userName + "'";
//                System.out.println(sql);
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) { // FIXME: using a while here is kinda dumb - should figure out a way to retrieve first item matching query
                    String userPassword = rs.getString("password");
                    System.out.println(userPassword);
                }
                db.close(); // close connection
            } catch (SQLException exp) {
                System.err.println(exp);
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
        panel.add(usernameLabel, constraints);

        // Username Field
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 20); // Adjust right padding for the username field
        constraints.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        usernameField.setFont(font);
        usernameField.setBorder(BorderFactory.createEmptyBorder());
        usernameField.setOpaque(true);
        panel.add(usernameField, constraints);
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
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 20); // Adjust right padding for the password field
        constraints.fill = GridBagConstraints.HORIZONTAL;
        passwordField = new JPasswordField(20);
        passwordField.setFont(font);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setOpaque(true);
        panel.add(passwordField, constraints);
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
        panel.add(loginButton, constraints);
        // event listener for when someone presses the button
        loginButton.addActionListener(this);
    }
}
