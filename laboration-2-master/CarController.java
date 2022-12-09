import javax.swing.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JFrame {

    private CarModel model;

    public CarController(CarModel model) {
        this.model = model;
    }

    void callmodelgas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : model.getVehicles()) {
            vehicle.gas(gas);
        }
    }

    void callmodelbrake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : model.getVehicles()) {
            vehicle.brake(gas);
        }
    }
}
