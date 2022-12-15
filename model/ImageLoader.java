import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try { // Print an error message in case file is not found with a try/catch block
            image = ImageIO.read(DrawPanel.class.getResourceAsStream(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }
}