# Laboration 2 - reflective assignment.

/*
Write a short text file called lab2reflection.txt that answers the following questions. You may write in Swedish or English.

    1. Your design probably has a type called something like Car or Vehicle that is a supertype to both Volvo and Scania. What is the contract for gas() and brake() in this type? Do the implementations of gas() and brake() in both Volvo and Scania follow this contract? Does your design follow the Liskov Substitution Principle?

    2. How did you handle duplicated code between Scania, the car transporters and the repair shops? Explain how you decided when to use subclassing and when to use composition and delegation.

    3. Did you need to modify the design from lab 1 in order to make these extensions? If so, how could you have noticed that your design from Lab 1 did not follow the Open-Closed Principle before you started working on Lab 2?
*/

1. AAA

2. BBB

3. CCC

Yes we had to modify the desgin from lab 1 in order to get to the point we're at now. In lab 1 we had car as our superclass and Volvo and Saab as subclass of it. As we now have another type of Vehicle (Scania and CarTransporter) to take into regard thus we chose to call the superclass Vehicle instead.
So Vehicle is our new superclass and then Car and Truck are subclasses to it. Scania and CarTransporter are then subclasses to Truck, VolVo and Saab are sublcasses to Car.

If we would've thougt a bit harder about what would happen if we were to add other types of vehicles instead of only cars we probably would've realised that our design was faulty
