import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerButton extends JSpinner {
    private int gasAmount;

    public SpinnerButton() { // Sets everything in place and fits everything FINE
        super(new SpinnerNumberModel(0, // initial value
                0, // min
                100, // max
                1));// step

        addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
    }

    public double GetGasValue() {
        return gasAmount / 100.0;
    }

}