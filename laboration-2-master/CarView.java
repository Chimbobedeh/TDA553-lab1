import javax.swing.*;
import java.awt.*;

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

    // Components
    private DrawPanel drawPanel;
    private CarController controller;

    public CarView(String framename, CarModel model, CarController controller) {
        this.controller = controller;
        this.drawPanel = new DrawPanel(X, Y - 240, model);
        initComponents(framename);
    }

    private void initComponents(String title) { // Sets everything in place and fits everything FINE
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        this.add(controller);

        this.pack(); // Make the frame pack all it's components by respecting the sizes if possible.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Get the computer screen resolution
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true); // Make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Make sure the frame exits when "x" is pressed
    }

    public void updateObserver() {
        drawPanel.repaint();
    }
}
