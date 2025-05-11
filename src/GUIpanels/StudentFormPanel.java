/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package GUIpanels;
import UserFiles.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StudentFormPanel extends JPanel{

    //Creating instances
    private JTextField firstNameField, lastNameField;
    private JComboBox<String> ageBox, nationalityBox,  universityCountryBox, universityNameBox, majorBox;
    private MultiSelectionList interstsList, classesList;
    private JButton clearButton, createButton;
    private static ArrayList<Student> studentList;

    public StudentFormPanel(){
        this.setPreferredSize(new Dimension(400, 960));
        this.setBackground(Color.YELLOW);
        this.setLayout(new GridBagLayout());
        this.studentList = new ArrayList<Student>();


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 10, 4, 10); //This line will add space between the edges of the components and its cells
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST; //Setting left alignment for the text


        JLabel header = new JLabel("Student Profile Form");
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridwidth = 2;
        constraints.gridy = 0;
        constraints.gridx = 0;
        this.add(header, constraints);


        constraints.gridwidth = 1;


        addLabel("First Name: ", constraints, 1);
        firstNameField = new JTextField();
        addField(firstNameField, constraints, 2);

        addLabel("Last Name", constraints, 3);
        lastNameField = new JTextField();
        addField(lastNameField, constraints, 4);

        addLabel("Age: ", constraints, 5);
        ageBox = new JComboBox<>();
        for (int i = 0; i<=130; i++){
            ageBox.addItem(String.valueOf(i));
        }
        addField(ageBox, constraints, 6);

        addLabel("Nationality: ", constraints, 7);
        nationalityBox = new JComboBox<>(new String[]{"", "North American", "Canadian", "German", "Russian", "Chinese", "Kyrgyz", "Kazakh", "Other"});
        addField(nationalityBox, constraints, 8);

        addLabel("University's Country of Location: ", constraints, 9);
        universityCountryBox = new JComboBox<>(new String[]{"", "USA", "Australia", "Canada", "Japan", "Germany", "India","Kyrgyzstan"});
        addField(universityCountryBox, constraints, 10);

        addLabel("University Name: ", constraints, 11);
        universityNameBox = new JComboBox<>(new String[]{"", "New York Institute of Technology", "Australian National University","University of Sydney", "Acadia University","Laval University", "University of Cologne", "Harvard", "MIT","University of Leipzig", "University of Delhi", "Kyoto University", "Kuvempu University", "University of Tokyo"});
        addField(universityNameBox, constraints, 12);

        addLabel("Major: ", constraints, 13);
        majorBox = new JComboBox<>(new String[]{"", "Computer Science", "Business", "Art", "Engineering", "Other"});
        addField(majorBox, constraints, 14);

        addLabel("Interests: ", constraints, 15);
        String[] interestOptions = new String[]{"", "AI", "Sports", "Music", "Art", "Reading", "Volunteering", "Handicraft", "Cooking", "Web design", "Foreign Language", "Academic", "Video Games", "Writing", "Blogging", "Sleeping & Eating", "Drawing", "Anime", "Manga", "Tech", "Calligraphy"};
        interstsList = new MultiSelectionList(interestOptions, 10);
        addField(interstsList, constraints, 16);

        addLabel("Classes: ", constraints, 17);
        String[] classesOptions = new String[]{"", "CSCI 185 - Programming II", "MATH 170 - Calculus I", "PHYS 170 - Physics I", "MATH 180 - Calculus II", "PHYS 180 - Physics II", "ACCT 101 - Accounting I", "ARCH 411 - Advanced Structural Concepts I", "BIOL 312 - Pathophysiology"};
        classesList = new MultiSelectionList(classesOptions, 5);
        addField(classesList, constraints, 18);


        //Buttons
        constraints.gridx = 0;
        constraints.gridy = 19;
        clearButton = new JButton("Clear Form");
        this.add(clearButton, constraints);

        constraints.gridy = 20;
        createButton = new JButton("Create Student");
        this.add(createButton, constraints);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Person
                String fname = firstNameField.getText();
                String lname = lastNameField.getText();
                String ageBoxConverter = (String)ageBox.getSelectedItem();
                int age = Integer.parseInt(ageBoxConverter);
                String nat = (String)nationalityBox.getSelectedItem();
                
                // University
                String uniName = (String)universityNameBox.getSelectedItem();
                String uniLocation = (String)universityCountryBox.getSelectedItem();
                University uni = new University(uniName, uniLocation);
                
                // Student
                String maj = (String)majorBox.getSelectedItem();
                
                // ArrayLists
                List<String> interestConverter = interstsList.getSelectedValues();
                ArrayList<String> interest = new ArrayList<String>(interestConverter);

                List<String> classConverter = classesList.getSelectedValues();
                ArrayList<String> classes = new ArrayList<String>(classConverter);         
                
                Student stu = new Student(fname, lname, age, nat, uni, maj, interest, classes);
                studentList.add(stu);
                System.out.println(stu.toString());

                // MapPanel.addPin(new University(), new Student()); // Causing an error. Non static method cannot be referenced in a static context.

                FileManager.saveStudents(studentList);

            }
        });


    }

    //Helper methods

    //A function to prevent repeated creation of the same Labels with constant vertical alignments
    public void addLabel(String text, GridBagConstraints constraints, int y){
        constraints.gridx = 0;
        constraints.gridy = y;
        constraints.gridwidth = 2;
        JLabel label = new JLabel(text);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        this.add(label, constraints);
    }

    //A function to prevent repeated creation of text fields with constant vertical alignment
    public void addField(JComponent field, GridBagConstraints constraints, int y){
        constraints.gridx = 0;
        constraints.gridy = y;
        constraints.gridwidth = 2;
        this.add(field, constraints);
    }

}
