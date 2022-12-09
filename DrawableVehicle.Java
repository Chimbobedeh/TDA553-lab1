import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class DrawableVehicle extends JComponent {
    private BufferedImage image;
    private Vehicle vehicle;

    public DrawableVehicle(BufferedImage image, Vehicle vehicle) {
        this.image = image;
        this.vehicle = vehicle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
