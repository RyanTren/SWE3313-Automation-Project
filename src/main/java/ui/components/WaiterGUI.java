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
 */


/**
 * Brainstorming for WaiterGUI.java:
 *
 * implement a 6 x 5 table which are clickable buttons to redirect to present the menu items
 * color-code the tables
 * label the table numbers with JLabel
 */

package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaiterGUI extends JFrame implements ActionListener {
    private JPanel waiterPanel;
    private JLabel welcomeMessageTitle;

    public WaiterGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("J's Restaurant | Waiter Screen");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);


        // Creating the welcome message
        welcomeMessageTitle = new JLabel("Welcome Back, Waiter");
        welcomeMessageTitle.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeMessageTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeMessageTitle, BorderLayout.NORTH);

        // Adding the logo
        waiterPanel = new JPanel(new GridBagLayout());
        waiterPanel.setBackground(Color.WHITE);
        add(waiterPanel, BorderLayout.CENTER);

        // Loading and adding the logo

        GridBagConstraints constraints = new GridBagConstraints();
        Insets defaultInsets = new Insets(5, 0, 0, 0); // Default padding
        constraints.gridx = 0;
        constraints.gridy = 0;
//        constraints.gridwidth = 2; // Span two columns
//        constraints.insets = new Insets(5, 5, 10, 5); // Adjust padding
        JLabel logoLabel = new JLabel(new ImageIcon("J's Restaurant Logo.png"));
        waiterPanel.add(logoLabel, constraints);

        // Pack and display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WaiterGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Action event handling if needed
    }
}


