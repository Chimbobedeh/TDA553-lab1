import java.util.*;

public class CarRepairShop implements ICarStorage {
    private Position position = new Position(0.0, 0.0);
    private final int maximumCapacityOfCars = 50;
    private ArrayList<Car> loadedCars = new ArrayList<Car>();

    public CarRepairShop() {
    }

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isLoaded(Car car) {
        return loadedCars.contains(car);
    }

    public boolean isCarWithinRange(Car car) {
        return position.distanceTo(car.getPosition()) <= 2;
    }

    public void loadCar(Car car) {
        if (loadedCars.size() < maximumCapacityOfCars && isCarWithinRange(car)) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (loadedCars.size() > 0 && loadedCars.contains(car)) {
            loadedCars.remove(car);
            Position newPosition = new Position(
                    position.getX(), position.getY() - 1.0);
            car.setPosition(newPosition);
        }
    }
}
