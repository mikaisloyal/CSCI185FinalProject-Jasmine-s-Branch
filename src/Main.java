/*
ProjectName
CSCI 185
M03
Aron Lin, Rita Chen, Htoo Naing, Zhasmin Tuiachieva
Date of last contribution (Use the date on Github commit)
*/
package src;
import java.awt.*;
import javax.swing.*;

class Main {
    public static void main(String[] args) {

        // Main Frame initializing
        JFrame mainFrame = new JFrame("Name eventually (Trademarked)");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,800);

        // Panel Config
        JPanel mainPanel = new JPanel();
        LayoutManager layout1 = new GridLayout(5,5,10,10);
        mainPanel.setLayout(layout1);

        //Creating custom panel from UniversityDropDownPanel class
        UniversityDropdownPanel uniLocationPanel = new UniversityDropdownPanel();

        //Components
        JLabel title = new JLabel("Name Eventually");
        title.setHorizontalAlignment(0);

        //Adding components to panel
        mainPanel.add(title);
        
        mainFrame.add(mainPanel);
        mainFrame.add(uniLocationPanel);
        mainFrame.setVisible(true);
    }
}




