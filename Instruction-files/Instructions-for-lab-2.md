In this laboratory assignment, you will continue working on the design and code that you made in Lab 1. You will extend the system with new classes of objects, and will need to make decisions on the best way to do so in order to avoid duplicated code, enable subtype polymorphism and follow the principles of good design covered in the course.

    Be sure to carefully read the instructions and follow the rules and requirements prescribed by the lab document.
    Start by reading the entire lab document and seeing what is required to get approved.
    The code written and approved in this lab will be used later in Laboration 3. 

General rules for laboratory work

    It is not permitted to share, copy or use written code from other groups in any way. On the other hand, it is completely acceptable, in fact encouraged, to discuss the tasks and ideas on how they could be solved. (Note that there is more than one 'correct' way to complete each task.)
    Every group member should participate in writing the code, and be familiar with all the group's code.

Requirements for passing the assignment:

    All tasks must have been completed. The solution must compile and run successfully!
    The questions in Task 4 must all have been answered.
    Any issues assigned by your grader labelled 'critical' must be resolved.

Task 1: Scania

Create a representation of a Scania dump truck (avfallsbil) with the class name Scania. Provide reasonable starting values ​​for all relevant fields. Add a file Scania.java file to the same folder as Volvo240.java and Saab95.java.

Scania should be incorporated into the inheritance hierarchy from Lab 1, but it has additional functionality: it has a platform that can be raised and lowered. Incorporate this into the design so we can keep track of which angle the platform is at, as well as methods to raise and lower it.

The following conditions shall apply:

    The angle of the platform can not be lower than 0o or higher than 70o.
    If the platform has an angle other than 0o then the truck must be stationary. The platform must not be raised if the truck is in motion; and the truck must not be able to drive if the platform is raised.

Add these features to Scania.java. Create a test class for Scania with at least one JUnit test.
Task 2: Car Transporter

Create a representation of a car transporter (biltransport) - i.e. a truck that can transport cars on its flatbed. Give it a class name and file name (your choice). Incorporate the car transport into the inheritance hierarchy in an appropriate way.

Like the Scania truck, the car transport has a "flatbed" in the form of a ramp that can be raised and lowered. Incorporate this in the design appropriately.

Cars must be able to be loaded on and off the car transport. The car transport has a maximum number of cars that it can hold.

The following conditions shall apply:

    The car transport ramp has only two positions, up or down.
    The ramp can only be down if the car transport is stationary. If the ramp is down, the car transport must not move, and if the car transport is moving, the ramp must not be lowered.
    Cars can only be loaded if the ramp is down, and they are reasonably close to the car transport (make your own assumption about what "reasonably close" means, the details are not important).
    Cars can only be unloaded if the ramp is down. They should then end up reasonably close to the car transport.

Important things to keep in mind during this task:

    Avoid code duplication for functionality that is common to several different classes, e.g. Scania and car transport.
    Think about the need for polymorphism for different purposes, and how it affects future extensibility.

Remember to keep your JUnit tests up to date. (Best practice: modify the unit tests before modifying the code.)
Task 3: Car Repair Shop

Create a representation of a car repair shop. The following aspects must be addressed:

    A workshop must be able to receive ("load"?) a number of cars, up to a maximum number that can vary between different workshops
    Cars can only be loaded if they are reasonably close to the workshop.
    When a car is unloaded, it should then end up reasonably close to the workshop.

Try to make it so that there is no duplication between the code for the Scania trucks, car transports and car workshops.
Task 4: Reflection

Write a short text file called lab2reflection.txt that answers the following questions. You may write in Swedish or English.

    Your design probably has a type called something like Car or Vehicle that is a supertype to both Volvo and Scania. What is the contract for gas() and brake() in this type? Do the implementations of gas() and brake() in both Volvo and Scania follow this contract? Does your design follow the Liskov Substitution Principle?
    How did you handle duplicated code between Scania, the car transporters and the repair shops? Explain how you decided when to use subclassing and when to use composition and delegation.
    Did you need to modify the design from lab 1 in order to make these extensions? If so, how could you have noticed that your design from Lab 1 did not follow the Open-Closed Principle before you started working on Lab 2?
