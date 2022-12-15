public class EngineTurbo extends CarEngine {
    
    private boolean turboOn = false;

    public boolean getTurbo() {
	    return turboOn;
    }
    
    public void setTurboOn() {
	    turboOn = true;
    }

    public void setTurboOff() {
	    turboOn = false;
    }
}
