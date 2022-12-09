import java.util.ArrayList;
import java.util.Collection;

public class CarModel {
    private Collection<Vehicle> vehicles;
    private Collection<Observer> observers;

    // private boolean direction = true;
    // private int ticker = 0;
    public CarModel() {
        vehicles = new ArrayList<>(10);
        observers = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void updateModel() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }

        for (Observer o : observers) {
            o.updateObserver();
        }
    }

    public void start() {
        try {
            while (true) {
                Thread.sleep(500);
                updateModel();
            }
        } catch (InterruptedException e) {
        }
    }
}
