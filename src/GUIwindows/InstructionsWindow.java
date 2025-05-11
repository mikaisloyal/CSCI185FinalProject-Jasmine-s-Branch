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
        String htmlText = """
<html>
    <body style='font-family: Comic Sans MS; font-size: 16px; text-align: center;'>
        <h2>Hi!</h2>
        <p>This application helps you discover what you have in common with other students<br>
        who have submitted their information.</p>

        <h2>Connections Strength Table</h2>
        <table border='1' align='center' cellpadding='8' cellspacing='0'>
            <tr><th>Feature</th><th>Points if Same</th></tr>
            <tr><td>First Name</td><td>5</td></tr>
            <tr><td>Last Name</td><td>5</td></tr>
            <tr><td>Age</td><td>10</td></tr>
            <tr><td>Nationality</td><td>10</td></tr>
            <tr><td>University Name</td><td>15</td></tr>
            <tr><td>University Location</td><td>15</td></tr>
            <tr><td>Major</td><td>10</td></tr>
            <tr><td>Interests</td><td>1 × 10 = 10 (max 10)</td></tr>
            <tr><td>Classes</td><td>4 × 5 = 20 (max 5)</td></tr>
        </table>

        <p style='margin-top:20px;'>After you fill out the form and press <b>"Create Student"</b>,<br>
        a pin with your name will appear on the map at your university location.</p>

        <p>If at least two students are created, select their pins and click <b>"Show Connections"</b>.<br>
        A new window will display your similarities (classes, interests, etc).</p>

        <p>To delete all students and reset, press the <b>"Reset"</b> button below the map.</p>
    </body>
</html>
""";

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
