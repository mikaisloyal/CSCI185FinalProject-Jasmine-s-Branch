import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MapPanel extends JPanel {
    private BufferedImage worldMap;
    private String selectedCountry = null;
    private final HashMap<String, Point> countryCoordinates = new HashMap<>();

    public MapPanel(){

        try{
            worldMap = ImageIO.read(new File("../assets/worldMap.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not load map image!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //setting preferred size to original image size
        if (worldMap != null){
            this.setPreferredSize(new Dimension(worldMap.getWidth(), worldMap.getHeight()));
        }

        //Initializing original pixel coordinates for each country
        countryCoordinates.put("USA", new Point(775, 973));
        countryCoordinates.put("Canada", new Point(751, 683));
        countryCoordinates.put("Australia", new Point(3345, 1659));
        countryCoordinates.put("Germany", new Point(1948, 834));
        countryCoordinates.put("India", new Point(2719, 1163));
        countryCoordinates.put("Japan", new Point(3368, 957));
    }

    public void highlightCountry(String countryName){
        if(countryCoordinates.containsKey(countryName)) {
            this.selectedCountry = countryName;
            repaint();
        }
    }

    //making sure that the image actually shows up
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (worldMap != null){
            //this resizes the image to fit inside the panel
            g.drawImage(worldMap, 0, 0, getWidth(), getHeight(), this);
        }

        //will only draw something is a country has been selected and its in coordinate
        if(selectedCountry != null && countryCoordinates.containsKey(selectedCountry)){
            //cast graphics and grabs coordinates for the selected country
            Graphics2D g2 = (Graphics2D) g;
            Point originalPoint = countryCoordinates.get(selectedCountry);

            //calculates how much the image was resized (coordinates will be consistent even if panel is scaled)
            double scaleX = (double)getWidth() / worldMap.getWidth();
            double scaleY = (double) getHeight() / worldMap.getHeight();

            //takes origianl coordinates and applies the scaling
            int x = (int) (originalPoint.x * scaleX);
            int y = (int)(originalPoint.y * scaleY);

            //the emoji
            g2.setFont(new Font("SansSerif", Font.PLAIN, 20));
            g2.drawString(getEmojiLabel(selectedCountry), x, y);
        }
    }

    //Getting the pin emoji
    private String getEmojiLabel(String country){
        return "📍";
    }

}


