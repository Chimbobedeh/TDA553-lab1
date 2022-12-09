import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller
 * in it's state.
 * It communicates with the Controller by calling methods of it when an action
 * fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements Observer {
    private static final int X = 800;
    private static final int Y = 800;

    CarController controller;
    CarModel model;
    // Components
    DrawPanel drawPanel;
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public CarView(String framename, CarModel model, CarController controller) {
        this.model = model;
        this.controller = controller;
        this.drawPanel = new DrawPanel(X, Y - 240, model);
        initComponents(framename);
    }

    private void initComponents(String title) { // Sets everything in place and fits everything FINE
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
                0, // min
                100, // max
                1);// step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);

        gasButton.addActionListener(new ActionListener() { // This actionListener is for the gas button only
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.callmodelgas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() { // This actionListener is for the gas button only
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.callmodelbrake(gasAmount);
            }
        });

        this.pack(); // Make the frame pack all it's components by respecting the sizes if possible.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Get the computer screen resolution
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2); // Center
                                                                                                                // the
                                                                                                                // frame
        this.setVisible(true); // Make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make sure the frame exits when "x" is pressed
    }

    public void updateObserver() {
        drawPanel.repaint();
    }
}