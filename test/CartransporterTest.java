
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.*;

public class CartransporterTest {

    private CarTransporter transporter;
    private Saab95 saab;

    @Before
    public void setup() {
        transporter = new CarTransporter();
        transporter.stopEngine();
        saab = new Saab95();
        saab.stopEngine();

    }

    @After
    public void after_test() {
        transporter.stopEngine();
        transporter.lowerRamp();
    }

    // Test methods to lower/raise the Platform.
    // The angle of the platform can not be lower than 0o or higher than 70o
    // If the platform has an angle other than 0o then the truck must be stationary
    // The platform must not be raised if the truck is in motion
    // The truck must not be able to drive if the platform is raised.

    @Test
    public void is_ramp_raised() { // Is the ramp-angle not 0
        transporter.raiseRamp();
        assertTrue(!transporter.isRampDown());
    }

    @Test
    public void is_ramp_down() { // Is the ramp-angle exactly 0
        transporter.raiseRamp();
        transporter.lowerRamp();
        assertTrue(transporter.isRampDown());
    }

    @Test
    public void cannot_move_with_platform_raised() { // Is the ramp-angle exactly 0
        transporter.raiseRamp();
        transporter.startEngine();
        transporter.move();
        assertEquals(transporter.getPosition(), new Position(0, 0));
    }

    @Test
    public void cannot_raise_ramp_with_truck_having_speed() { // Is the ramp-angle exactly 0
        transporter.startEngine();
        transporter.raiseRamp();
        assertTrue(transporter.isRampDown());
        // assertEquals(0.0, truck.raiseRamp(), 0);
    }

    @Test
    public void is_another_car_within_range() {
        saab.startEngine();
        saab.gas(0.9);
        saab.move();
        assertTrue(transporter.isCarWithinRange(saab));

    }

    // test_load_car, test_unload_car
    // cannot_unload_not_loaded_car
    // storage_cannot_exceed_maximumCapacity
    // can_only_unload_if_last_in_line
    @Test
    public void test_load_car() {
        // TODO
        saab.startEngine();
        saab.gas(0.9);
        saab.move();
        assertTrue(transporter.isCarWithinRange(saab));

    }

    @Test
    public void test_unload_car() {
        // TODO
        saab.startEngine();
        saab.gas(0.9);
        saab.move();
        assertTrue(transporter.isCarWithinRange(saab));
    }

    @Test
    public void storage_cannot_exceed_maximumCapacity() {
        // TODO
        saab.startEngine();
        saab.gas(0.9);
        saab.move();
        assertTrue(transporter.isCarWithinRange(saab));
    }

    @Test
    public void can_only_unload_if_last_in_line() {
        // TODO
    }
}
