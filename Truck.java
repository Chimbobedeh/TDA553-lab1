import java.awt.*;

public class Truck extends Vehicle {
    private IPlatform platform;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName,
            IPlatform platform) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.platform = platform;
    }

    public IPlatform getPlatform() {
        return platform;
    }

    public boolean isRampDown() {
        return !platform.isRaised();
    }

    public void raiseRamp() {
        if (this.getCurrentSpeed() == 0) {
            platform.raise();
        }
    }

    public void lowerRamp() {
        if (this.getCurrentSpeed() == 0) {
            platform.lower();
        }
    }

    @Override
    public void move() {
        if (isRampDown()) {
            super.move();
        }
    }

    public double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

}
