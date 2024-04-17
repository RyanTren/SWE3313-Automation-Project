package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaiterStarterMenu extends JPanel implements ActionListener {
    private JPanel menuBackgroundPanel;


    public WaiterStarterMenu(int tableNumber) {

        System.out.println("Debugging Test: WaiterStarterMenu constructor called for table " + tableNumber);
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));

        // Create a panel for the additional background
        WaiterTable.RoundedPanel menuTopLayerBackgroundPanel = new WaiterTable.RoundedPanel(20, new Color(217, 217, 217, 50)); // Adjust the arc width, arc height, color, and opacity as needed
        menuTopLayerBackgroundPanel.setPreferredSize(new Dimension(500, 100)); // Adjust the preferred size as needed

        // Add the additional background panel to the content panel as a layered component
        add(menuTopLayerBackgroundPanel, BorderLayout.CENTER);

        // Creating a panel for the top bar components
        JPanel topBarPanel = new JPanel();
        topBarPanel.setLayout(new BoxLayout(topBarPanel, BoxLayout.X_AXIS));
        topBarPanel.setBackground(new Color(255, 246, 242));
        topBarPanel.setPreferredSize(new Dimension(getWidth(), 350));
        add(topBarPanel, BorderLayout.NORTH);

        // Creating tabs for menu categories
        String[] categories = {"Drink", "Starter", "Entree", "Dessert", "Sides"};
        for (String category : categories) {
            JButton tabButton = createTabButton(category);
            topBarPanel.add(tabButton);
        }

        // Add horizontal glue to create space between the tabs and buttons
        topBarPanel.add(Box.createHorizontalGlue());

        // Back Button
        JButton backButton = getJButton("Back");
        backButton.addActionListener(this); // Register action listener
        topBarPanel.add(backButton);

        // Logout Button
        JButton logoutButton = getJButton("Logout");
        logoutButton.addActionListener(this); // Register action listener
        topBarPanel.add(logoutButton);
    }

    private JButton getJButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(181, 29, 29)); // Set background color to a shade of red
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFont(new Font("Arial", Font.BOLD, 18)); // Set font & size
        button.setFocusPainted(false); // Remove focus border
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    private JButton createTabButton(String category) {
        JButton tabButton = new JButton(category);
        tabButton.setFocusPainted(false); // Remove focus border
        tabButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set font & size
        tabButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover
        tabButton.addActionListener(e -> {
            // Handle tab button click event here
            // Change menu content based on the selected category
            // You can add your logic here to update the menu content accordingly
            System.out.println("Selected category: " + category);
        });
        return tabButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand != null && actionCommand.matches("\\d+")) {
            int tableNumber = Integer.parseInt(actionCommand);
            // Get the parent frame
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            // Remove the current panel from the frame's content pane
            frame.getContentPane().removeAll();
            // Add the WaiterStarterMenu panel to the frame
            frame.getContentPane().add(new WaiterStarterMenu(tableNumber));
            // Repaint the frame to reflect the changes
            frame.revalidate();
            frame.repaint();
        } else {
            // Handle other actions, such as logout
            System.out.println("Logout button clicked");
        }
    }
}

