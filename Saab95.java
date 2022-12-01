import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn = false;
    
    
    public Saab95() {
        // TurboEngine, RegularBody
        super(4, 125, 0, Color.red, "Saab95");
    }

    public boolean getTurbo() {
        // return engine.getTurbo();
	    return turboOn;
    }
    
    public void setTurboOn() {
        // engine.setTurboOn();
	    turboOn = true;
    }

    public void setTurboOff() {
        // engine.setTurboOff();
	    turboOn = false;
    }
    
    public double speedFactor() {
        double turbo = 1;
        // if (getTurboOn()) turbo = 1.3;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
}
