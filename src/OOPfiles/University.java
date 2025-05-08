/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package src.OOPfiles;

import java.io.Serializable;

//We implement Serializable interface so that Student objects can be turned into a stream of bytes and saved to a file.
//University class should implement it as well, because Student class has instance of University class type.
public class University implements Serializable {
    //University instance variables.
    private static final long serialVersionUID = 1L;
    private String universityName;
    private String universityCountry;


    //Default constructor.
    public University(){
        this.universityName = "Sample university name";
        this.universityCountry = "Sample university country";
    }

    //Constructor to create new "University".
    public University(String universityName, String universityCountry){
        this.universityName = universityName;
        this.universityCountry = universityCountry;
    }


    //Getter methods to provide read-only access for instance variables.
    public String getUniversityName(){
        return universityName;
    }
    public String getUniversityCountry(){
        return universityCountry;
    }


    //Setter methods to access or change the value of non-final instance variables.


    public void setUniversityName(String universityName) {this.universityName = universityName;}
    public void setUniversityCountry(String universityCountry) {this.universityCountry = universityCountry;}


    //toString method to display all attributes at one.
    @Override
    public String toString(){
        return ("University Name: " + this.universityName + "\n" +
                "University's Country of Location: " + this.universityCountry + "\n\n");
    }
}



