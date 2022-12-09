import java.awt.*;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, String path) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, path);
    }

    abstract protected double speedFactor();
}