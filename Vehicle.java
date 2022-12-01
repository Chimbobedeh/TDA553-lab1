import java.awt.*;

public abstract class Vehicle implements IMovable {
    private final int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;
    private Position position;
    //private CarEngine engine;
    
    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.position = new Position(0.0, 0.0);
    }

    abstract protected double speedFactor();

    private void incrementSpeed(double amount) {
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

    public String getModelName() {
        return modelName;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position pos) {
        position = pos;
    }

    public double distanceTo(Car otherCar) {
        return position.distanceTo(otherCar.getPosition());
    }

    public Direction getDirection() {
        return position.getDirection();
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
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
        } else {
            throw new IllegalArgumentException("Gas amount out of range.");
        }
    }

    public void brake(double amount) {
        if (0.0 <= amount && amount <= 1.0) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Brake amount out of range.");
        }
    }
}

