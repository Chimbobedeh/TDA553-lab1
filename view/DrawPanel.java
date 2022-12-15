import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel {
    CarModel model;

    public DrawPanel(int x, int y, CarModel model) { // Initializes the panel and reads the images
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.model = model;
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
