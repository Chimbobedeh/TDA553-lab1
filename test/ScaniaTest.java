import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.*;
import java.awt.*;

public class ScaniaTest {
    private Scania truck;

    @Before
    public void setup() {
        truck = new Scania();
        truck.stopEngine();
    }


    @After
    public void after_test() {
        truck.stopEngine();
        truck.lowerRamp();
    }


    // Test methods to lower/raise the Platform.
    // The angle of the platform can not be lower than 0o or higher than 70o
    // If the platform has an angle other than 0o then the truck must be stationary
    // The platform must not be raised if the truck is in motion
    // The truck must not be able to drive if the platform is raised.

    @Test
    public void is_ramp_raised(){ //Is the ramp-angle not 0
        truck.raiseRamp();
        assertTrue(!truck.isRampDown());
    }

    @Test
    public void is_ramp_down(){ //Is the ramp-angle exactly 0
        truck.raiseRamp();
        truck.lowerRamp();
        assertTrue(truck.isRampDown());
    }

    @Test
    public void angle_not_lower_than_zero(){ //Is the ramp-angle exactly 0
        truck.lowerRamp();
        assertEquals(0.0, truck.getPlatformAngle(), 0);
    }

    @Test
    public void angle_cannot_raise_higher_than_70() {
        for (int i = 0; i <= 75; i++) {
            truck.raiseRamp();
        }
        assertEquals(70.0, truck.getPlatformAngle(), 0);
    }
    
    @Test
    public void cannot_move_with_platform_raised(){ //Is the ramp-angle exactly 0
        truck.raiseRamp();
        truck.startEngine();
        truck.move();
        assertEquals(truck.getPosition(), new Position(0,0));
    }

    @Test
     public void cannot_raise_ramp_with_truck_having_speed(){ //Is the ramp-angle exactly 0
        truck.startEngine();
        truck.raiseRamp();
        assertEquals(0.0, truck.getPlatformAngle(), 0);
    }
}
