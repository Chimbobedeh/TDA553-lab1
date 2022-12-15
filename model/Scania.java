import java.awt.*;

public class Scania extends Truck {
    public Scania() {
        super(2, 125, 0, Color.blue, "Scania", new ProgressivePlatform(), "pics/Scania.jpg");
    }

    public double getPlatformAngle() {
        ProgressivePlatform platform = (ProgressivePlatform) getPlatform();
        return platform.getAngle();
    }
}
