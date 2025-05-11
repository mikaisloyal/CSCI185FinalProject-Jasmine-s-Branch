/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package GUIwindows;

import java.awt.*;
import javax.swing.*;

public class IntroductionWindow extends JFrame {
    public IntroductionWindow() {
        this.setTitle("Global Student Network Simulator");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Background image
        ImageIcon bgIcon = new ImageIcon("../assets/Intro_window_backgroung_image.jpg"); //Adjust image's file path if it doesn't show the image. You can always give an absolute path.
        Image img = bgIcon.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        JLabel bgLabel = new JLabel(new ImageIcon(img));
        bgLabel.setLayout(new BorderLayout());

        //Title
        JLabel title = new JLabel("Global Student Network Simulator", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        title.setForeground(Color.YELLOW);
        title.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));
        bgLabel.add(title, BorderLayout.NORTH);

        //Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
        buttonPanel.setOpaque(false);

        JButton instructions = new JButton("Instructions");
        JButton run = new JButton("Run");

        Dimension btnSize = new Dimension(200, 50);
        instructions.setPreferredSize(btnSize);
        run.setPreferredSize(btnSize);

        instructions.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        run.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        //Buttons' functionality
        instructions.addActionListener(e -> {
            this.dispose(); //close intro window
            new InstructionsWindow(); //open instructions
        });

        run.addActionListener(e -> {
            this.dispose();
            new NetworkPage(); // go to network Window
        });

        buttonPanel.add(instructions);
        buttonPanel.add(run);
        bgLabel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(bgLabel);
        this.setVisible(true);
    }
}
