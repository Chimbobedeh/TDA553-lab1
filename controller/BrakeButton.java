import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrakeButton extends JButton {
    public BrakeButton(List<Vehicle> vehicles, SpinnerButton gasSpinner) {
        super("Brake");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.brake(gasSpinner.GetGasValue());
                }
            }
        });
    }
}