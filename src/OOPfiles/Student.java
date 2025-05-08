/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package src.OOPfiles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//We implement Serializable interface so that Student objects can be turned into a stream of bytes and saved to a file.
//Serializable saves and entire Student object to a file and allows us to retrieve the Student object back as an object, not as a String if we used .txt file to safe users' data.
public class Student extends Person implements Serializable {
    //Creating instances.

    //"serialVersionUID" is used to verify class compatibility when retrieving the Student objects from the .dat file(used to store all users/students data).
    // It helps prevent errors if the class definition changes in the future.
    private static final long serialVersionUID = 1L;
    private University university;
    private String major;

    // Using ArrayList for "interests" and "classes" attributes, so we can easily add or remove items.
    // This allows flexibility, since students can gain new interests or drop/add classes over time.
    private ArrayList<String> interests;
    private ArrayList<String> classes;


    //Default constructor.
    public Student(){
        this.university = new University();
        this.major = "Enter your major";
        this.interests = new ArrayList<>(List.of("Sample Interest 1", "Sample Interest 2"));
        this.classes = new ArrayList<>(List.of("Sample class 1", "sample class 2"));
    }


    //Constructor to create new "Student".
    public Student(String firstName, String lastName, int age, String nationality, University university, String major, ArrayList<String> interests, ArrayList<String> classes){
        super(firstName, lastName, age, nationality);
        this.university = university;
        this.major = major;
        this.interests = interests;
        this.classes = classes;
    }


    //Getter methods to provide read-only access for instance variables.
    public University getUniversity(){ return this.university;}
    public String getMajor(){ return this.major;}
    public ArrayList<String> getInterests(){
        ArrayList<String> copyOfThisInterests = new ArrayList<>(this.interests); //Creating a copy of original "Interests" ArrayList.
        return copyOfThisInterests; //Returning a copy of the "Interests" ArrayList to keep the memory address of the original data safe.
    }
    public ArrayList<String> getClasses(){
        ArrayList<String> copyOfThisClasses = new ArrayList<>(this.classes); //Creating a copy of original "Classes" ArrayList.
        return copyOfThisClasses; //Returning a copy of the "Classes" ArrayList to keep the memory address of the original data safe.
    }


    //Setter methods to access or change the value of non-final instance variables.
    public void setUniversity(University university){ this.university = university;}
    public void setMajor(String major) {this.major = major;}
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }
    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }


    //toString method to display all attributes at one.
    @Override
    public String toString(){
        return (super.toString() + this.university.toString() +
                "Major: " + this.major + "\n" +
                "Interests: " + this.interests.toString() + "\n" +
                "Classes: " + this.classes.toString() + "\n\n");
    }
}