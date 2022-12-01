import java.awt.*;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }
        
    abstract protected double speedFactor();
}