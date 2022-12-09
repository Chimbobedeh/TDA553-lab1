import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawbleCarsFactory {

    public static DrawableCars create_saab_image(Vehicle car) {
        Image saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab94.jpg"));
        return new DrawableCars(saabImage, car);
    }

    public static DrawableCars create_volvo_image(Vehicle car) {
        Image volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        return new DrawableCars(volvoImage, car);
    }

}
