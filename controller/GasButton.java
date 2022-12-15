import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasButton extends JButton {
    public GasButton(List<Vehicle> vehicles, SpinnerButton gasSpinner) {
        super("Gas");
        addActionListener(new ActionListener() { // This actionListener is for the gas button only
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.gas(gasSpinner.GetGasValue());
                }
            }
        });
    }
}