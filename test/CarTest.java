import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class CarTest {
    private Volvo240 car;

    @Before
    public void setup() {
        car = new Volvo240();
    }

    /*
    @Test
    public void testGas() {
        car.gas();
    }
    */

    @Test
    public void testTurnLeft() {
        car.turnLeft();
        assertEquals(car.getDirection(), Direction.WEST);
        car.turnLeft();
        assertEquals(car.getDirection(), Direction.SOUTH);
        car.turnLeft();
        assertEquals(car.getDirection(), Direction.EAST);
        car.turnLeft();
        assertEquals(car.getDirection(), Direction.NORTH);
    }
    
    @Test
    public void testTurnRight() {
        car.turnRight();
        assertEquals(car.getDirection(), Direction.EAST);
        car.turnRight();
        assertEquals(car.getDirection(), Direction.SOUTH);
        car.turnRight();
        assertEquals(car.getDirection(), Direction.WEST);
        car.turnRight();
        assertEquals(car.getDirection(), Direction.NORTH);
    }

    @Test
    public void testMovement() {
        car.startEngine();
        car.turnRight();
        car.move();
        assertEquals(car.getPosition(), new Position(1, 0, Direction.EAST));
        car.turnRight();
        car.move();
        assertEquals(car.getPosition(), new Position(1, -1, Direction.SOUTH));
        car.turnRight();
        car.move();
        assertEquals(car.getPosition(), new Position(0, -1, Direction.WEST));
        car.turnRight();
        car.move();
        assertEquals(car.getPosition(), new Position(0, 0, Direction.NORTH));
    }


}
