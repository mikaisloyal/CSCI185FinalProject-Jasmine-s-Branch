/*
Project Title: Global Student Network Simulator
Course: Spring 2025 - M03 - Computer Programming II
Contributors: Zhasmin Tuiachieva, Htoo Naing, Rita Chen, Aron Lin
Date of Last Contribution: 5/12/2025 (MM/DD/YYYY)
 */

package GUIpanels;

import UserFiles.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MapPanel extends JPanel implements MouseListener {
    private BufferedImage worldMap;
    private String selectedCountry = null;
    private final HashMap<String, Point> countryCoordinates = new HashMap<>();
    private ArrayList<Student> arr;

    //Creating a mini Pin class
    private static class Pin {
        //Instance variables
        int x;
        int y;
        //studentName is a placeholder for when we actually get the name...
        //note to use: String studentName = student.getFirstName();
        //this name will appear above the pin
        Student stu;
        String studentName;
        //button portion
        boolean selected = false;

        //Constructor
        Pin(int x, int y, Student stuName) {
            this.x = x;
            this.y = y;
            this.stu = stuName;
            this.studentName = stuName.getFirstName() + " " + stuName.getLastName();
        }
    }


    public MapPanel() {
        arr = new ArrayList<Student>();
        this.addMouseListener(this);//adding the listener
        try {
            // worldMap = ImageIO.read(new File("../assets/worldMap.jpg"));
            worldMap = ImageIO.read(new File("assets/worldMap.jpg"));
        } catch (IOException e) {
            System.out.println("Could not load map image!");
        }

        //setting preferred size to original image size
        if (worldMap != null) {
            this.setPreferredSize(new Dimension(worldMap.getWidth(), worldMap.getHeight()));
        }

        //Initializing original pixel coordinates (hashmap) for each country
        countryCoordinates.put("USA", new Point(775, 973));
        countryCoordinates.put("Canada", new Point(751, 683));
        countryCoordinates.put("Australia", new Point(3345, 1659));
        countryCoordinates.put("Germany", new Point(1948, 834));
        countryCoordinates.put("India", new Point(2719, 1163));
        countryCoordinates.put("Japan", new Point(3368, 957));
    }

    //create pin array list
    private List<Pin> pins = new ArrayList<>();


    //tells the map to highlight the selected country
    public void highlightCountry(University uniCountry) {
        //getting country from university
        String country = uniCountry.getUniversityCountry();
        //checks if the country has a coordinate on the hashmap
        if (countryCoordinates.containsKey(uniCountry.getUniversityName())) {
            //sets a new variable to this panel--so that we can tell the map to highlight only the countryName
            this.selectedCountry = country;
            repaint();
        }
    }


    //USE: mapPanel.addPin(parameters)
    public void addPin(University university, Student studentName) {
        String country = university.getUniversityCountry();
        //checks if the country has coordinates
        if (countryCoordinates.containsKey(country)){
            Point coords = countryCoordinates.get(country);
            //adding new pin with the coords and name
            pins.add(new Pin(coords.x, coords.y, studentName));
            repaint(); //refreshes the panel to show the new pin
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //drawing sclaed map image
        if (worldMap != null) {
            g.drawImage(worldMap, 0, 0, getWidth(), getHeight(), this);
        }

        //scaling
        double scaleX = (double) getWidth() / worldMap.getWidth();
        double scaleY = (double) getHeight() / worldMap.getHeight();

        //drawing pin and student name
        for (Pin pin : pins) {
            int scaledX = (int) (pin.x * scaleX);
            int scaledY = (int) (pin.y * scaleY);

            //drwaing the pin ( red circle)
            g.setColor(Color.RED);
            g.fillOval(scaledX - 5, scaledY - 5, 10, 10);

            //drawing the student name above the pin
            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            g.drawString(pin.studentName, scaledX - 15, scaledY - 10);
        }
    }


    //clear pins using this method--for "reset" button
    //USE: mapPanel.clearPins();
    public void clearPins() {
        pins.clear();
        repaint();//redrawing map with no pins
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        ArrayList<Student> arr = new ArrayList<Student>();
        int mouseX = m.getX();
        int mouseY = m.getY();

        //scaling has to be the same as paintComponent
        double scaleX = (double) getWidth() / worldMap.getWidth();
        double scaleY = (double) getHeight() / worldMap.getHeight();

        //looping through all pins to check which ones got clicked
        for (Pin pin : pins) {
            int scaledX = (int) (pin.x * scaleX);
            int scaledY = (int) (pin.y * scaleY);

            int radius = 10;
            Rectangle hitBox = new Rectangle(scaledX - radius / 2, scaledY - radius / 2, radius, radius);

            if (hitBox.contains(mouseX, mouseY)) {
                if(arr.size() <= 2){
                    if (arr.size() == 2) {
                        System.out.println("Limiter reached");
                    } else {
                        arr.add(pin.stu);
                    }
                }
                System.out.println("Selected: " + pin.studentName);
                //NOTE: add button functionality here:
                break;
            }
        }
    }
        //overriding all the methods given by MouseListener
        @Override
        public void mouseEntered(MouseEvent m){
        }
        @Override
        public void mouseExited (MouseEvent m){
        }
        @Override
        public void mousePressed (MouseEvent m){
        }
        @Override
        public void mouseReleased (MouseEvent m){
        }
}




