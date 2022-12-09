import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawableVehicleFactory {
    public static DrawableVehicle createSaab(Vehicle vehicle) {
        BufferedImage saabImage = loadImage("pics/Saab94.jpg");
        return new DrawableVehicle(saabImage, vehicle);
    }

    public static DrawableVehicle createVolvo(Vehicle vehicle) {
        BufferedImage volvoImage = loadImage("pics/Volvo240.jpg");
        return new DrawableVehicle(volvoImage, vehicle);
    }

    public static DrawableVehicle createScania(Vehicle vehicle) {
        BufferedImage scaniaImage = loadImage("pics/Scania.jpg");
        return new DrawableVehicle(scaniaImage, vehicle);
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
