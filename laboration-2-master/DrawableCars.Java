public class DrawableCars extends JComponent {
    private BufferedImage image;
    private Vehicle vehicle;

    DrawableCars(BufferedImage image, Vehicle vehicle ){
        this.image = image;
        this.vehicle = vehicle;
    }

     @Override
     protected void paintComponent(Graphics g){
        super.paintComponent(g);
     }
}
