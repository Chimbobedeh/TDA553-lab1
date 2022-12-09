
public class CarApplication {

    public static void main(String[] args) {
        // Instance of this class

        // Start a new view and send a reference of self
        // cc.frame = new CarView("CarSim 1.0", cc);
        CarModel model = new CarModel();
        CarController controller = new CarController(model);
        CarView view = new CarView("Framename", model, controller);

        model.addVehicle(new Volvo240());
        model.addVehicle(new Saab95());
        model.addVehicle(new Scania());

        model.addObserver(view);
        model.start();

    }
}
