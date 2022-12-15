import javax.swing.*;
import java.awt.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JPanel {
    private CarModel model;
    private ControlPanel controlPanel;
    private JLabel gasLabel = new JLabel("Amount of gas");
    private SpinnerButton gasSpinner = new SpinnerButton();

    public CarController(CarModel model) {
        this.model = model;
        this.controlPanel = new ControlPanel(model.getVehicles(), gasSpinner);

        JPanel gasPanel = new JPanel();
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        add(gasPanel);
        add(controlPanel);
        add(new StartButton(model.getVehicles()));
        add(new StopButton(model.getVehicles()));
    }
}
