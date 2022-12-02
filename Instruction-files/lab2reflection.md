# Laboration 2 - reflective assignment.

/*
Write a short text file called lab2reflection.txt that answers the following questions. You may write in Swedish or English.

    1. Your design probably has a type called something like Car or Vehicle that is a supertype to both Volvo and Scania. What is the contract for gas() and brake() in this type? Do the implementations of gas() and brake() in both Volvo and Scania follow this contract? Does your design follow the Liskov Substitution Principle?

    2. How did you handle duplicated code between Scania, the car transporters and the repair shops? Explain how you decided when to use subclassing and when to use composition and delegation.

    3. Did you need to modify the design from lab 1 in order to make these extensions? If so, how could you have noticed that your design from Lab 1 did not follow the Open-Closed Principle before you started working on Lab 2?
*/

1. We have created the type `Vehicle` which is the supertype to all the vehicles that are able to drive (within our domain). The supertype `Vehicle` contains the methods `gas()` and `brake()`.

The contract for these methods are the following:
-The arguments has to be a double within the range [0.0, 1,0].
-Giving an argument out of the specified range will throw an "IllegalArgumentException" exception.
-gas and brake will (given the correct arguments) call on incrementSpeed(argument) and decrementSpeed(amount) respectively.

Volvo, Saab, Scania and CarTransporter do not have their own `gas()` and `brake()` defined, they inherit these methods from the supertype `Vehicle`. We believe the vehicles in our domain do not differ between how they gas and brake (unless we were to introduce electric cars, which we have thought about and decided will not exist in our domain, sorry world). 

With that being said, the design does follow the Liskov Substitution Principle in regards to these particular methods. All the sublcasses can in principle replace Vehicle and still have the `gas()` and `brake()` methods work without major (or any) changes to the code for the methods.

Code for `gas()` and `brake()`: 
```Java
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
```


2. We created an interface, `ICarStorage`. We chose interfacing over subclassing, since the implementation differs between the RepairShop and CarTransporter; the CarTransporter needs to have its ramp lowered before loading a Car, and its cars can only be unloaded in reverse order from how they were loaded. 

We created another subclass of Vehicle, `Truck`, which represents a vehicle with a platform. We chose to use subclassing because Truck is an extension of the functionality found in Vehicle. The `Truck` constructor takes an `IPlatform` as argument, which it then delegates to. We chose to create an interface for Platform types, since different types of Platforms have different behaviour.

3. Yes we had to modify the desgin from lab 1 in order to get to the point we're at now. In lab 1 we had car as our superclass and Volvo and Saab as subclass of it. As we now have two other types of Vehicles (Scania and CarTransporter) to take into regard thus we chose to make another class caleld "Truck", which we made as our new superclass instead.
So as Vehicle is our new superclass then Car and Truck are subclasses to it. Scania and CarTransporter are then subclasses to Truck, VolVo and Saab are sublcasses to Car.

If we would've thougt a bit harder about what would happen if we were to add vehicles of other engine types and body types. Let's take a Ferrari which has a trim body and a Turbo engine. Or a car with no turbo and trim, or a car without any of them. The code we had written for Lab 1 has that as a fault, engine is not open for extension as it's not a even a class and the same goes for car body, so they cant handle a new type of car e.x Ferrari which should have a trimbody and a turboengine. This is what broke the Open Closed Principle in our code from Lab 1.
