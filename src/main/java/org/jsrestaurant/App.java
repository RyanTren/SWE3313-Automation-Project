package org.jsrestaurant;

import ui.components.LoginGUI;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        // main application window
        Font appFont = new Font("Franklin Gothic Medium", Font.ITALIC, 18);
        JFrame frame = new JFrame("J's Restaurant");
        frame.setPreferredSize(new Dimension(750, 600));
        frame.setFont(appFont);
        // set overall font style
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Add application components
        Font loginFont = new Font("Franklin Gothic Medium", Font.PLAIN, 18); // Customize the font here
        frame.setContentPane(new LoginGUI(loginFont).getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
