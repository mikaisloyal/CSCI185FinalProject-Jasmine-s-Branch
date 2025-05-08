/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package src.OOPfiles;

// Person is an abstract class because we never create a generic "person" directly.
// It's only meant to be extended by specific roles like Student.
// This keeps our design clean, prevents accidental instantiation, and enforces proper inheritance.

import java.io.Serializable;


//We implement Serializable interface so that Student objects can be turned into a stream of bytes and saved to a file.
//Person class should implement it as well, because Student class extends Person..
public abstract class Person implements Serializable {
    //Creating instances.

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private int age;
    private final String nationality;


    //Default constructor.
    protected Person(){
        this.firstName = "Enter your first name";
        this.lastName = "Enter your last name";
        this.age = 0;
        this.nationality = "Enter your nationality";
    }


    //Constructor to create new "Person".
    protected Person(String firstName, String lastName, int age, String nationality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }


    //Getter methods to provide read-only access for instance variables.
    public String getFirstName(){ return this.firstName;}
    public String getLastName(){ return this.lastName;}
    public int getAge(){ return this.age;}
    public String getNationality(){ return this.nationality;}


    //Setter methods to access or change the value of non-final instance variables.
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //toString method to display all attributes at one.
    public String toString(){
        return ("First Name: " + this.firstName + "\n" +
                "Last Name: " + this.lastName + "\n" +
                "Age: " + this.age + "\n" +
                "Nationality: " + this.nationality + "\n\n");
    }
}
