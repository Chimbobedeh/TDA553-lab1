import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawableVehicleFactory {
    public static DrawableVehicle createSaab(Vehicle car) {
        BufferedImage volvoImage = loadImage("pics/Saab94.jpg");
        return new DrawableVehicle(volvoImage, car);
    }

    public static DrawableVehicle createVolvo(Vehicle car) {
        BufferedImage volvoImage = loadImage("pics/Volvo240.jpg");
        return new DrawableVehicle(volvoImage, car);
    }

    private static BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try { // Print an error message in case file is not found with a try/catch block
            image = ImageIO.read(DrawPanel.class.getResourceAsStream(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }
}
