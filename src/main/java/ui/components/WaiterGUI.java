package ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
 *  For example, if a patron ordered a Caesar salad, the waiter would login,
 * select the table, and choose “Add Item.” They would then select the
 * “Soups/Salads” from the category list, and then select the desired salad
 * from the items presented. They are then returned to that table’s screen
 * where they can choose to perform another task or logout.
 *  This saves the waiter from walking back and forth to the kitchen to deliver and
 * check up on food orders.
 *  Orders placed by wait-staff using the computer terminals on the restaurant floor
 * are displayed to the kitchen staff through a queue, i.e., on a first-in, first- out
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
public class WaiterGUI extends JFrame implements ActionListener{
    private JFrame waiterFrame;
    private JPanel waiterPanel;
    private JLabel welcomeMessageTitle;
    private JButton table1;
//    private JButton tableTwo;
//    private JButton tableThree;
//    private JButton tableFour;
//    private JButton tableFive;
//    private JButton tableSix;
//    private JButton tableSeven;
//    private JButton tableEight;
//    private JButton tableNine;
//    private JButton tableTen;



    //This method is going to be used to make the Welcome message.
    public WaiterGUI(Font welcomeFont){
        waiterFrame = new JFrame("Welcome, Waiter \uD83D\uDC81");
        waiterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcomeMessageTitle = new JLabel("Welcome, Waiter \uD83D\uDC81");

        waiterPanel = new JPanel(new GridBagLayout());
        waiterPanel.setBackground(new Color(255, 255, 255));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);

    }

    //Constructor for Tables
    public WaiterGUI(Button tableFont){
        table1 = new JButton("Table 1");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        table1.setBounds(0, 0, 75, 50);
        this.setVisible(true);
        this.add(table1);



//        JButton table2 = new JButton();


//        JButton table3 = new JButton();







    }

    private Container getPanel() {
        return waiterPanel;
    }

    //Override Method for ActionListener implementation for tableButtons
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        // main application window
        Font appFont = new Font("Franklin Gothic Medium", Font.ITALIC, 18);
        Button tableButton = new Button("Table 1");

        JFrame waiterFrame = new JFrame("J's Restaurant | Waiter Screen");


        //Full Screens the Application
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        waiterFrame.setPreferredSize(screenSize);

        waiterFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setPreferredSize();
        waiterFrame.setFont(appFont);
        // set overall font style
        waiterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Add application components
        tableButton = new Button("Table 1");
        waiterFrame.setContentPane(new WaiterGUI(tableButton).getPanel());

        appFont = new Font("Franklin Gothic Medium", Font.PLAIN, 18); // Customize the font here
        waiterFrame.setContentPane(new WaiterGUI(appFont).getPanel());


        waiterFrame.pack();
        waiterFrame.setLocationRelativeTo(null);
        waiterFrame.setVisible(true);
    }

}
