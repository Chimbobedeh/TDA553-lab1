import java.awt.*;
import java.util.*;

public class CarTransporter extends Truck implements ICarStorage {
    // mby duplicering TODO
    private final int maximumCapacityOfCars = 5;
    private ArrayList<Car> loadedCars = new ArrayList<Car>();
    

    public CarTransporter() {
        super(2, 125, 0, Color.red, "CarTransporter", new BinaryPlatform());
            
    }

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    /*
     * Cars can only be unloaded if the ramp is down. They should then end up
     * reasonably close to the car transport.
     */

    public boolean isLoaded(Car car) {
        return loadedCars.contains(car);
    }

    public boolean isCarWithinRange(Car car) {
        return this.distanceTo(car) <= 2;
    }

    public void loadCar(Car car) {
        if (!isRampDown() 
            && loadedCars.size() < maximumCapacityOfCars
            && isCarWithinRange(car)
        ) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (!isRampDown()
                && loadedCars.size() > 0
                && isLoaded(car)
                && loadedCars.indexOf(car) == loadedCars.size() - 1) {
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
