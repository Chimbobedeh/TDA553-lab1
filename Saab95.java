import java.awt.*;

public class Saab95 extends Car {

    public boolean turboOn = false;

    
    public Saab95() {
        super(4, 125, 0, Color.red, "Saab95");
    }
    
    public void setTurboOn() {
	    turboOn = true;
    }

    public void setTurboOff() {
	    turboOn = false;
    }
    
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
    /*
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    */
}
