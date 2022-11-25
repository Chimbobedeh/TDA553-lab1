import java.awt.*;

/*

Scania should be incorporated into the inheritance hierarchy from Lab 1, but it has additional functionality: 
it has a platform that can be raised and lowered. 
Incorporate this into the design so we can keep track of which angle the platform is at, as well as methods to raise and lower it.

The following conditions shall apply:

The angle of the platform can not be lower than 0o or higher than 70.
If the platform has an angle other than 0o then the truck must be stationary. 
The platform must not be raised if the truck is in motion; and the truck must not be able to drive if the platform is raised.
Add these features to Scania.java. Create a test class for Scania with at least one JUnit test.

*/
public class Scania extends Truck {
    public Scania() {
        super(2, 125, 0, Color.blue, "Scania", new ProgressivePlatform());
    }

    public double getPlatformAngle() {
        // Not very good looking
        ProgressivePlatform platform = (ProgressivePlatform) getPlatform();
        return platform.getAngle();
    }
}
