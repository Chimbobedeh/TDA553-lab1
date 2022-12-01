import java.awt.*;

public abstract class Car extends Vehicle {
    protected CarEngine engine = new CarEngine();
    
    // CarEngine engine, CarBody body
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
    }
        
    abstract protected double speedFactor();

/*
    public boolean getIsInCarStorage() {
        return isInCarStorage;
    }

    public void setIsInCarStorage(boolean state) {
        isInCarStorage = state;
    }

    public void WhenInCareStorage(){
        if(isInCarStorage == true){
            

        }
    }
*/
}