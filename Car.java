import java.awt.*;

public abstract class Car implements Movable {
    
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Position position;

    public Car (int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.position = new Position(0, 0);
    }

    abstract public double speedFactor();

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return position.getDirection();
    }

    public void setColor(Color clr) {
	    color = clr;
    }

    public void startEngine() {
	    currentSpeed = 1;
    }

    public void stopEngine() {
	    currentSpeed = 0;
    }

    public void move() {
        position.move(this.currentSpeed);
    }

    public void turnLeft() {
        position.decrementDirection();
    }

    public void turnRight() {
        position.incrementDirection();
    }
    
    public void gas(double amount) {
        if (0.0 <= amount && amount <= 1.0) {
            incrementSpeed(amount);
        }
    }
    
    public void brake(double amount) {
        if (0.0 <= amount && amount <= 1.0) {
            decrementSpeed(amount);

        }
    }
}