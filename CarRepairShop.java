import java.util.*;

public class CarRepairShop implements CarStorage {
    // mby duplicering TODO
    private Position position;
    private final int maximumCapacityOfCars = 50;
    private ArrayList<Car> loadedCars = new ArrayList<Car>();

    public CarRepairShop() {
    }

    // When a car is unloaded, it should then end up reasonably close to the
    // workshop.

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }
    
    public boolean isLoaded(Car car) {
        return loadedCars.contains(car);
    }

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