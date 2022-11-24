public class ProgressivePlatform implements Platform {
    private double angle = 0;

    public ProgressivePlatform() {}

    public double getAngle() {
        return angle;
    }

    public boolean isRaised() {
        return angle != 0;
    }
    
    public void raise() {
        angle = Math.min(angle + 1, 70.0);        
    }

    public void lower() {
        angle = Math.max(angle - 1, 0);
    }
}
