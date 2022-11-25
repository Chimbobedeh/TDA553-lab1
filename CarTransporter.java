import java.awt.*;
import java.util.*;

public class CarTransporter extends Truck implements CarStorage {
    // mby duplicering TODO
    private final int maximumCapacityOfCars = 5;
    private ArrayList<Car> loadedCars = new ArrayList<Car>();

    public CarTransporter() {
        super(2, 125, 0, Color.red, "CarTransporter", new BinaryPlatform());
    }

    /*
     * The car transport ramp has only two positions, up or down. /
     * The ramp can only be down if the car transport is stationary. /
     * If the ramp is down, the car transport must not move. /
     * If the car transport is moving, the ramp must not be lowered. /
     * Cars can only be loaded if the ramp is down, and they are reasonably close to
     * the car transport.
     * Cars can only be unloaded if the ramp is down. They should then end up
     * reasonably close to the car transport.
     */

    public boolean isCarWithinRange(Car car) {
        return this.distanceTo(car) <= 2;
    }

    public void loadCar(Car car) {
        if (!isRampDown() && loadedCars.size() < maximumCapacityOfCars) {
            loadedCars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (!isRampDown()
                && loadedCars.size() > 0
                && loadedCars.contains(car)
                && loadedCars.indexOf(car) == loadedCars.size() - 1) {
            loadedCars.remove(car);
            // TODO: Move the other car?
        }
    }
}
