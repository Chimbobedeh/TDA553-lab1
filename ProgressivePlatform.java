public class ProgressivePlatform implements IPlatform {
    private double angle = 0;

    public ProgressivePlatform() {}

    public ProgressivePlatform(double angle) {
        this.angle = angle;
    }

    public IPlatform clone() {
        return new ProgressivePlatform(angle);
    }

    public double getAngle() {
        return angle;
    }

    public boolean isActive() {
        return angle != 0;
    }
    
    public void raise() {
        angle = Math.min(angle + 1, 70.0);        
    }

    public void lower() {
        angle = Math.max(angle - 1, 0);
    }
}
