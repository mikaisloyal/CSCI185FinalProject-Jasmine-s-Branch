/*
ProjectName
CSCI 185
M03
Aron Lin, Rita Chen, Htoo Naing, Zhasmin Tuiachieva
Date of last contribution (Use the date on Github commit)
*/

package GUIpanels;
import UserFiles.University;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.*;

//this is a panel class: making a custom panel that can be created in the main class
public class UniversityDropdownPanel extends JPanel{
    //Creating instance ComboBox (dropdowns) variables
    private JComboBox<String> locationDropdown;
    private JComboBox<University> universityDropDown; //will be using information from the University class

    //Using a HashMap to organize the university by its location (will help narrow the university search)
    //The location (String) is the "key" and points to the list of universities (University), which is the "value"
    private static Map<String, List<University>> universityMap = new HashMap<>();

    public UniversityDropdownPanel(){
        //Creating sample data
        List<University> usUniversities = List.of(
                new University("New York Institute of Technology", "USA"),
                new University("Harvard", "USA")
        );
        List<University> australiaUniversities = List.of(
                new University("Australian National University", "Australia"),
                new University("University of Sydney", "Australia")
        );
        List<University> canadaUniversities = List.of(
                new University("Acadia University", "Canada"),
                new University("Laval University", "Canada")
        );
        List<University> germanyUniversities = List.of(
                new University("University of Cologne", "Germany"),
                new University("University of Leipzig", "Germany")
        );
        List<University> indiaUniversities = List.of(
                new University("University of Delhi", "India"),
                new University("Kuvempu University", "India")
        );
        List<University> japanUniversities = List.of(
                new University("Kyoto University", "Japan"),
                new University("University of Tokyo", "Japan")
        );

        //Adding all the sample data to the HashMap
        universityMap.put("USA", usUniversities);
        universityMap.put("Australia", australiaUniversities);
        universityMap.put("Canada", canadaUniversities);
        universityMap.put("Germany", germanyUniversities);
        universityMap.put("India", indiaUniversities);
        universityMap.put("Japan", japanUniversities);

        //Creating new instances of the location and university dropdowns
        //this locationDropdown will contain the hashmap
        locationDropdown = new JComboBox<>();
        //the dropdown will start off blank
        locationDropdown.addItem(" ");
        for (String country : universityMap.keySet()){
            //this dropdown will contain all the countries from the universityMap hashmap
            locationDropdown.addItem(country);
        }
        universityDropDown = new JComboBox<>();

        //Adding action listener for the locationDropdown combobox, using lambda
        locationDropdown.addActionListener(e ->{
            //getting current selected country and storing it as a String
            String selectedCountry = (String)locationDropdown.getSelectedItem();
            universityDropDown.removeAllItems();//clears out existing items so it doesn't stack

            //Skip if invalid things are selected
            if (!universityMap.containsKey(selectedCountry)){
                return;
            }

            List<University> uniList = universityMap.get(selectedCountry);
            if (uniList != null) {
                //this loop gets the list of all the University objects for the current selected country
                for (University u : uniList) {
                    universityDropDown.addItem(u);
                }
            }
        });

        //Adding all components to panel
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Select Location:"));
        this.add(locationDropdown);
        this.add(new JLabel("Select University:"));
        this.add(universityDropDown);
    }

    //collecting the currently selected university (object) from the dropdown
    public University getSelectedUniversity(){
        return (University) universityDropDown.getSelectedItem();
    }

    //lets another class react when a location is picked
    //using Consumer T for more flexibility (logic is passed in from the outside)
    public void setLocationSelectionListener(Consumer<University> listener){
        locationDropdown.addActionListener(e ->{
            //getting the selected country from the location dropdown
            String selectedCountry = (String) locationDropdown.getSelectedItem();
            universityDropDown.removeAllItems();//clears all current entries from university dropdown

            List<University> uniList = universityMap.get(selectedCountry);
            if (uniList != null) {
                //loops through universityMap hashmap to gather all universities in the selected country
                for (University u : uniList) {
                    universityDropDown.addItem(u);
                }
            }
        });
    }

    //dropdown getter
    public JComboBox<University> getUniversityDropDown(){
        return universityDropDown;
    }


}

