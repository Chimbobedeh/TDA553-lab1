import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ControlPanel extends JPanel {
    private static final int X = 800;

    public ControlPanel(List<Vehicle> vehicles, SpinnerButton gasSpinner) {
        setLayout(new GridLayout(2, 4));
        add(new GasButton(vehicles, gasSpinner), 0);
        add(new TurboOnButton(vehicles), 1);
        add(new LiftBedButton(vehicles), 2);
        add(new BrakeButton(vehicles, gasSpinner), 3);
        add(new TurboOffButton(vehicles), 4);
        add(new LowerBedButton(vehicles), 5);

        setPreferredSize(new Dimension((X / 2) + 4, 200));
        setBackground(Color.CYAN);
    }
}
