package org.jsrestaurant;

import ui.components.LoginGUI;

import javax.swing.*;
import java.awt.*;

public class App {
   public static void main(String[] args) {
        // main application window
        Font appFont = new Font("Franklin Gothic Medium", Font.ITALIC, 18);
        JFrame loginFrame = new JFrame("J's Restaurant");

        //Full Screens the Application
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        loginFrame.setPreferredSize(screenSize);

        loginFrame.setFont(appFont);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //this line doesn't work for some reason but for the other java files it does...
//      loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Add application components
        Font loginFont = new Font("Franklin Gothic Medium", Font.PLAIN, 18); // Customize the font here
        loginFrame.setContentPane(new LoginGUI(loginFont).getPanel());

        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        Font waiterFont = new Font("Franklin Gothic Medium", Font.PLAIN, 18); // Customize the font here
        loginFrame.setContentPane(new LoginGUI(waiterFont).getPanel());

        loginFrame.pack();
   }
}
