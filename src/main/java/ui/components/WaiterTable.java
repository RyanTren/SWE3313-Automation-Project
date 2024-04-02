/**
 * Requirements For Waiter GUI:
 * o 30 tables, in a generic layout, 4 seats at each table (6 x 5 layout)
 * o 5 distinct menu categories with at least 4 distinct food items: (Beverages, Appetizers, Entrées, Desserts, Sides)
 * o The orders queue/display may be shown on the console for this sprint
 * o At least 3 wait staff: (3 different waiter login)
 * o The wait staff information should be maintained in a file

 * o They are greeted with a floor status screen in which their assigned tables are colored in.
 * o Color-coding for Tables: Their tables are colored according to status; green is open, yellow is occupied, red is
 * dirty.
 * o At this point a waiter can select a table to view its tab.
 * o Once a table is selected, the staff can choose from a number of options.
 * o If they select to add an item to the table’s tab
 *  They are presented with various categories of food items offered. Here they can
 * select the appropriate category and then find the desired item.
 *  For example, if a patron ordered a Caesar salad, the waiter would log in,
 * select the table, and choose “Add Item.” They would then select the
 * “Soups/Salads” from the category list, and then select the desired salad
 * from the items presented. They are then returned to that table’s screen
 * where they can choose to perform another task or logout.
 *  This saves the waiter from walking back and forth to the kitchen to deliver and
 * check up on food orders.
 *  Orders placed by wait-staff using the computer terminals on the restaurant floor
 * are displayed to the kitchen staff through a queue, i.e., on a first-in, first-out
 * basis.
 * Because our customer is also in the process of establishing their entire network architecture, our
 * customer requests that this component/prototype be developed for running on a stand-alone
 * desktop/laptop computer without any web based or networked elements.
 * <p>
 * Brainstorming for WaiterGUI.java:
 * <p>
 * implement a 6 x 5 table which are clickable buttons to redirect to present the menu items
 * color-code the tables
 * label the table numbers with JLabel
 */

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
import java.util.ArrayList;

public class WaiterTable extends JFrame implements ActionListener {
    private JPanel waiterBackgroundPanel;
    private RoundedPanel waiterTopLayerBackgroundPanel;

    // Nested class for creating a rounded panel
    static class RoundedPanel extends JPanel {
        private int arcWidth;
        private Color backgroundColor;

        public RoundedPanel(int arcWidth, Color backgroundColor) {
            this.arcWidth = arcWidth;
            this.backgroundColor = backgroundColor;
            setOpaque(false); // Allow transparency
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(backgroundColor);
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcWidth);
            g2d.dispose();
        }
    }
    public WaiterTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Remove window decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the application full screen
        setTitle("J's Restaurant | Waiter Screen");

        // Background panel with BorderLayout
        waiterBackgroundPanel = new JPanel(new BorderLayout());
        waiterBackgroundPanel.setBackground(new Color(255, 255, 255));
        add(waiterBackgroundPanel);

        // Create a panel for the additional background
        waiterTopLayerBackgroundPanel = new RoundedPanel(20, new Color(217, 217, 217, 50)); // Adjust the arc width, arc height, color, and opacity as needed
        waiterTopLayerBackgroundPanel.setPreferredSize(new Dimension(500, 100)); // Adjust the preferred size as needed

        // Add the additional background panel to the content panel as a layered component
        waiterBackgroundPanel.add(waiterTopLayerBackgroundPanel, BorderLayout.CENTER);

        // Creating a panel for the top bar components
        JPanel topBarPanel = new JPanel();
        topBarPanel.setLayout(new BoxLayout(topBarPanel, BoxLayout.X_AXIS));
        topBarPanel.setBackground(new Color(255, 246, 242));
        topBarPanel.setPreferredSize(new Dimension(getWidth(), 350));
        waiterBackgroundPanel.add(topBarPanel, BorderLayout.NORTH);

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

        //Table Buttons
        createAndShowGUI();
    }

    private static JButton getjButton() {
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(181, 29, 29)); // Set background color to a shade of red
        logoutButton.setForeground(Color.WHITE); // Set text color to white
        logoutButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set font & size
        logoutButton.setFocusPainted(false); // Remove focus border
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return logoutButton;
    }

    //Table Button part 1
    private void createAndShowGUI() {
        JPanel tablePanel = new JPanel(new GridLayout(6, 5, 5, 5)); // 6 rows, 5 columns
        for (int i = 1; i <= 30; i++) {
            JButton tableButton = new JButton("Table " + i);

            tableButton.setPreferredSize(new Dimension(100, 100)); // Set preferred size for table buttons
            tableButton.setActionCommand(Integer.toString(i)); // Set action command to table number
            tableButton.addActionListener(this); // Add action listener to handle button click

            tableButton.setForeground(Color.WHITE); // Set font color to white
            tableButton.setBackground(new Color(89, 188, 99)); // Set background color to green (open)

            tablePanel.add(tableButton);
        }
        waiterBackgroundPanel.add(tablePanel, BorderLayout.CENTER);
    }


    //Table Button part 2
    private static ArrayList<JButton> createButtons(int count) {
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            JButton button = new JButton("Button " + i);
            buttons.add(button);
        }
        return buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand != null && actionCommand.matches("\\d+")) {
            int tableNumber = Integer.parseInt(actionCommand);
            new WaiterDrinkMenu(tableNumber).setVisible(true);
            dispose(); // Close this window
        } else {
            // Handle other actions, such as logout
            dispose(); // Close this window
            // Redirect to LoginGUI
            App.main(new String[0]); // Call App's main method without passing any arguments
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WaiterTable().setVisible(true));
    }
}









