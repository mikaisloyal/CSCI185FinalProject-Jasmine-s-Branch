/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

import javax.swing.*;
import UserFiles.*;

public class NetworkPage extends JFrame{
    public NetworkPage(){
        this.setSize(1600,960);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Network");

        //Creating custom panel from UniversityDropDownPanel class
        UniversityDropdownPanel uniLocationPanel = new UniversityDropdownPanel();
        this.add(uniLocationPanel);

        this.setVisible(true);
    }
}