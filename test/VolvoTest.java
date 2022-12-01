import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.*;
import java.awt.*;

public class VolvoTest {
    private Volvo240 volvo;
   

    @Before
    public void setup() {
        volvo = new Volvo240();
        
    }

    @After
    public void stop_the_volvo_after_test() {
        volvo.stopEngine();
    }

    @Test
    public void is_volvo_name_set() {
        assertEquals(volvo.getModelName(), "Volvo240");
    }

        @Test
    public void is_Nr_Doors_set() {
        assertEquals(volvo.getNrDoors(), 4);
    }

    @Test
    public void is_engine_power_correct() {
        assertEquals(volvo.getEnginePower(), 100.0, 0.0);
    }

    @Test
    public void is_color_of_volvo_correct() {
        assertEquals(volvo.getColor(), Color.black);
    }

    @Test
    public void can_we_set_new_color_on_volvo() {
        volvo.setColor(Color.blue);
        assertEquals(volvo.getColor(), Color.blue);
    }

    @Test
    public void is_volvo_engine_started() {
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1, 0.0);
    }

    @Test
    public void is_volvo_engine_stopped() {
        volvo.stopEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.0, 0.0);
    }

    @Test
    public void is_brake_set_and_decreases_speed() {
        volvo.startEngine();
        volvo.brake(1.0);
        assertEquals(volvo.getCurrentSpeed(), 0.0, 0.0);
    }

    @Test
    public void gas_not_work_outside_interval() {
        volvo.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(5.0);
        });
    }

    @Test
    public void break_not_work_outside_interval() {
        volvo.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(5.0);
        });
    }

    @Test
    public void is_gas_set_and_increases_speed() {
        volvo.startEngine();
        volvo.gas(1.0);
        assertEquals(volvo.getCurrentSpeed(), 2.0, 1.0);
    }

    @Test
    public void testTurnLeft() {
        volvo.turnLeft();
        assertEquals(volvo.getDirection(), Direction.WEST);
        volvo.turnLeft();
        assertEquals(volvo.getDirection(), Direction.SOUTH);
        volvo.turnLeft();
        assertEquals(volvo.getDirection(), Direction.EAST);
        volvo.turnLeft();
        assertEquals(volvo.getDirection(), Direction.NORTH);
    }

    @Test
    public void testTurnRight() {
        volvo.turnRight();
        assertEquals(volvo.getDirection(), Direction.EAST);
        volvo.turnRight();
        assertEquals(volvo.getDirection(), Direction.SOUTH);
        volvo.turnRight();
        assertEquals(volvo.getDirection(), Direction.WEST);
        volvo.turnRight();
        assertEquals(volvo.getDirection(), Direction.NORTH);
    }

    @Test
    public void testMovement() {
        volvo.startEngine();
        volvo.turnRight();
        volvo.move();
        assertEquals(volvo.getPosition(), new Position(0.1, 0, Direction.EAST));
        volvo.turnRight();
        volvo.move();
        assertEquals(volvo.getPosition(), new Position(0.1, -0.1, Direction.SOUTH));
        volvo.turnRight();
        volvo.move();
        assertEquals(volvo.getPosition(), new Position(0, -0.1, Direction.WEST));
        volvo.turnRight();
        volvo.move();
        assertEquals(volvo.getPosition(), new Position(0, 0, Direction.NORTH));
    }


    @Test
    public void brake_does_not_increase_speed() {
        volvo.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.brake(-1);
        });
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0);
    }

    @Test
    public void gas_does_not_decrease_speed() {
        volvo.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            volvo.gas(-1);
        });
    }

    @Test
    public void speed_cannot_exceed_engine_power() {
        double maxPower = volvo.getEnginePower();
        for (int i = 0; i < (int) maxPower + 5; i++) {
            volvo.gas(1.0);
        }
        assertEquals(volvo.getCurrentSpeed(), volvo.getEnginePower(), 0.0);
    }

    @Test
    public void speed_does_not_go_below_zero() {
        volvo.startEngine();
        for (int i = 0; i <= (int) volvo.getCurrentSpeed() + 5; i++) {
            volvo.brake(1);
        }
    }

}
