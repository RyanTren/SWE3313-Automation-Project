package org.jsrestaurant;

import ui.components.LoginGUI;

import javax.swing.*;
import java.awt.*;

public class App {
   public static void main(String[] args) {
        // main application window
        Font appFont = new Font("Franklin Gothic Medium", Font.ITALIC, 18);
        JFrame appWindow = new JFrame("J's Restaurant");

        //Full Screens the Application
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        appWindow.setPreferredSize(screenSize);

        appWindow.setFont(appFont);
        appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //this line doesn't work for some reason but for the other java files it does...
//      loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Add application components
        appWindow.setContentPane(new LoginGUI(appFont).getPanel());

        appWindow.pack();
        appWindow.setLocationRelativeTo(null);
        appWindow.setVisible(true);
   }
}
