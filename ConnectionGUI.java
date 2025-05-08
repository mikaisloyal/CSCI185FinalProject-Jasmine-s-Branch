import java.awt.*;
import javax.swing.*;
import OOPfiles.*;

/*
rewrite to make it more clear. provides separation and utilizes
encapsulation to prevent external mishaps
 */

public class ConnectionGUI {
    // initializes these variables initially within ConnectionGUI class
    private JFrame frame;
    private JLabel studentsPairedLabel;
    private JProgressBar connectionStrengthBar;

    /*
    initializes the components & layout of ConnectionGUI.
    allows both functions to be called by one single line, while
    simultaneously demonstrating encapsulation (as components and layout are private)
     */
    public ConnectionGUI(){
        ConnectionGUIComponents();
        ConnectionGUILayout();
    }

    /*
    private to allow changes only within the GUI class.
    component method
     */
    private void ConnectionGUIComponents(){
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
        connectionStrengthBar.setPreferredSize(new Dimension(400, 40));
    }

    /*
    private for same case as components.
    layout method
     */
    private void ConnectionGUILayout(){
        // utilizes a GridBagLayout which allows more complex placement of components within a grid
        // GBL allows components to take up multiple spaces as well
        JPanel panel = new JPanel(new GridBagLayout());

        // GBC (GridBagConstraints) places components within designated areas of the GBL
        // gridx & gridy relay the component's position within the GridBag
        GridBagConstraints gbcPairLabel = new GridBagConstraints();
        gbcPairLabel.gridx = 0;
        gbcPairLabel.gridy = 0;

        // since gridy = 1, it is placed BELOW gbcPairLabel
        // weightx required to ensure that the strength bar
        // takes up a fixed amount of space (horizontally)
        GridBagConstraints gbcStrengthBar = new GridBagConstraints();
        gbcStrengthBar.gridx = 0;
        gbcStrengthBar.gridy = 1;
        gbcStrengthBar.weightx = 1;

        // adds studentsPairedLabel (which pairs with gbcPairLabel for the GridBag)
        // same case with connectionStrengthBar & gbcStrengthBar
        panel.add(studentsPairedLabel, gbcPairLabel);
        panel.add(connectionStrengthBar, gbcStrengthBar);

        // adds all functional components (from panel) into the frame
        frame.add(panel);
    }

    // provides the connection strength of two students. only displays first name
    // also changes color based on strength value
    public void setConnectionStrength(Student studentA, Student studentB, int strength) {
        studentsPairedLabel.setText(studentA.getFirstName() +
                                    "'s Connection Strength with " +
                                    studentB.getFirstName() +  " is: " );

        // switch depends on the output of strength divided by 25
        Color strengthBarColor;
        switch( strength / 25 ){
            case 0:
                strengthBarColor = Color.RED;
                break;
            case 1:
                strengthBarColor = Color.ORANGE;
                break;
            case 2:
                strengthBarColor = Color.YELLOW;
                break;
            case 3:
                strengthBarColor = Color.GREEN;
                break;
            default:
                strengthBarColor = Color.GREEN;
                break;
        }

        // sets the connectionStrengthBar to represent these values (strength and regarded bar color)
        connectionStrengthBar.setValue(strength);
        connectionStrengthBar.setForeground(strengthBarColor);
    }
    // displays the frame
    public void display(){ frame.setVisible(true); }
}
