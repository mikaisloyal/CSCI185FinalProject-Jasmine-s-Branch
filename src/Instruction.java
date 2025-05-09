/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

import java.awt.*;
import javax.swing.*;

public class Instruction extends JFrame{
    public Instruction(){
        this.setSize(800,800);
        this.setTitle("Instructions");

        JTextArea text = new JTextArea(10,3);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        this.getContentPane().add(scrollPane);

        
        text.insert("Welcome to the Global Student Network Simulator. Here you can find international students just like you to make friends with!" 
        + "\n\nTo get Started, please return to the main window and press the [RUN] button." 
        + "\n\nOnce at the network page, Please fill out your information on the STUDENT PROFILE FORM." 
        + "\n\nWhen Completed, Press the [CREATE STUDENT] button. There, you should see yourself alongside your potential peers." 
        + "\n\nIf you want to see your connection strength between your peers, press you and the other persons icon. A [SHOW CONNECTION] button should appear and will show your connection strength." , 0);

        this.setVisible(true);
    }

}