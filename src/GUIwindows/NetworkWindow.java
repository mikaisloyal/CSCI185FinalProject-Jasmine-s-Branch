/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package GUIwindows;

import GUIpanels.MapPanel;
import GUIpanels.StudentFormPanel;
import UserFiles.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class NetworkWindow extends JFrame {
    public NetworkWindow() {
        this.setSize(1600, 960);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Current Network");

        StudentFormPanel formPanel = new StudentFormPanel();
        this.add(formPanel, BorderLayout.WEST);

        // Map panel on the right
        MapPanel mapPanel = new MapPanel();
        this.add(mapPanel, BorderLayout.CENTER);

        JButton button = new JButton("Calculate Connection Strength");
        this.add(button, BorderLayout.SOUTH);

        button.addActionListener((ActionEvent e) -> {

            CompareConnections connection = new CompareConnections(mapPanel.getStudentA(), mapPanel.getStudentB());
            ConnectionGUI gui = new ConnectionGUI();
            gui.setConnectionStrength(mapPanel.getStudentA(), mapPanel.getStudentB(), connection.getStrength());
            gui.display();
            System.out.println(connection.toString());
        });

//
//        //using BorderLayout to place components side by side
//        this.setLayout(new BorderLayout());
//
//        //Custom university panel on the left
//        UniversityDropdownPanel uniLocationPanel = new UniversityDropdownPanel();
//        this.add(uniLocationPanel, BorderLayout.WEST);
//

//
      //TEMP testing for red dots on map
       ArrayList<String> arr = new ArrayList<String>();
       ArrayList<String> arr2 = new ArrayList<String>();
       University nyit = new University("New York Institute of Technology", "USA");
       University kyoto = new University("Kyoto University", "Japan");


       Student student1 = new Student("Aron", "Lin", 18, "Asian", nyit, "CS", arr, arr2);
       Student student2 = new Student("Rita", "Chen", 18, "Asian", kyoto, "CS", arr, arr2);
       mapPanel.addPin(nyit, student1);
       mapPanel.addPin(kyoto, student2);
//
//
//        //this actionListener is for interactive dropdown selection: the circle will show up depending on what the user selects
//        //it should work once it gets hooked to the "create" button
////        JComboBox<University> uniDropdown = uniLocationPanel.getUniversityDropDown();
////        uniDropdown.addActionListener(e ->{
////            University selectedUni = (University) uniDropdown.getSelectedItem();
////            if(selectedUni!= null){
////                student1.setUniversity((selectedUni));
////                mapPanel.highlightCountry(selectedUni);
////                mapPanel.addPin(selectedUni, student1);
////            }
////        });
//
        this.setVisible(true);


    }


}
