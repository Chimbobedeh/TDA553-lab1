import java.awt.*;
import java.util.List;
import java.util.*;

// TODO: Interface for Transporters
// extend Vehicle with Platform

public class CarTransporter extends Car {
    private final int maximumCapacityOfCars = 5;
    private List<Car> loadedCars;
    private BinaryPlatform platform;

    public CarTransporter() {
        super(2, 125, 0, Color.red, "CarTransporter");
        this.platform = new BinaryPlatform();
        this.loadedCars = new ArrayList<Car>();
    }
    /*
        The car transport ramp has only two positions, up or down. /
        The ramp can only be down if the car transport is stationary. /
        If the ramp is down, the car transport must not move. /
        If the car transport is moving, the ramp must not be lowered. /
        Cars can only be loaded if the ramp is down, and they are reasonably close to the car transport.
        Cars can only be unloaded if the ramp is down. They should then end up reasonably close to the car transport.
    */

    public boolean isCarWithinRange(Car car) {
        return this.distanceTo(car) <= 2;
    }

    public void loadCar(Car car) {
        if (!platform.isRaised() && loadedCars.size() < maximumCapacityOfCars) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (!platform.isRaised() && loadedCars.size() > 0 && loadedCars.contains(car)) {
            loadedCars.remove(car);
        }
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

    public double speedFactor() {
        return this.getEnginePower() * 0.01;
        
    }

    @Override
    //Breaks mr N's princple
    public void move() {
        if (!platform.isRaised()) {
            super.move();
        }
    }
}
