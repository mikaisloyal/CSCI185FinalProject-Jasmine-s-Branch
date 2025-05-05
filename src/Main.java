/*
ProjectName
CSCI 185
M03
Aron Lin, Rita Chen, Htoo Naing, Zhasmin Tuiachieva
Date of last contribution (Use the date on Github commit)
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

class Main {
    public static void main(String[] args) {

        // Main Frame initializing
        JFrame mainFrame = new JFrame("Name eventually (Trademarked)");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,800);

        // Panel Config
        JPanel mainPanel = new JPanel();
        LayoutManager layout1 = new GridLayout(5,5,10,10);
        mainFrame.setLayout(layout1);
        
        JLabel title = new JLabel("Name Eventually");
        title.setHorizontalAlignment(0);

        mainFrame.add(title);
        

        mainFrame.setVisible(true);
    }
}




