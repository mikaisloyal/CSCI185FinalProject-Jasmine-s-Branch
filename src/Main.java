
/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Main {


    public static void main(String[] args) {


        // Main Frame initializing
        JFrame mainFrame = new JFrame("Global Student Network Simulator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800,800);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.orange);
        mainPanel.setLayout(new BorderLayout());

        //Components
        JLabel title = new JLabel("Global Student Network Simulator");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        title.setHorizontalAlignment(0);
        mainPanel.add(title,BorderLayout.NORTH);


        JButton insButton = new JButton("Instructions");
        insButton.setHorizontalAlignment(0);
        insButton.setBackground(Color.cyan);
        mainPanel.add(insButton,BorderLayout.WEST);

        JButton runButton = new JButton("Run");
        runButton.setHorizontalAlignment(0);
        runButton.setBackground(Color.cyan);
        mainPanel.add(runButton,BorderLayout.CENTER);

        // Functionality

        insButton.addActionListener((ActionEvent e) -> {
            Instruction insPage = new Instruction();
        });

        runButton.addActionListener((ActionEvent e) -> {
            mainFrame.dispose();
            NetworkPage netPage = new NetworkPage();
        });


        // mainPanel.add(uniLocationPanel);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        //--------------------Testing Student, Person, CompareConnections classes---------------------------------------
        /*
        University u1 = new University("NYIT", "USA");

        ArrayList<String> i1 = new ArrayList<>(java.util.List.of("math", "cooking"));
        ArrayList<String> c1 = new ArrayList<>(java.util.List.of("math180", "csci185"));
        Student s1 = new Student("Jasi", "T", 21, "Kyrgyz", u1, "CS", i1, c1);

        University u2 = new University("NYIT", "USA");
        ArrayList<String> i2 = new ArrayList<>(java.util.List.of("tattoo", "water bottles"));
        ArrayList<String> c2 = new ArrayList<>(List.of("math180", "csci185"));
        Student s2 = new Student("Rita", "chen", 18, "chineese", u1, "CS", i2, c2);

        //CompareConnections com1 = new CompareConnections(s1, s2);
        //System.out.println(com1.getStrength());
        //System.out.println(com1.toString());

         */


        //------------------------------------Testing File io-----------------------------------------------------------
        /*
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        // ---------------- SAVE students to file ----------------
        FileManager.saveStudents(studentList);
        System.out.println("Saved Jasi and Rita to UsersData.dat");

        // ---------------- LOAD and PRINT ----------------
        ArrayList<Student> loaded = FileManager.loadStudents();
        System.out.println("\n Loaded Students:");
        for (Student s : loaded) {
            System.out.println("-------------------------------------------------");
            System.out.println(s);
        }

        // ---------------- CLEAR the data ----------------
        FileManager.clearStudentData();
        System.out.println("\n Cleared UsersData.dat");

        // ---------------- LOAD again and confirm it's empty ----------------
        ArrayList<Student> afterClear = FileManager.loadStudents();
        System.out.println("\nStudents after clear:");
        if (afterClear.isEmpty()) {
            System.out.println("File is empty. All students cleared!");
        } else {
            for (Student s : afterClear) {
                System.out.println(s);
            }
        }
        */

    }


}




