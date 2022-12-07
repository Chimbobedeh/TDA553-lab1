import java.awt.*;
import java.util.*;

public class CarTransporter extends Truck implements ICarStorage {
    // mby duplicering TODO
    private final int maximumCapacityOfCars = 5;
    private ArrayList<Car> loadedCars = new ArrayList<Car>();
    
    public CarTransporter() {
        super(2, 125, 0, Color.red, "CarTransporter", new BinaryPlatform());
    }

    /*
    It's possible to load/unload the cartransport while it's moving. One solution is to override the methods from Vehicle to Truck which increment/decrement the speed and then add an extra condition before calling the super method. E.g.
    @Override void startEngine(){ if(platform.isInValidPosition()){ super.startEngine() } else{ ... } }
    */

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    public boolean isLoaded(Car car) {
        return loadedCars.contains(car);
    }

    public boolean isCarWithinRange(Car car) {
        return this.distanceTo(car) <= 2;
    }

    public void loadCar(Car car) {
        if (isRampActive() 
            && loadedCars.size() < maximumCapacityOfCars
            && isCarWithinRange(car)
            && this.getCurrentSpeed() == 0.0
        ) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (isRampActive()
                && loadedCars.size() > 0
                && isLoaded(car)
                && loadedCars.indexOf(car) == loadedCars.size() - 1
                && this.getCurrentSpeed() == 0.0
            ) {
            loadedCars.remove(car);
            Position currentPos = getPosition();
            Position newPosition = new Position(
                currentPos.getX(), currentPos.getY() - 1.0
            );
            car.setPosition(newPosition);
        }
    }


    /*
    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars) {
            car.move(this.currentSpeed);
        }
    }
    */
}
