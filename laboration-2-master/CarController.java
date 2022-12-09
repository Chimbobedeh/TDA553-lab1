import javax.swing.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JFrame {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    // The timer is started with an listener (see below) that executes the
    // statements each step between delays.
    private CarModel model;

    public CarController(CarModel model) {
        this.model = model;
    }

    // MODEL STUFF
    // public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    // Model

    // MODEL
    // private class TimerListener implements ActionListener {
    // public void actionPerformed(ActionEvent e) {
    // for (Vehicle vehicle : model.getVehicles()) {
    // vehicle.move();
    // }
    // }

    // Calls the gas method for each car once

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
