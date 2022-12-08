import java.awt.*;

public class Truck extends Vehicle {
    private IPlatform platform;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName,
            IPlatform platform) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.platform = platform;
    }

    public IPlatform getPlatform() {
        return platform.clone();
    }

    public boolean isRampActive() {
        return platform.isActive();
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
        if (!isRampActive()) {
            super.move();
        }
    }

    @Override
    public void gas(double amount) {
        if (!isRampActive()) {
            super.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (!isRampActive()) {
            super.brake(amount);
        }
    }

    @Override
    public void startEngine() {
        if (!isRampActive()) {
            super.startEngine();
        }
    }

    public double speedFactor() {
        return this.getEnginePower() * 0.01;
    }

}
