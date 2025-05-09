/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */
package FileIO;

import src.OOPfiles.Student;
import java.io.*;
import java.util.ArrayList;

//"FileManager" class will manage the way users' data is saved. "UsersData.dat" is going to be used to store the data as an ArrayList of "Students".
//We DON'T save students one by one, instead we:
// 1. Load the entire list of previously saved students.
// 2. Add the new student to the list.
// 3. Save the entire list back to the file.

// As an example, the below code should be implemented in the ActionListener of the "Create" button:
// ArrayList<Student> allStudents = FileManager.loadStudents(); -> Reads current list from file
// allStudents.add(newStudent); -> Adds one new student to the list
// FileManager.saveStudents(allStudents); -> Overwrites the file with the new list

public class FileManager {
    private static final String usersDataFile = "UsersData.dat";

    //"saveStudents" method is going to be used after creating a new user. We should add a new "Student" to the list and save the list using method below.
    public static void saveStudents(ArrayList<Student> students) {

        //"ObjectOutputStream" is a built-in Java class that will let us write whole objects ("Students") to a "UsersData.dat" file.
        //"FileOutputStream" in default mode will erase all data inside a "UsersData.dat" file because it opens the file in overwrite mode.
        //That’s why it’s important to load, update, and save the same list after every change!

        //Note that the below line won’t keep creating new files every time we save. Tt just uses the one file unless it’s missing.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(usersDataFile))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //The below method is going to be used to retrieve a list of all previously saved "Students".
    public static ArrayList<Student> loadStudents() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(usersDataFile))) {
            return (ArrayList<Student>) in.readObject();
        } catch (EOFException e) {
            // File exists but is empty — return empty list.
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            // Any other problem (file missing, class not matching, etc.).
            return new ArrayList<>();
        }
    }


    //"clearStudentData" is supposed to be used after user presses "Clear" button.
    public static void clearStudentData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(usersDataFile))) {
            out.writeObject(new ArrayList<>()); // Overwrites the data file with an empty list
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
