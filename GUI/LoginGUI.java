import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel backgroundPanel;

    private int animationCounter = 0;

    public LoginGUI() {
        setTitle("J's Restaurant User Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createBackgroundPanel();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        Insets defaultInsets = new Insets(5, 5, 5, 5); // Default padding

        Font font = new Font("Franklin Gothic Medium", Font.PLAIN, 15); // Customize the font here


        // Logo
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // Span two columns
        constraints.insets = new Insets(5, 5, 10, 5); // Adjust padding
        JLabel logoLabel = new JLabel(new ImageIcon("J's Restaurant Logo.png")); // Replace with the actual path
        panel.add(logoLabel, constraints);

// Username Label
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1; // Reset to default
        constraints.insets = new Insets(5, 5, 5, 5); // Reset padding
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(font.deriveFont(Font.BOLD, 16));
        usernameLabel.setFont(font);
        usernameLabel.setForeground(new Color(119,11,3)); // Set the desired font color
        panel.add(usernameLabel, constraints);

// Username Field
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 20); // Adjust right padding for the username field
        constraints.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        usernameField.setFont(font);
        panel.add(usernameField, constraints);

// Password Label
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = defaultInsets;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(font.deriveFont(Font.BOLD, 16));
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(119,11,3)); // Set the desired font color
        panel.add(passwordLabel, constraints);

// Password Field
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 20); // Adjust right padding for the password field
        constraints.fill = GridBagConstraints.HORIZONTAL;
        passwordField = new JPasswordField(20);
        passwordField.setFont(font);
        panel.add(passwordField, constraints);


        // Login Button
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5); // Adjust top and bottom padding for the login button
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        loginButton = new JButton("Login");
        loginButton.setFont(font);
        loginButton.setForeground(new Color(0, 128, 0));
        loginButton.setBackground(new Color(0, 128, 0)); // Set the desired green color
        panel.add(loginButton, constraints);

        getContentPane().add(backgroundPanel);
        backgroundPanel.add(panel);
        pack();
        setLocationRelativeTo(null);

        startBackgroundAnimation();
    }

    private void createBackgroundPanel() {
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawAnimatedBackground(g);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
    }

    private void drawAnimatedBackground(Graphics g) {
        int width = backgroundPanel.getWidth();
        int height = backgroundPanel.getHeight();

        GradientPaint gradientPaint = new GradientPaint(
                width / 2, 0, Color.LIGHT_GRAY,
                width / 2, height, Color.WHITE);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height);

        // You can customize the animation effect here
        int animationOffset = animationCounter % width;
        g2d.setColor(new Color(135, 206, 250, 50)); // Adjust alpha for transparency
        g2d.fillRect(animationOffset, 0, 10, height);

        animationCounter++;
    }

    private void startBackgroundAnimation() {
        Timer timer = new Timer(50, e -> backgroundPanel.repaint());
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            new LoginGUI().setVisible(true);
        });
    }
}
