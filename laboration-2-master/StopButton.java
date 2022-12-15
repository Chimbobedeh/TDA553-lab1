import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopButton extends JButton {
    private static final int X = 800;

    public StopButton(List<Vehicle> vehicles) {
        super("STOP");

        setBackground(Color.red);
        setForeground(Color.black);
        setPreferredSize(new Dimension(X / 5 - 15, 200));

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.stopEngine();
                }
            }
        });
    }
}