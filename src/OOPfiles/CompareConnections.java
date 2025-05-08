/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package src.OOPfiles;

public class CompareConnections {

    //Creating instances.
    private Student studentA, studentB;

    //Strength is going to be assigned following the table below.
    //------------Connections Strength Calculations Table------------
    //---Feature-----Points given if same----------Total=100
    //First Name------------5-------------
    //Last Name-------------5-------------
    //Age-------------------10------------
    //Nationality-----------10------------
    //University Name ------15------------
    //University Location --15------------
    //Major-----------------10------------
    //Interests-------------1*10=10-------1 point per each common interest (Interests user can choose are limited to 10)
    //Classes---------------4*5=20--------4 points per each common class (Classes user can choose are limited to 5)
    private int strength = 0;

    //Default constructor.
    public CompareConnections(){
        this.studentA = new Student();
        this.studentB = new Student();
        this.strength = 0;
    }

    //Constructor to compare students and assign them the level of connection strength.
    public CompareConnections(Student studentA, Student studentB){
        this.studentA = studentA;
        this.studentB = studentB;

        if (this.studentA.getFirstName().equals(this.studentB.getFirstName())){
            this.strength += 5;
        }
        if (this.studentA.getLastName().equals(this.studentB.getLastName())){
            this.strength += 5;
        }
        if (this.studentA.getAge() == this.studentB.getAge()){
            this.strength += 10;
        }
        if (this.studentA.getNationality().equals(this.studentB.getNationality())){
            this.strength += 10;
        }
        if (this.studentA.getUniversity().getUniversityName().equals(this.studentB.getUniversity().getUniversityName())){
            this.strength += 15;
        }
        if (this.studentA.getUniversity().getUniversityCountry().equals(this.studentB.getUniversity().getUniversityCountry())){
            this.strength += 15;
        }
        if (this.studentA.getMajor().equals(this.studentB.getMajor())){
            this.strength += 10;
        }

        for(String interestStudentA : this.studentA.getInterests()){
            for (String interestStudentB : this.studentB.getInterests()){
                if(interestStudentA.equals(interestStudentB)){
                    this.strength += 10;
                }
            }
        }

        for(String classStudentA : this.studentA.getClasses()){
            for (String classStudentB : this.studentB.getClasses()){
                if(classStudentA.equals(classStudentB)){
                    this.strength += 4;
                }
            }
        }
    }

    //Getter methods to provide read-only access for instance variables.
    public int getStrength() {return strength;}

    //No setter method for this.strength, because user cannot set it manually. It is supposed to be calculated by comparing the attributes of each student.

    //toString method to display all attributes at one.
    @Override
    public String toString(){
        return ("------Student A------" + "\n" + this.studentA.toString() + "\n" +
                "------Student B------" + "\n" + this.studentB.toString() + "\n" +
                "Level of Connection Strength: " + this.strength + "\n\n");
    }
}
