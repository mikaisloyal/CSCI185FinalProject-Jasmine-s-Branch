import UniversityFiles.*;
import javax.swing.*;

public class NetworkPage extends JFrame{
    public NetworkPage(){
        this.setSize(1600,960);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Network");

        //Creating custom panel from UniversityDropDownPanel class
        UniversityDropdownPanel uniLocationPanel = new UniversityDropdownPanel();
        this.add(uniLocationPanel);

        this.setVisible(true);
    }
}