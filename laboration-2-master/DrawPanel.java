import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//import java.util.HashMap;
//import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
    // CarModel model;

    public DrawPanel(int x, int y /* , CarModel model */) { // Initializes the panel and reads the images
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // this.model = model;
        try { // Print an error message in case file is not found with a try/catch block
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) { // This method is called each time the panel updates/refreshes/repaints
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x + 100, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x + 200, scaniaPoint.y, null);
    }
    // @Override
    // protected void paintComponent(Graphics g) {
    // for (Vehicle vehicle : model.getVehicles()) {
    // // g.drawImage(vehicle.getImage(), vehicle.getX(), vehicle.getY(), null);
    // }
    // }
}
