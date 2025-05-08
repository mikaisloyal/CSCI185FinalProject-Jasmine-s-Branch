
/*
ProjectName
CSCI 185
M03
Aron Lin, Rita Chen, Htoo Naing, Zhasmin Tuiachieva
Date of last contribution (Use the date on Github commit)
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Main {
    public static void main(String[] args) {

        // Main Frame initializing
        JFrame mainFrame = new JFrame("Name eventually (Trademarked)");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,800);

        // Panel Config
        int panelRow = 5;
        int panelCol = 5;

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.cyan);
        mainPanel.setLayout(new GridLayout(panelRow, panelCol, 10 , 10));



    

        //Components
        JLabel title = new JLabel("Name Eventually");
        title.setHorizontalAlignment(0);

        JButton insButton = new JButton("Instructions");
        insButton.setHorizontalAlignment(0);

        JButton runButton = new JButton("Run");
        runButton.setHorizontalAlignment(0);

        // Functionality

        insButton.addActionListener((ActionEvent e) -> {
            Instruction insPage = new Instruction();
        });

        runButton.addActionListener((ActionEvent e) -> {
            mainFrame.dispose();
            NetworkPage netPage = new NetworkPage();
        });

        //Adding components to panel
        mainPanel.add(title);
        mainPanel.add(insButton);
        mainPanel.add(runButton);


        // mainPanel.add(uniLocationPanel);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}




