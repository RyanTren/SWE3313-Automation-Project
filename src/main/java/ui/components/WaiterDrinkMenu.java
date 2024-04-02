package ui.components;

import org.jsrestaurant.App;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WaiterDrinkMenu extends JFrame implements ActionListener {
    private JPanel menuBackgroundPanel;
    private WaiterTable.RoundedPanel menuTopLayerBackgroundPanel;
    public WaiterDrinkMenu(int tableNumber) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Remove window decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the application full screen
        setTitle("J's Restaurant | Table " + tableNumber + " Drink Menu");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);

        // Background panel with BorderLayout
        menuBackgroundPanel = new JPanel(new BorderLayout());
        menuBackgroundPanel.setBackground(new Color(255, 255, 255));
        add(menuBackgroundPanel);

        // Create a panel for the additional background
        menuTopLayerBackgroundPanel = new WaiterTable.RoundedPanel(20, new Color(217, 217, 217, 50)); // Adjust the arc width, arc height, color, and opacity as needed
        menuTopLayerBackgroundPanel.setPreferredSize(new Dimension(500, 100)); // Adjust the preferred size as needed

        // Add the additional background panel to the content panel as a layered component
        menuBackgroundPanel.add(menuTopLayerBackgroundPanel, BorderLayout.CENTER);

        // Creating a panel for the top bar components
        JPanel topBarPanel = new JPanel();
        topBarPanel.setLayout(new BoxLayout(topBarPanel, BoxLayout.X_AXIS));
        topBarPanel.setBackground(new Color(255, 246, 242));
        topBarPanel.setPreferredSize(new Dimension(getWidth(), 350));
        menuBackgroundPanel.add(topBarPanel, BorderLayout.NORTH);

        // Loading and adding the logo to the top bar
        try {
            // Loading the original image
            String imagePath = "C:/Users/Ryan/OneDrive/Desktop/github repo storage/SWE3313-Automation-Project/assets/J's Restaurant Logo.png";
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            // Define the desired width and height for the resized image
            int desiredWidth = 350; // Adjust as needed
            int desiredHeight = 350; // Adjust as needed

            // Create a new BufferedImage with the desired width and height
            BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);

            // Scale the original image to fit the new dimensions
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, desiredWidth, desiredHeight, null);
            g2d.dispose();

            // Convert the resized BufferedImage to an ImageIcon
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            // Create a JLabel with the resized ImageIcon
            JLabel logoLabel = new JLabel(resizedIcon);

            // Add logo to the top bar
            topBarPanel.add(logoLabel);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load image: " + e.getMessage());
        }

        // Creating the welcome message
        JLabel welcomeMessageTitle = new JLabel("Welcome Back, Waiter");
        welcomeMessageTitle.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeMessageTitle.setHorizontalAlignment(SwingConstants.CENTER); // Center the welcome message
        topBarPanel.add(welcomeMessageTitle);

        // Add horizontal glue to create space between the welcome message and the logout button
        topBarPanel.add(Box.createHorizontalGlue());

        //Logout Button
        JButton logoutButton = getjButton();
        logoutButton.addActionListener(this); // Register action listener
        topBarPanel.add(logoutButton);
    }
    private static JButton getjButton() {
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(181, 29, 29)); // Set background color to a shade of red
        backButton.setForeground(Color.WHITE); // Set text color to white
        backButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set font & size
        backButton.setFocusPainted(false); // Remove focus border
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return backButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Redirect to LoginGUI
        WaiterTable.main(new String[0]); // Call App's main method without passing any arguments
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WaiterTable().setVisible(true));
    }
}
