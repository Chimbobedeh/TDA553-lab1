# Laboration - reflective assignment.

/*
Write a short text file named lab1reflection.txt that answers the following questions. You can write in Swedish or English.

    1. Explain how you chose the inheritance hierarchy in Task 1, making reference to the Open-Closed Principle:
        Open-closed Principle (OCP) states: Objects or entities should be open for extension but closed for modification

    2. Explain how you implemented each of the sanity checks in Task 4:
        gas() and brake() only accept values in the interval [0,1],
        currentSpeed always lies in the interval [0 , enginePower],
        calls to gas() cannot result in the speed decreasing, and
        calls to brake() cannot result in the speed increasing.
*/

1. We reviewed the sourcecode and found areas where the defined class "Volvo240" and "Saab95" had similar (duplicated) attributes and methods which we could move to a an abstract class which we chose to call "Car".
We chose the name car as the classes Volvo240 and Saab95 are different car models hence they are both cars.
With this we moved the functionality for nrDoors, enginePower, currentSpeed, color and modelName to the new class "Car" since these were used in both Volvo240 and Saab95. Methods with
similar or same functionality were also moved to "Car". With this change we could remove the constructors in Volvo240 and Saab95 to make the code less redundant, and instead create a single constructor in "Car".
Which we then could use to instantiate either Volvo240 or Saab95

Volvo240 and Saab95 was changed to extend the class "Car" and inherit all functionality from Car. The attributes and methods unique to Volvo and Saab respectively was implemented in
their own classes.

This change directly follows the OCP (Open-Closed-Principle) as we have abstracted the common functionalty to "Car" making the code more modular, since we can easily extend the code to include
more carmodels (The "Open" part from OCP) and their unique functionality without the need for changing the already implemented subclasses (Volvo and Saab) and the superclass "Car" (The "Closed" part from OCP).


2. One can assure that an arbitrary value passed to `gas()` or `brake()` is within a specified interval by encapsulating 
the `gas`and `break` functions respectively in an if-statement with the condition that the value lies within the interval. This also asserts 
that calls to `gas()` won't result in currentSpeed decreasing, and calls to `brake()` won't result in the speed increasing. 

Any attempt to call on `gas()` or `break()` using arguments outside the parameter will simply not fall under any of the if-statements, and therefor not change the speed.
Arguments are to given between the intervall [0,1], any arguments outside of this range will not work (meaning wont make a difference in currentSpeed).

```java
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
```

currentSpeed is a private attribute that can only be modified through calling the public gas / break functions, 
using Math.max and Math.min we can assert that currentSpeed never falls below zero, and never exceeds enginePower. 
```java
private void incrementSpeed(double amount){
    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
}

private void decrementSpeed(double amount) {
    currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
}
```
    