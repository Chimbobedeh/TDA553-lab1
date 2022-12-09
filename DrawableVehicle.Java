import java.awt.*;
import javax.swing.*;

public class DrawableVehicle extends JComponent {
    private Image image;
    private Vehicle vehicle;

    public DrawableVehicle(Image image, Vehicle vehicle) {
        this.image = image;
        this.vehicle = vehicle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, (int) vehicle.getPosition().getX(), (int) vehicle.getPosition().getY(), null);
    }
}
