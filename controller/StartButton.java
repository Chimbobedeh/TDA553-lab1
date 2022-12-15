import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton {
    private static final int X = 800;

    public StartButton(List<Vehicle> vehicles) {
        super("Start");
        setBackground(Color.green);
        setForeground(Color.black);
        setPreferredSize(new Dimension(X / 5 - 15, 200));

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.startEngine();
                }
            }
        });
    }
}