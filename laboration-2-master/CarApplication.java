
public class CarApplication {

    public static void main(String[] args) {
        CarModel model = new CarModel();
        CarController controller = new CarController(model);
        Vehicle volvo = new Volvo240();
        Vehicle saab = new Saab95();
        Vehicle scania = new Scania();

        saab.setPosition(new Position(110.0, 0.0));
        scania.setPosition(new Position(220.0, 0.0));

        model.addVehicle(volvo);
        model.addVehicle(saab);
        model.addVehicle(scania);

        CarView view = new CarView("CarSim 1.0", model, controller);

        // DrawPanel drawPanel = new DrawPanel(0, 0);

        // model.addVehicle(new Saab95());
        // model.addVehicle(new Scania());

        // model.addVehicle(DrawableVehicleFactory.createSaab());
        // model.addVehicle(DrawableVehicleFactory.createScania());
        /*
         * 
         * drawPanel.add(DrawableVehicleFactory.createSaab(saab));
         * drawPanel.add(DrawableVehicleFactory.createScania(scania));
         * drawPanel.add(DrawableVehicleFactory.createVolvo(volvo));
         */

        model.addObserver(view);
        model.start();
    }
}
