/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package GUIwindows;

import java.awt.*;
import javax.swing.*;

public class InstructionsWindow extends JFrame {
    public InstructionsWindow() {
        this.setTitle("Instructions");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        //-----------Instruction Message-------------
        String htmlText = "Welcome to the Global Student Network Simulator. Here you can find international students just like you to make friends with!" 
        + "\n\nTo get Started, please return to the main window and press the [RUN] button." 
        + "\n\nOnce at the network page, Please fill out your information on the STUDENT PROFILE FORM." 
        + "\n\nWhen Completed, Press the [CREATE STUDENT] button. There, you should see yourself alongside your potential peers." 
        + "\n\nIf you want to see your connection strength between your peers, press you and the other persons icon. A [SHOW CONNECTION] button should appear and will show your connection strength.";

        JEditorPane instructionsPane = new JEditorPane("text/html", htmlText);
        instructionsPane.setEditable(false);
        instructionsPane.setOpaque(false);


        JScrollPane scrollPane = new JScrollPane(instructionsPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);



        //-----------Bottom Buttons-------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));

        JButton previousButton = new JButton("Previous");
        JButton runButton = new JButton("Run");

        previousButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        runButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        //Buttons functionality
        previousButton.addActionListener(e -> {
            this.dispose(); //close instructions window
            new IntroductionWindow(); //go back to intro window

        });

        runButton.addActionListener(e -> {
            this.dispose();
            new NetworkWindow();
        });

        buttonPanel.add(previousButton);
        buttonPanel.add(runButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
