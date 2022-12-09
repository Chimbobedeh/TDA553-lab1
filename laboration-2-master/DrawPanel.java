import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;

import javax.swing.*;

public class DrawPanel extends JPanel {
    Collection<DrawableVehicle> drawables;
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    DrawableVehicle volvo;

    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    CarModel model;

    public DrawPanel(int x, int y, CarModel model) { // Initializes the panel and reads the images
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.model = model;
    }

    public void addDrawableCar(DrawableVehicle drawable) {
        drawables.add(drawable);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : model.getVehicles()) {
            g.drawImage(vehicle.getImage(), (int) vehicle.getPosition().getX(), (int) vehicle.getPosition().getY(),
                    null);
        }
    }

}
