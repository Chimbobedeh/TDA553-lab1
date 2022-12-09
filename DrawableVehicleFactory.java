import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;



public class DrawableVehicleFactory {
    public static DrawableVehicle createSaab(Vehicle car) {
        Image saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab94.jpg"));
        return DrawableVehicle(saabImage, car);
    }

    public static DrawableVehicle createVolvo(Vehicle car) {
        Image volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        return new DrawableVehicle(volvoImage, car);
    }

}
