import UserFiles.*;
import java.awt.*;
import javax.swing.*;

public class NetworkPage extends JFrame {
    public NetworkPage() {
        this.setSize(1600, 960);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Network");

        //using BorderLayout to place components side by side
        this.setLayout(new BorderLayout());

        //Custom university panel on the left
        UniversityDropdownPanel uniLocationPanel = new UniversityDropdownPanel();
        this.add(uniLocationPanel, BorderLayout.WEST);

        // Map panel on the right
        MapPanel mapPanel = new MapPanel();
        this.add(mapPanel, BorderLayout.CENTER);


        // Hooking University Location dropdown to map panel
        uniLocationPanel.setLocationSelectionListener((String countryName) -> {
            mapPanel.highlightCountry(countryName);
        });


        this.setVisible(true);
    }
}
