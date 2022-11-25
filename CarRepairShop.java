import java.util.*;

public class CarRepairShop implements CarStorage {
    // mby duplicering TODO
    private Position position;
    private final int maximumCapacityOfCars = 50;
    private ArrayList<Car> loadedCars = new ArrayList<Car>();

    public CarRepairShop() {
    }

    // Create a representation of a car repair shop. The following aspects must be
    // addressed:

    // NOTE: This shares alot of functionality with CarTransporter.

    // A workshop must be able to receive ("load"?) a number of cars, up to a
    // maximum number that can vary between different workshops.
    // Cars can only be loaded if they are reasonably close to the workshop.
    // When a car is unloaded, it should then end up reasonably close to the
    // workshop.

    public boolean isCarWithinRange(Car car) {
        return position.distanceTo(car.getPosition()) <= 2;
    }

    public void loadCar(Car car) {
        if (loadedCars.size() < maximumCapacityOfCars) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (loadedCars.size() > 0 && loadedCars.contains(car)) {
            loadedCars.remove(car);
            // TODO: Move the other car?
        }
    }
}