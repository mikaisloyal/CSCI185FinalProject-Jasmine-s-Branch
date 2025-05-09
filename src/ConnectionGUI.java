import java.awt.*;
import javax.swing.*;

public class ConnectionGUI{
    // sets up JFrame, JLabel, and JProgressBar in the public class as to
    // allow it to be modified more aptly within the ConnectionGUI class
    // alongside providing clarity + modularity
    private JFrame frame;
    private JLabel studentsPairedLabel;
    private JProgressBar connectionStrengthBar;

    public ConnectionGUI(){

        // Connection Strength GUI will currently act as its own separate GUI
        // for the sake of building the figure ASAP

        // frame which acts as the GUI's own window application
        frame = new JFrame("Connection Strength Comparator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // initializes a blank studentsPairedLabel
        studentsPairedLabel = new JLabel();
        // sets the label to utilize a font to appear more in-place
        studentsPairedLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // initializes a JProgressBar to display the Connection Strength
        // (which is limited between 0 - 100 as a range)
        connectionStrengthBar = new JProgressBar(0, 100);
        connectionStrengthBar.setStringPainted(true); // allows users to see the percentage numerically
        connectionStrengthBar.setSize(400, 40);

        // utilizes a GridBagLayout which allows more complex placement of components within a grid
        // GBL allows components to take up multiple spaces as well
        JPanel panel = new JPanel(new GridBagLayout());

        // GBC (GridBagConstraints) places components within designated areas of the GBL
        // gridx & gridy relay the component's position within the GridBag
        GridBagConstraints gbcPairLabel = new GridBagConstraints();
        gbcPairLabel.gridx = 0;
        gbcPairLabel.gridy = 0;

        // since gridy = 1, it is placed BELOW gbcPairLabel
        GridBagConstraints gbcStrengthBar = new GridBagConstraints();
        gbcStrengthBar.gridx = 0;
        gbcStrengthBar.gridy = 1;

        // adds studentsPairedLabel (which pairs with gbcPairLabel for the GridBag)
        // same case with connectionStrengthBar & gbcStrengthBar
        panel.add(studentsPairedLabel, gbcPairLabel);
        panel.add(connectionStrengthBar, gbcStrengthBar);

        // adds all functional components (from panel) into the frame
        frame.add(panel);

        // utilizes a separate public method as means of Encapsulation
        // and providing dynamic outputs in response to real-time changes that may occur
        // in ConnectionEngine. Student must also be located within to ensure that
        // student names are changed in real-time, in correspondence with connection strength
        // for each pairing
        // for clarification later on - real-time changes occur within ConnectionEngine
        public void setConnectionStrength(Student studentA, Student studentB, int strength){
            studentsPairedLabel.setText(studentA.getName() + "'s Connection Strength with " + studentB.getName() + " is: ");
            connectionStrengthBar.setValue(strength);
        }

    }
    // displays the frame in a separate method to ensure clarity
    public void display(){ frame.setVisible(true); }
}
