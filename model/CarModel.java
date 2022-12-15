import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarModel {
    private List<Vehicle> vehicles;
    private Collection<Observer> observers;

    public CarModel() {
        vehicles = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public List<Vehicle> getVehicles() {
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
